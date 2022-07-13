package basics.d6_string;

import java.util.HashMap;
import java.util.Map;

/**
 * 409. 最长回文串
 * https://leetcode-cn.com/problems/longest-palindrome/
 */
public class LongestPalindrome {
    public static void main(String[] args) {
        String s = "bb";
        int res = longestPalindrome2(s);
        System.out.println(res);
    }

    public static int longestPalindrome1(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        int res = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() % 2 == 0) {
                res += entry.getValue();
                map.remove(entry.getKey());
            } else {
                if (entry.getValue() > 1) {
                    res += entry.getValue() - 1;
                    map.put(entry.getKey(), 1);
                }
            }
        }
        if (!map.isEmpty()) {
            res += 1;
        }
        return res;
    }

    public static int longestPalindrome2(String s) {
        int[] count = new int[128];
        int len = s.length();
        for (int i = 0; i < len; i++) {
            count[s.charAt(i)]++;
        }

        int ans = 0;
        for (int v : count) {
            ans += v / 2 * 2;
            if (v % 2 == 1 && ans % 2 == 0) {
                ans++;
            }
        }
        return ans;
    }
}
