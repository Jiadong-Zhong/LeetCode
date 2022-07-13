package hot100;

/**
 * 121. 买卖股票的最佳时机
 * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/
 */
public class Hot100_45_maxProfit {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        Hot100_45_maxProfit solution = new Hot100_45_maxProfit();
        int ans = solution.maxProfit2(prices);
        System.out.println(ans);
    }

    // 暴力法
    public int maxProfit1(int[] prices) {
        int maxProfit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int profit = prices[j] - prices[i];
                maxProfit = Math.max(profit, maxProfit);
            }
        }
        return maxProfit;
    }

    // 一次遍历
    public int maxProfit2(int[] prices ) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price : prices) {
            minPrice = Math.min(minPrice, price);
            maxProfit = Math.max(maxProfit, price - minPrice);
        }
        return maxProfit;
    }
}
