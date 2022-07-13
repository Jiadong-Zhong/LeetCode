package sword_to_offer;

/**
 * 剑指 Offer 51. 数组中的逆序对
 * https://leetcode.cn/problems/shu-zu-zhong-de-ni-xu-dui-lcof/
 */
public class Offer51_reversePairs {
    public static void main(String[] args) {
        int[] nums = {7,5,6,4};
        Offer51_reversePairs solution = new Offer51_reversePairs();
        int ans = solution.reversePairs(nums);
        System.out.println(ans);
    }

    public int reversePairs(int[] nums) {
        int length = nums.length;
        if (length < 2) {
            return 0;
        }

        int[] temp = new int[length];
        return reversePairs(nums, 0, length - 1, temp);
    }

    public int reversePairs(int[] nums, int left, int right, int[] temp) {
        if (left == right) {
            return 0;
        }
        int mid = left + (right - left) / 2;
        int leftPairs = reversePairs(nums, left, mid, temp);
        int rightPairs = reversePairs(nums, mid + 1, right, temp);

        if (nums[mid] <= nums[mid + 1]) {
            return leftPairs + rightPairs;
        }

        int crossPair = mergeAndCount(nums, left, mid, right, temp);
        return leftPairs + rightPairs + crossPair;
    }

    public int mergeAndCount(int[] nums, int left, int mid, int right, int[] temp) {
        for (int i = left; i <= right; i++) {
            temp[i] = nums[i];
        }

        int i = left;
        int j = mid + 1;
        int count = 0;
        for (int k = left; k <= right; k++) {
            if (i == mid + 1) {
                nums[k] = temp[j];
                j++;
            } else if (j == right + 1) {
                nums[k] = temp[i];
                i++;
            } else if (temp[i] <= temp[j]) {
                nums[k] = temp[i];
                i++;
            } else {
                nums[k] = temp[j];
                j++;
                count += (mid - i + 1);
            }
        }
        return count;
    }
}
