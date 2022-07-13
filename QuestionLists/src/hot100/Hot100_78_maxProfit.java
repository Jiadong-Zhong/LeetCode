package hot100;

/**
 * 309. 最佳买卖股票时机含冷冻期
 * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-with-cooldown/
 */
public class Hot100_78_maxProfit {
    public static void main(String[] args) {
        int[] prices = {1,2,3,0,2};
        Hot100_78_maxProfit solution = new Hot100_78_maxProfit();
        int ans = solution.maxProfit2(prices);
        System.out.println(ans);
    }

    // 动态规划
    public int maxProfit1(int[] prices) {
        int n = prices.length;
        if (n == 0) {
            return 0;
        }

        int[][] profit = new int[n][3];
        // profit第二个维度为0表示手上持有股票的最大收益
        // 为1表示手上不持有股票且处于冷冻期的最大收益
        // 为2表示手上不持有股票且不处于冷冻期的最大收益
        profit[0][0] = -prices[0];
        for (int i = 1; i < n; i++) {
            profit[i][0] = Math.max(profit[i - 1][0], profit[i - 1][2] - prices[i]);
            profit[i][1] = profit[i - 1][0] + prices[i];
            profit[i][2] = Math.max(profit[i - 1][1], profit[i - 1][2]);
        }
        return Math.max(profit[n - 1][1], profit[n - 1][2]);
    }

    // 动态规划优化空间
    public int maxProfit2(int[] prices) {
        int n = prices.length;
        if (n == 0) {
            return 0;
        }
        int profit0 = -prices[0];
        int profit1 = 0;
        int profit2 = 0;
        for (int i = 1; i < n; i++) {
            int newProfit0 = Math.max(profit0, profit2 - prices[i]);
            int newProfit1 = profit0 + prices[i];
            int newProfit2 = Math.max(profit1, profit2);
            profit0 = newProfit0;
            profit1 = newProfit1;
            profit2 = newProfit2;
        }
        return Math.max(profit1, profit2);
    }
}
