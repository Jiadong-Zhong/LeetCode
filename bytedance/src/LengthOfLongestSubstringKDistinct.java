import java.util.Collections;
import java.util.HashMap;

/**
 * 340. 至多包含 K 个不同字符的最长子串
 * https://leetcode.cn/problems/longest-substring-with-at-most-k-distinct-characters/
 */
public class LengthOfLongestSubstringKDistinct {
    public static void main(String[] args) {
        String s = "eceba";
        int k = 2;

        LengthOfLongestSubstringKDistinct solution = new LengthOfLongestSubstringKDistinct();
        int ans = solution.lengthOfLongestSubstringKDistinct(s, k);
        System.out.println(ans);
    }

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int n = s.length();
        if (n * k == 0) {
            return 0;
        }

        int left = 0;
        int right = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        int maxLen = 1;

        while (right < n) {
            map.put(s.charAt(right), right);
            right++;
            if (map.size() == k + 1) {
                int del_index = Collections.min(map.values());
                map.remove(s.charAt(del_index));
                left = del_index + 1;
            }

            maxLen = Math.max(maxLen, right - left);

        }
        return maxLen;
    }
}
