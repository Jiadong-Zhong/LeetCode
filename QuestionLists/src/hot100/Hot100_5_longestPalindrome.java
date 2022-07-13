package hot100;

/**
 * 5. 最长回文子串
 * https://leetcode.cn/problems/longest-palindromic-substring/
 */
public class Hot100_5_longestPalindrome {
    public static void main(String[] args) {
        String s = "babad";
        Hot100_5_longestPalindrome solution = new Hot100_5_longestPalindrome();
        String s1 = solution.longestPalindrome1(s);
        System.out.println(s1);
    }

    public String longestPalindrome1(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }

        int maxLen = 1;
        int begin = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > maxLen) {
                begin = i - (len - 1) / 2;
                maxLen = len;
                // end = i + len / 2;
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    public int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
