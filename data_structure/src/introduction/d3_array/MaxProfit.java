package introduction.d3_array;

/**
 * 121. 买卖股票的最佳时机
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 */
public class MaxProfit {
    public static void main(String[] args) {
        int[] prices = {2, 5, 1, 3};
        int profit = maxProfit1(prices);
        System.out.println(profit);
    }

    public static int maxProfit1(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }

        int min = Integer.MAX_VALUE;
        int profit = 0;
        for (int price : prices) {
            if (price < min) {
                min = price;
            } else if (price - min > profit) {
                profit = price - min;
            }
        }
        return profit;
    }
}
