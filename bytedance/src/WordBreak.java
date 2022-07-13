import java.util.*;

/**
 * 140. 单词拆分 II
 * https://leetcode.cn/problems/word-break-ii/
 */
public class WordBreak {
    public static void main(String[] args) {
        String s = "catsanddog";
        List<String> wordDict = new ArrayList<>() {{
            add("cat");
            add("cats");
            add("and");
            add("sand");
            add("dog");
        }};
        WordBreak solution = new WordBreak();
        List<String> ans = solution.wordBreak(s, wordDict);
        System.out.println(ans);
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        Map<Integer, List<List<String>>> map = new HashMap<>();
        List<List<String>> wordBreaks = backtrack(s, s.length(), new HashSet<>(wordDict), 0, map);
        List<String> breakList = new ArrayList<>();
        for (List<String> wordBreak : wordBreaks) {
            breakList.add(String.join(" ", wordBreak));
        }
        return breakList;
    }

    public List<List<String>> backtrack(String s, int length, Set<String> wordSet, int index, Map<Integer, List<List<String>>> map) {
        if (!map.containsKey(index)) {
            List<List<String>> wordBreaks = new ArrayList<>();
            if (index == length) {
                wordBreaks.add(new ArrayList<>());
            }
            for (int i = index + 1; i <= length; i++) {
                String word = s.substring(index, i);
                if (wordSet.contains(word)) {
                    List<List<String>> nextWordBreaks = backtrack(s, length, wordSet, i, map);
                    for (List<String> nextWordBreak : nextWordBreaks) {
                        List<String> wordBreak = new ArrayList<>(nextWordBreak);
                        wordBreak.add(0, word);
                        wordBreaks.add(wordBreak);
                    }
                }
            }
            map.put(index, wordBreaks);
        }
        return map.get(index);
    }
}
