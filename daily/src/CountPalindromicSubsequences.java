/**
 * 730. 统计不同回文子序列
 * https://leetcode.cn/problems/count-different-palindromic-subsequences/
 */
public class CountPalindromicSubsequences {
    public static void main(String[] args) {
        String s = "bccb";
        CountPalindromicSubsequences solution = new CountPalindromicSubsequences();
        int ans = solution.contPalindromicSubsequences2(s);
        System.out.println(ans);

    }

    // 动态规划，三维数组 dp(x,i,j) 表示在字符串区间 s[i:j] 中以字符 x 为开头和结尾的不同回文串总数
    public int contPalindromicSubsequences1(String s) {
        final int MOD = 1000000007;
        int n = s.length();
        int[][][] dp = new int[4][n][n];  // s中只有4个字母abcd因此长度为4
        for (int i = 0; i < n; i++) {
            dp[s.charAt(i) - 'a'][i][i] = 1;
        }

        for (int len = 2; len <= n; len++) {
            for (int i = 0; i + len <= n; i++) {
                int j = i + len - 1;
                for (char c = 'a'; c <= 'd'; c++) {
                    int k = c - 'a';
                    if (s.charAt(i) == c && s.charAt(j) == c) {
                        dp[k][i][j] = (2 + (dp[0][i + 1][j - 1] + dp[1][i + 1][j - 1]) % MOD + (dp[2][i + 1][j - 1] + dp[3][i + 1][j - 1]) % MOD) % MOD;
                    } else if (s.charAt(i) == c) {
                        dp[k][i][j] = dp[k][i][j - 1];
                    } else if (s.charAt(j) == c) {
                        dp[k][i][j] = dp[k][i + 1][j];
                    } else {
                        dp[k][i][j] = dp[k][i + 1][j - 1];
                    }
                }
            }
        }

        int res = 0;
        for (int i = 0; i < 4; i++) {
            res = (res + dp[i][0][n - 1]) % MOD;
        }
        return res;
    }

    // 动态规划，二维数组
    public int contPalindromicSubsequences2(String s) {
        final int MOD = 1000000007;
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        for (int len = 2; len <= n; len++) {
            for (int i = 0; i + len <= n; i++) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j)) {
                    int low = i + 1;
                    int high = j - 1;
                    while (low <= high && s.charAt(low) != s.charAt(i)) {
                        low++;
                    }
                    while (high >= low && s.charAt(high) != s.charAt(j)) {
                        high--;
                    }
                    if (low > high) {
                        dp[i][j] = (2 + dp[i + 1][j - 1] * 2) % MOD;
                    } else if (low == high) {
                        dp[i][j] = (1 + dp[i + 1][j - 1] * 2) % MOD;
                    } else {
                        dp[i][j] = (dp[i + 1][j - 1] * 2 % MOD - dp[low + 1][high - 1] + MOD) % MOD;
                    }
                } else {
                    dp[i][j] = ((dp[i + 1][j] + dp[i][j - 1]) % MOD - dp[i + 1][j - 1] + MOD) % MOD;
                }
            }
        }

        return dp[0][n - 1];
    }
}
