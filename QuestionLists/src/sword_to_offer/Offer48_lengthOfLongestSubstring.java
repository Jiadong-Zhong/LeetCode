package sword_to_offer;

import java.util.HashSet;
import java.util.Set;

/**
 * 剑指 Offer 48. 最长不含重复字符的子字符串
 * https://leetcode.cn/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof/
 */
public class Offer48_lengthOfLongestSubstring {
    public static void main(String[] args) {
        String s = "abcabcbb";

    }

    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int n = s.length();
        int right = -1;
        int ans = 0;
        for (int left = 0; left < n; left++) {
            if (left != 0) {
                set.remove(s.charAt(left - 1));
            }
            while (right + 1 < n && !set.contains(s.charAt(right + 1))) {
                set.add(s.charAt(right + 1));
                right++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}
