package hot100;

import java.util.*;

/**
 * 438. 找到字符串中所有字母异位词
 * https://leetcode.cn/problems/find-all-anagrams-in-a-string/
 */
public class Hot100_89_findAnagrams {
    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        Hot100_89_findAnagrams solution = new Hot100_89_findAnagrams();
        List<Integer> ans = solution.findAnagrams2(s, p);
        System.out.println(ans);
    }

    // 滑动窗口
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int sLen = s.length(), pLen = p.length();
        if (sLen < pLen) {
            return ans;
        }

        int[] sCount = new int[26];
        int[] pCount = new int[26];
        for (int i = 0; i < pLen; i++) {
            sCount[s.charAt(i) - 'a']++;
            pCount[p.charAt(i) - 'a']++;
        }

        if (Arrays.equals(sCount, pCount)) {
            ans.add(0);
        }

        for (int i = 0; i < sLen - pLen; i++) {
            sCount[s.charAt(i) - 'a']--;
            sCount[s.charAt(i + pLen) - 'a']++;

            if (Arrays.equals(sCount, pCount)) {
                ans.add(i + 1);
            }
        }
        return ans;
    }

    // 优化滑动窗口，不统计各字母数量，统计字母数量差
    public List<Integer> findAnagrams2(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int sLen = s.length(), pLen = p.length();
        if (sLen < pLen) {
            return ans;
        }

        int[] count = new int[26];
        for (int i = 0; i < pLen; i++) {
            count[s.charAt(i) - 'a']++;
            count[p.charAt(i) - 'a']--;
        }

        int differ = 0;
        for (int j = 0; j < 26; j++) {
            if (count[j] != 0) {
                differ++;
            }
        }

        if (differ == 0) {
            ans.add(0);
        }

        for (int i = 0; i < sLen - pLen; i++) {
            // 处理左边界字符移除
            if (count[s.charAt(i) - 'a'] == 1) {
                differ--;
            } else if (count[s.charAt(i) - 'a'] == 0) {
                differ++;
            }
            count[s.charAt(i) - 'a']--;

            // 处理右边界字符移入
            if (count[s.charAt(i + pLen) - 'a'] == -1) {
                differ--;
            } else if (count[s.charAt(i + pLen) - 'a'] == 0) {
                differ++;
            }
            count[s.charAt(i + pLen) - 'a']++;

            if (differ == 0) {
                ans.add(i + 1);
            }
        }
        return ans;
    }
}
