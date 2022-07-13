package array;

import java.util.Arrays;

/**
 * 移动零
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2ba4i/
 */
public class MoveZeros {
    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        moveZeros3(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void moveZeros1(int[] nums) {
        if (nums.length < 2) {
            return;
        }
        int left = 0;
        int right = 1;
        while (right < nums.length) {
            if (nums[left] != 0) {
                if (nums[right] != 0) {
                    left++;
                    right++;
                } else {
                    left++;
                }
            } else {
                if (nums[right] == 0) {
                    right++;
                } else {
                    nums[left] = nums[right];
                    nums[right] = 0;
                    left++;
                    right++;
                }
            }
        }
    }

    public static void moveZeros2(int[] nums) {
        if (nums.length < 2) {
            return;
        }
        int index = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != 0) {
                nums[index] = nums[j];
                index++;
            }
        }
        for (int i = index; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    public static void moveZeros3(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[index];
                nums[index] = temp;
                index++;
            }
        }
    }
}
