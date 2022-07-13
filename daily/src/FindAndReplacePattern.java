import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 890. 查找和替换模式
 * https://leetcode.cn/problems/find-and-replace-pattern/
 */
public class FindAndReplacePattern {
    public static void main(String[] args) {
        String[] words = {"abc","deq","mee","aqq","dkd","ccc"};
        String pattern = "abb";
        FindAndReplacePattern solution = new FindAndReplacePattern();
        List<String> ans = solution.findAndReplacePattern2(words, pattern);
        System.out.println(ans);
    }

    // 自己写的
    public List<String> findAndReplacePattern1(String[] words, String pattern) {
        List<String> ans = new ArrayList<>();
        for (String word : words) {
            if (word.length() != pattern.length()) {
                continue;
            }
            Map<Character, Character> wordToPattern = new HashMap<>();
            Map<Character, Character> patternToWord = new HashMap<>();
            boolean isMatch = true;
            for (int j = 0; j < word.length(); j++) {
                if (wordToPattern.containsKey(word.charAt(j))) {
                    if (wordToPattern.get(word.charAt(j)) != pattern.charAt(j)) {
                        isMatch = false;
                        break;
                    }
                } else {
                    wordToPattern.put(word.charAt(j), pattern.charAt(j));
                    if (patternToWord.containsKey(pattern.charAt(j))) {
                        isMatch = false;
                        break;
                    }
                    patternToWord.put(pattern.charAt(j), word.charAt(j));
                }
            }
            if (isMatch) {
                ans.add(word);
            }
        }
        return ans;
    }

    // 构造双射
    public List<String> findAndReplacePattern2(String[] words, String pattern) {
        List<String> ans = new ArrayList<>();
        for (String word : words) {
            if (match(word, pattern) && match(pattern, word)) {
                ans.add(word);
            }
        }
        return ans;
    }

    private boolean match(String word, String pattern) {
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            char x = word.charAt(i), y = pattern.charAt(i);
            if (!map.containsKey(x)) {
                map.put(x, y);
            } else if (map.get(x) != y) {
                return false;
            }
        }
        return true;
    }
}
