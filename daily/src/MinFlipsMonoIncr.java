/**
 * 926. 将字符串翻转到单调递增
 * https://leetcode.cn/problems/flip-string-to-monotone-increasing/
 */
public class MinFlipsMonoIncr {
    public static void main(String[] args) {
        String s = "010110";
        MinFlipsMonoIncr solution = new MinFlipsMonoIncr();
        int ans = solution.minFlipsMonoIncr3(s);
        System.out.println(ans);
    }

    // 动态规划
    // dp[i][0]表示第i位为0并使s[0,i]递增的需要翻转的次数
    public int minFlipsMonoIncr1(String s) {
        int n = s.length();
        int[][] dp = new int[n + 1][2];
        dp[0][0] = 0;
        dp[0][1] = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            dp[i + 1][0] = dp[i][0];
            dp[i + 1][1] = Math.min(dp[i][1], dp[i][0]);
            if (c == '0') {
                dp[i + 1][1]++;
            } else {
                dp[i + 1][0]++;
            }
        }
        return Math.min(dp[n][0], dp[n][1]);
    }

    // 动态规划优化空间
    public int minFlipsMonoIncr2(String s) {
        int n = s.length();
        int dp0 = 0, dp1 = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            int newDp0 = dp0, newDp1 = Math.min(dp0, dp1);
            if (c == '1') {
                newDp0++;
            } else {
                newDp1++;
            }
            dp0 = newDp0;
            dp1 = newDp1;
        }
        return Math.min(dp0, dp1);
    }

    // 前缀和，分别统计每个位置前面有多少个1，后面有多少个0
    public int minFlipsMonoIncr3(String s) {
        int n = s.length();
        int[] one = new int[n];
        int[] zero = new int[n];
        int count0 = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                count0++;
            }
            one[i] = count0;
        }
        int count1 = 0;
        for (int i = n -1 ; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                count1++;
            }
            zero[i] = count1;
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            ans = Math.min(ans, one[i] + zero[i]);
        }
        return ans - 1;
    }
}
