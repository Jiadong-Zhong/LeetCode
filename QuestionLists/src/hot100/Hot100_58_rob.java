package hot100;

/**
 * 198. 打家劫舍
 * https://leetcode.cn/problems/house-robber/
 */
public class Hot100_58_rob {
    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        Hot100_58_rob solution = new Hot100_58_rob();
        int ans = solution.rob2(nums);
        System.out.println(ans);
    }

    // 动态规划
    public int rob1(int[] nums) {
        int length = nums.length;
        int[] dp1 = new int[length + 1]; // 1表示当天没有偷
        int[] dp2 = new int[length + 1]; // 2表示当天已经偷了
        dp1[0] = 0;
        dp2[0] = 0;
        for (int i = 1; i <= length; i++) {
            dp1[i] = Math.max(dp1[i - 1], dp2[i - 1]);
            dp2[i] = Math.max(dp1[i - 1] + nums[i - 1], dp2[i - 1]);
        }
        return Math.max(dp1[length], dp2[length]);
    }

    // 优化存储空间
    public int rob2(int[] nums) {
        int length = nums.length;
        int dp1 = 0; // 1表示当天没有偷
        int dp2 = 0; // 2表示当天已经偷了
        for (int i = 1; i <= length; i++) {
            int dp1_before = dp1;
            int dp2_before = dp2;
            dp1 = Math.max(dp1_before, dp2_before);
            dp2 = Math.max(dp1_before + nums[i - 1], dp2_before);
        }
        return Math.max(dp1, dp2);
    }

    // 题解
    public int rob3(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }
        int first = nums[0], second = Math.max(nums[0], nums[1]);
        for (int i = 2; i < length; i++) {
            int temp = second;
            second = Math.max(first + nums[i], second);
            first = temp;
        }
        return second;
    }
}
