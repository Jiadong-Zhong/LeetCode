package hot100;

/**
 * 416. 分割等和子集
 * https://leetcode.cn/problems/partition-equal-subset-sum/
 */
public class Hot100_87_canPartition {
    public static void main(String[] args) {
        int[] nums = {1, 5, 11, 5};
        Hot100_87_canPartition solution = new Hot100_87_canPartition();
        boolean ans = solution.canPartition2(nums);
        System.out.println(ans);
    }

    // 动态规划
    public boolean canPartition1(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return false;
        }
        int sum = 0;
        int maxNum = 0;
        for (int num : nums) {
            sum += num;
            maxNum = Math.max(maxNum, num);
        }

        if (sum % 2 == 1) {
            return false;
        }

        int target = sum / 2;

        if (maxNum > target) {
            return false;
        }

        boolean[][] dp = new boolean[n][target + 1];
        // dp[i][j]表示从数组的[0,i]范围内选取若干个整数，是否存在一种方案使被选取的整数和为j
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }
        dp[0][nums[0]] = true;

        for (int i = 1; i < n; i++) {
            int num = nums[i];
            for (int j = 1; j <= target; j++) {
                if (j >= num) {
                    dp[i][j] = dp[i - 1][j] | dp[i - 1][j - num];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n - 1][target];
    }

    // 优化空间
    public boolean canPartition2(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return false;
        }

        int sum = 0, maxNum = 0;
        for (int num : nums) {
            sum += num;
            maxNum = Math.max(maxNum, num);
        }

        if (sum % 2 == 1) {
            return false;
        }

        int target = sum / 2;
        if (maxNum > target) {
            return false;
        }

        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int i = 0 ;i < n; i++) {
            int num = nums[i];
            for (int j = target; j >= num; j--) {
                dp[j] |= dp[j - num];
            }
        }
        return dp[target];
    }
}
