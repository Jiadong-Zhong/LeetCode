import java.util.Arrays;

/**
 * 719. 找出第 K 小的数对距离
 * https://leetcode.cn/problems/find-k-th-smallest-pair-distance/
 */
public class SmallestDistancePair {
    public static void main(String[] args) {
        int[] nums = {6,3,10,12,8,16};
        int k = 3;
        SmallestDistancePair solution = new SmallestDistancePair();
        int ans = solution.smallestDistancePair2(nums, k);
        System.out.println(ans);
    }

    public int smallestDistancePair1(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length, left = 0, right = nums[n - 1] - nums[0];
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int count = 0;
            for (int j = 0; j < n; j++) {
                int i = binarySearch(nums, j, nums[j] - mid);
                count += j - i;
            }
            if (count >= k) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public int binarySearch(int[] nums, int end, int target) {
        int left = 0, right = end;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    // 排序+二分+双指针
    public int smallestDistancePair2(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length, left = 0, right = nums[n - 1] - nums[0];
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int count = 0;
            for (int i = 0, j = 0; j < n; j++) {
                while (nums[j] - nums[i] > mid) {
                    i++;
                }
                count += j - i;
            }
            if (count >= k) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
