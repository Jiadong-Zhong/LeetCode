package string;

import java.util.Locale;

/**
 * 验证回文串
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xne8id/
 */
public class IsPalindrome {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal_: Panama";
        boolean res = isPalindrome2(s);
        System.out.println(res);
    }

    public static boolean isPalindrome1(String s) {
        char[] chars = s.toCharArray();
        int left = 0;
        int right = chars.length - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(chars[left])) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(chars[right])) {
                right--;
            }
            if (Character.toLowerCase(chars[left]) != Character.toLowerCase(chars[right])) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static boolean isPalindrome2(String s) {
        String s1 = s.replaceAll("[^\\w&&[^_]]", "").toLowerCase(Locale.ROOT);
        System.out.println(s1);
        String reverse = new StringBuffer(s1).reverse().toString();
        return s1.equals(reverse);
    }
}
