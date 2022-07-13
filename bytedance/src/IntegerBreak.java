/**
 * 343. 整数拆分
 * https://leetcode.cn/problems/integer-break/
 */
public class IntegerBreak {
    public static void main(String[] args) {

    }

    // 动态规划
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            int currMax = 0;
            for (int j = 1; j < i; j++) {
                currMax = Math.max(currMax, Math.max(j * (i - j), j * dp[i - j]));
            }
            dp[i] = currMax;
        }
        return dp[n];
    }

    // 数学，尽量使拆出来的数字3更多，如果剩余4要拆为2*2
    public int integerBreak2(int n) {
        if (n <= 3) {
            return n - 1;
        }
        int count = n / 3;
        int remain = n % 3;
        if (remain == 0) {
            return (int) Math.pow(3, count);
        } else if (remain == 1) {
            return (int) Math.pow(3, count - 1) * 4;
        } else {
            return (int) Math.pow(3, count) * 2;
        }
    }
}
