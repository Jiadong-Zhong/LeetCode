package sword_to_offer;

/**
 * 剑指 Offer 63. 股票的最大利润
 * https://leetcode.cn/problems/gu-piao-de-zui-da-li-run-lcof/
 */
public class Offer63_maxProfit {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        Offer63_maxProfit solution = new Offer63_maxProfit();
        int ans = solution.maxProfit(prices);
        System.out.println(ans);
    }

    public int maxProfit(int[] prices) {
        int minPrice = prices[0];
        int profit = 0;
        for (int price : prices) {
            minPrice = Math.min(price, minPrice);
            profit = Math.max(profit, price - minPrice);
        }
        return profit;
    }
}
