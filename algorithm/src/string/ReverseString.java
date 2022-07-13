package string;

import java.util.Arrays;

/**
 * 反转字符串
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnhbqj/
 */
public class ReverseString {
    public static void main(String[] args) {
        char[] s = {'h','e','l','l','o'};
        reverseString1(s);
        System.out.println(Arrays.toString(s));
    }

    public static void reverseString1(char[] s) {
        for (int i = 0; i < s.length / 2; i++) {
            char temp = s[i];
            s[i] = s[s.length - i - 1];
            s[s.length - i - 1] = temp;
        }
    }
}
