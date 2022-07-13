package sword_to_offer;

import java.util.HashSet;
import java.util.Set;

/**
 * 剑指 Offer 57. 和为s的两个数字
 * https://leetcode.cn/problems/he-wei-sde-liang-ge-shu-zi-lcof/
 */
public class Offer57_twoSum {
    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;
    }

    // 哈希表
    public int[] twoSum1(int[] nums, int target) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(target - num)) {
                return new int[] {num, target - num};
            } else {
                set.add(num);
            }
        }
        return new int[0];
    }

    // 双指针
    public int[] twoSum2(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            if (nums[left] == target - nums[right]) {
                return new int[] {nums[left], nums[right]};
            } else if (nums[left] < target - nums[right]) {
                left++;
            } else {
                right--;
            }
        }
        return new int[0];
    }
}
