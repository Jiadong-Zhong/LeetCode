import java.util.Arrays;

/**
 * 213. 打家劫舍 II
 * https://leetcode.cn/problems/house-robber-ii/
 */
public class Rob {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
    }

    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        } else if (n == 2) {
            return Math.max(nums[0], nums[1]);
        }
        return Math.max(robRange(Arrays.copyOfRange(nums, 0, nums.length - 1)), robRange(Arrays.copyOfRange(nums, 1, nums.length)));
    }

    public int robRange(int[] nums) {
        int pre = 0, cur = 0, temp;
        for (int num : nums) {
            temp = cur;
            cur = Math.max(pre + num, cur);
            pre = temp;
        }
        return cur;
    }
}
