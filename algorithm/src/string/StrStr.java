package string;

import java.util.Arrays;

/**
 * 28. 实现 strStr()
 * https://leetcode-cn.com/problems/implement-strstr/
 */
public class StrStr {
    public static void main(String[] args) {
        String haystack = "abaacababcac";
        String needle = "ababc";
        int res = strStr1(haystack, needle);
        System.out.println(res);
    }

    public static int strStr1(String haystack, String needle) {
        if (needle.equals("")) {
            return 0;
        }
        int[] next = getNext(needle);
        System.out.println(Arrays.toString(next));
        int i = 0;
        int j = 0;
        while (i < haystack.length()) {
            if (j == -1 || haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            } else {
                j = next[j];
            }
            if (j == needle.length()) {
                return i - j;
            }
        }
        return -1;
    }

    public static int[] getNext(String needle) {
        int[] next = new int[needle.length()];
        next[0] = -1;
        int i = 0;
        int j = -1;
        // 只考察真前后缀情况，因此不考虑整个字符串，所以 i < needle.length() - 1
        while (i < needle.length() - 1) {
            // j = -1 情况为真前后缀从0开始
            if (j == -1 || needle.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
                next[i] = j;
            } else {
                // 如果当前不匹配，回溯到next[j]的位置再进行匹配
                j = next[j];
            }
        }
        return next;
    }
}
