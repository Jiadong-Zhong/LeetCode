package array;

import java.util.Arrays;

/**
 * 删除排序数组中的重复项
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2gy9m/
 */
public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(removeDuplicates1(nums));
        System.out.println(Arrays.toString(nums));
    }

    // 自己写的
    public static int removeDuplicates1(int[] nums) {
        int length = nums.length;
        int index = 0;
        while (index < length) {
            if (index + 1 < length && nums[index] == nums[index + 1]) {
                for (int j = index + 1; j < length - 1; j++) {
                    nums[j] = nums[j + 1];
                }
                length--;
            } else {
                index++;
            }
        }
        return length;
    }

    // 优化（双指针）
    public static int removeDuplicates2(int[] nums) {
        int left = 0;
        int right = 1;
        while (right < nums.length) {
            if (nums[left] == nums[right]) {
                right++;
            } else {
                left++;
                nums[left] = nums[right];
            }
        }
        return left + 1;
    }
}
