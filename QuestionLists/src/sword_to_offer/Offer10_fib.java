package sword_to_offer;

/**
 * 剑指 Offer 10- I. 斐波那契数列
 * https://leetcode.cn/problems/fei-bo-na-qi-shu-lie-lcof/
 */
public class Offer10_fib {
    public static void main(String[] args) {
        Offer10_fib solution = new Offer10_fib();
        int ans = solution.fib2(5);
        System.out.println(ans);
    }

    // 递归
    public int fib1(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fib1(n - 1) + fib1(n - 2);
    }

    // 动态规划
    public int fib2(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        int[] dp = new int[n + 1];
        dp[1] = 1;
        int mod = 1000000007;
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % mod;
        }
        return dp[n];
    }

    // 优化空间的动态规划
    public int fib3(int n) {
        if (n < 2) {
            return n;
        }
        int mod = 1000000007;
        int left = 0, right = 0, ans = 1;
        for (int i = 2; i <= n; i++) {
            left = right;
            right = ans;
            ans = (left + right) % mod;
        }
        return ans;
    }
}
