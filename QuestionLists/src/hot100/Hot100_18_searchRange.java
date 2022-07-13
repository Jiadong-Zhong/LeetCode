package hot100;

import java.util.Arrays;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/
 */
public class Hot100_18_searchRange {
    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int target = 8;
        Hot100_18_searchRange solution = new Hot100_18_searchRange();
        int[] res = solution.searchRange2(nums, target);
        System.out.println(Arrays.toString(res));
    }

    // 自己写的
    public int[] searchRange1(int[] nums, int target) {
        int[] res = new int[2];
        res[0] = -1;
        res[1] = -1;

        int n = nums.length;
        if (n == 0) {
            return res;
        }

        int left = 0;
        int right = n - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                int leftIndex = mid;
                while (leftIndex >= 1 && nums[leftIndex - 1] == nums[leftIndex]) {
                    leftIndex--;
                }
                res[0] = leftIndex;
                int rightIndex = mid;
                while (rightIndex <= n - 2 && nums[rightIndex] == nums[rightIndex + 1]) {
                    rightIndex++;
                }
                res[1] = rightIndex;
                return res;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }

    // 题解
    public int[] searchRange2(int[] nums, int target) {
        int leftIdx = binarySearch(nums, target, true);
        int rightIdx = binarySearch(nums, target, false) - 1;
        if (leftIdx <= rightIdx && rightIdx < nums.length && nums[leftIdx] == target && nums[rightIdx] == target) {
            return new int[]{leftIdx, rightIdx};
        }
        return new int[]{-1, -1};
    }

    public int binarySearch(int[] nums, int target, boolean lower) {
        int left = 0, right = nums.length - 1, ans = nums.length;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target || (lower && nums[mid] >= target)) {
                right = mid - 1;
                ans = mid;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
}
