package string;

import java.util.HashMap;

/**
 * 有效的字母异位词
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xn96us/
 */
public class IsAnagram {
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        boolean ans = isAnagram2(s, t);
        System.out.println(ans);
    }

    public static boolean isAnagram1(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (int i = 0; i < t.length(); i++) {
            if (!map.containsKey(t.charAt(i))){
                return false;
            } else {
                map.put(t.charAt(i), map.get(t.charAt(i)) - 1);
            }
        }

        for (int num : map.values()) {
            if (num != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAnagram2(String s, String t) {
        if (s.length() != t.length())
            return false;
        char[] cs = s.toCharArray();
        char[] ct = t.toCharArray();
        int[] map = new int[26];
        int count = 0;
        for (int i = 0; i < cs.length; i++) {
            //出现了一个新的字符
            map[cs[i] - 'a']++;
            if (map[cs[i] - 'a'] == 1) {
                count++;
            }
            //消失了一个新的字符
            map[ct[i] - 'a']--;
            if (map[ct[i] - 'a'] == 0) {
                count--;
            }
        }
        return count == 0;
    }

    public static boolean isAnagram3(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        for (char c : t.toCharArray()) {
            count[c - 'a']--;
            if (count[c - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
