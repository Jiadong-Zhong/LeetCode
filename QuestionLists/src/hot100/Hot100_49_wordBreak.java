package hot100;

import java.util.*;

/**
 * 139. 单词拆分
 * https://leetcode.cn/problems/word-break/
 */
public class Hot100_49_wordBreak {
    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");
        Hot100_49_wordBreak solution = new Hot100_49_wordBreak();
        boolean ans = solution.wordBreak(s, wordDict);
        System.out.println(ans);
    }

    // dp[i]表示字符串s的前i个字符组成的字符串s[0, i-1]能否被拆分成若干个字典中出现的单词
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
