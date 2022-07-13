package hot100;

import java.util.Arrays;

/**
 * 322. 零钱兑换
 * https://leetcode.cn/problems/coin-change/
 */
public class Hot100_80_coinChange {
    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;
        Hot100_80_coinChange solution = new Hot100_80_coinChange();
        int ans = solution.coinChange3(coins, amount);
        System.out.println(ans);
    }

    // 自己写的 超时
    int minCount = Integer.MAX_VALUE;

    public int coinChange1(int[] coins, int amount) {
        dfs(coins, amount, 0);
        if (minCount == Integer.MAX_VALUE) {
            minCount = -1;
        }
        return minCount;
    }

    public void dfs(int[] coins, int amount, int count) {
        if (amount == 0) {
            minCount = Math.min(count, minCount);
            return;
        } else if (amount < 0) {
            return;
        }
        for (int i = coins.length - 1; i >= 0; i--) {
            dfs(coins, amount - coins[i], count + 1);
        }
    }

    // 记忆化搜索
    public int coinChange2(int[] coins, int amount) {
        if (amount < 1) {
            return 0;
        }
        return coinChange2(coins, amount, new int[amount]);
    }

    private int coinChange2(int[] coins, int rem, int[] count) {
        if (rem < 0) {
            return -1;
        }
        if (rem == 0) {
            return 0;
        }
        if (count[rem - 1] != 0) {
            return count[rem - 1];
        }
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = coinChange2(coins, rem - coin, count);
            if (res >= 0 && res < min) {
                min = 1 + res;
            }
        }
        count[rem - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
        return count[rem - 1];
    }

    // 动态规划
    // F(i)为组成金额i所需要的最小硬币数量
    public int coinChange3(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
