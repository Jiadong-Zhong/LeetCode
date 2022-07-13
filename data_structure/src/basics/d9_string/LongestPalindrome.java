package basics.d9_string;

/**
 * 5. 最长回文子串
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 *
 * Manacher算法没看
 */
public class LongestPalindrome {
    public static void main(String[] args) {
        String s = "babad";
        String res = longestPalindrome1(s);
        System.out.println(res);
    }

    // 暴力解法
    public static String longestPalindrome1(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }

        int maxLen = 1;
        int begin = 0;

        char[] charArray = s.toCharArray();

        // 枚举所有长度严格大于1的子串
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (j - i + 1 > maxLen && validPalindromic(charArray, i, j)) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    private static boolean validPalindromic(char[] charArray, int left, int right) {
        while (left < right) {
            if (charArray[left] != charArray[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // 动态规划
    public static String longestPalindrome2(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }

        int maxLen = 1;
        int begin = 0;
        // dp[i][j] 表示 s[i..j] 是否是回文串
        boolean[][] dp = new boolean[len][len];
        // 初始化：所有长度为 1 的子串都是回文串
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        char[] charArray = s.toCharArray();
        // 递推开始
        // 先枚举子串长度
        for (int L = 2; L <= len; L++) {
            // 枚举左边界，左边界的上限设置可以宽松一些
            for (int i = 0; i < len; i++) {
                // 由 L 和 i 可以确定右边界，即 j - i + 1 = L 得
                int j = L + i - 1;
                // 如果右边界越界，就可以退出当前循环
                if (j >= len) {
                    break;
                }

                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                } else {
                    // 当 (j - 1) - (i + 1) + 1 < 2 即 j - i < 3 时，不构成区间
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                // 只要 dp[i][L] == true 成立，就表示子串 s[i..L] 是回文，此时记录回文长度和起始位置
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    // 中心扩展
    public static String longestPalindrome3(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }

        int maxLen = 1;
        int begin = 0;

        char[] charArray = s.toCharArray();
        for (int i = 0; i < len - 1; i++) {
            int oddLen = expandAroundCenter(charArray, i, i);
            int evenLen = expandAroundCenter(charArray, i, i + 1);

            int curMaxLen = Math.max(oddLen, evenLen);
            if (curMaxLen > maxLen) {
                maxLen = curMaxLen;
                begin = i - (maxLen - 1) / 2;
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    /**
     * @param charArray 原始字符串的字符数组
     * @param left      起始左边界
     * @param right     起始右边界
     * @return 回文串的长度
     */
    private static int expandAroundCenter(char[] charArray, int left, int right) {
        // 当 left = right 时，回文串的中心是一个字符，长度是奇数
        // 当 right = left + 1 时，回文串的中心是两个字符，长度是偶数
        int len = charArray.length;
        int i = left;
        int j = right;
        while (i >= 0 && j < len) {
            if (charArray[i] == charArray[j]) {
                i--;
                j++;
            } else {
                break;
            }
        }
        // 跳出循环时满足 s.charAt(i) != s.charAt(j)
        // 回文串的长度是 j - i + 1 - 2 = j - i - 1
        return j - i - 1;
    }
}
