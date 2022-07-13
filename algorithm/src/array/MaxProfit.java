package array;

/**
 * 买卖股票的最佳时机 II
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2zsx1/
 */

public class MaxProfit {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit1(prices));
        System.out.println(maxProfit2(prices));
        System.out.println(maxProfit3(prices));
    }

    public static int maxProfit1(int[] prices) {
        // 动态规划
        if (prices == null || prices.length < 2) {
            return 0;
        }

        // 第二维0表示未持有股票，1表示持有股票
        int[][] profit = new int[prices.length][2];
        profit[0][0] = 0;
        profit[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            profit[i][0] = Math.max(profit[i - 1][0], profit[i - 1][1] + prices[i]);
            profit[i][1] = Math.max(profit[i - 1][1], profit[i - 1][0] - prices[i]);
        }
        return profit[prices.length - 1][0];
    }

    public static int maxProfit2(int[] prices) {
        // 动态规划
        if (prices == null || prices.length < 2) {
            return 0;
        }

        int profit = 0; // 表示未持有股票的最大利润
        int profit_hold = -prices[0]; // 表示持有股票的最大利润
        for (int i = 1; i < prices.length; i++) {
            profit = Math.max(profit, profit_hold + prices[i]);
            profit_hold = Math.max(profit_hold, profit - prices[i]);
        }
        return profit;
    }

    public static int maxProfit3(int[] prices) {
        // 贪心算法
        if (prices == null || prices.length < 2) {
            return 0;
        }

        int res = 0;
        int index = 0;
        while (index < prices.length) {
            // 如果下跌就一直找，找到上升位置
            while (index < prices.length - 1 && prices[index] >= prices[index + 1]) {
                index++;
            }
            int min = prices[index]; // 股票这天之后上涨，在这天买入
            // 找上升的最大值
            while (index < prices.length - 1 && prices[index] <= prices[index + 1]) {
                index++;
            }
            res += prices[index] - min; // 股票从这天之后下降，在这天售出
            index++;
        }
        return res;
    }
}
