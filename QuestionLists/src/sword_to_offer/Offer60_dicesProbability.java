package sword_to_offer;

import java.util.Arrays;

/**
 * 剑指 Offer 60. n个骰子的点数
 * https://leetcode.cn/problems/nge-tou-zi-de-dian-shu-lcof/
 */
public class Offer60_dicesProbability {
    public static void main(String[] args) {
        int n = 1;
    }

    public double[] dicesProbability(int n) {
        double[] dp = new double[6];
        Arrays.fill(dp, 1.0 / 6.0);
        for (int i = 2; i <= n; i++) {
            double[] temp = new double[5 * i + 1];
            for (int j = 0; j < dp.length; j++) {
                for (int k = 0; k < 6; k++) {
                    temp[j + k] += dp[j] / 6.0;
                }
            }
            dp = temp;
        }
        return dp;
    }
}
