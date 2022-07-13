/**
 * 剑指 Offer II 091. 粉刷房子
 * https://leetcode.cn/problems/JEj789/
 */
public class MinCost {
    public static void main(String[] args) {
        int[][] costs = {{17,2,17},{16,16,5},{14,3,19}};
        MinCost solution = new MinCost();
        int ans = solution.minCost1(costs);
        System.out.println(ans);
    }

    // 动态规划
    public int minCost1(int[][] costs) {
        int n = costs.length;
        int[][] dp = new int[n][3];
        for (int j = 0; j < 3; j++) {
            dp[0][j] = costs[0][j];
        }
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + costs[i][0];
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + costs[i][1];
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + costs[i][2];
        }
        return Math.min(dp[n - 1][0], Math.min(dp[n - 1][1], dp[n - 1][2]));
    }

    // 动态规划优化空间，在原数组技术上进行修改
    public int minCost2(int[][] costs) {
        int n = costs.length;
        for (int i = 1; i < n; i++) {
            costs[i][0] += Math.min(costs[i - 1][1], costs[i - 1][2]);
            costs[i][1] += Math.min(costs[i - 1][0], costs[i - 1][2]);
            costs[i][2] += Math.min(costs[i - 1][0], costs[i - 1][1]);
        }
        return Math.min(costs[n - 1][0], Math.min(costs[n - 1][1], costs[n - 1][2]));
    }
}
