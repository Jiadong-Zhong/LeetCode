package hot100;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 3. 无重复字符的最长子串
 * https://leetcode.cn/problems/longest-substring-without-repeating-characters/
 */
public class Hot100_3_lengthOfLongestSubstring {
    public static void main(String[] args) {
        String s = "pwwkew";
        int res = lengthOfLongestSubstring2(s);
        System.out.println(res);
    }

    public static int lengthOfLongestSubstring1(String s) {
        Map<Character, Boolean> isVisited = new HashMap<>();
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            int curLength = 0;
            for (int j = i; j < s.length(); j++) {
                if (!isVisited.containsKey(s.charAt(j))) {
                    curLength++;
                    isVisited.put(s.charAt(j), true);
                } else {
                    break;
                }
            }
            if (curLength > max) {
                max = curLength;
            }
            isVisited.clear();
        }
        return max;
    }

    // 假设我们选择字符串中的第 k 个字符作为起始位置，并且得到了不包含重复字符的最长子串的结束位置为 right
    // 那么当我们选择第 k+1 个字符作为起始位置时，从 k+1 到 right 的字符显然是不重复的
    public static int lengthOfLongestSubstring2(String s) {
        Set<Character> occ = new HashSet<>();
        int n = s.length();
        int right = -1;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (i != 0) {
                occ.remove(s.charAt(i - 1));
            }
            while (right + 1 < n && !occ.contains(s.charAt(right + 1))) {
                occ.add(s.charAt(right + 1));
                right++;
            }
            ans = Math.max(ans, right - i + 1);
        }
        return ans;
    }

}
