package sword_to_offer;

import java.util.*;

/**
 * 剑指 Offer 50. 第一个只出现一次的字符
 * https://leetcode.cn/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof/
 */
public class Offer50_firstUniqChar {
    public static void main(String[] args) {
        String s = "abaccdeff";
        Offer50_firstUniqChar solution = new Offer50_firstUniqChar();
        char ans = solution.firstUniqChar(s);
        System.out.println(ans);
    }

    // 使用哈希表存储频数
    public char firstUniqChar(String s) {
        Map<Character, Integer> freq = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (freq.get(s.charAt(i)) == 1) {
                return s.charAt(i);
            }
        }
        return ' ';
    }
}
