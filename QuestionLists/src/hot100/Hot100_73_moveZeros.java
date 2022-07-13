package hot100;

import java.util.Arrays;

/**
 * 283. 移动零
 * https://leetcode.cn/problems/move-zeroes/
 */
public class Hot100_73_moveZeros {
    public static void main(String[] args) {
        int[] nums = {0,1};
        Hot100_73_moveZeros solution = new Hot100_73_moveZeros();
        solution.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void moveZeroes(int[] nums) {
        int left = 0, right = 0;
        while (right < nums.length) {
            if (nums[right] != 0) {
                swap(nums, left, right);
                left++;
            }
            right++;
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
