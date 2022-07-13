package string;

import java.util.HashMap;

/**
 * 字符串中的第一个唯一字符
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xn5z8r/
 */
public class FirstUniqChar {
    public static void main(String[] args) {
        String s = "leetcode";
        int ans = firstUniqChar1(s);
        System.out.println(ans);
    }

    public static int firstUniqChar1(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }

    public static int firstUniqChar2(String s) {
        for (int i = 0; i < s.length(); i++)
            if (s.indexOf(s.charAt(i)) == s.lastIndexOf(s.charAt(i)))
                return i;
        return -1;
    }
}
