import java.util.HashMap;
import java.util.Map;

/**
 * 745. 前缀和后缀搜索
 * https://leetcode.cn/problems/prefix-and-suffix-search/
 */
// 自己写的，超时
public class WordFilter {

    String[] dict;

    public WordFilter(String[] words) {
        dict = words;
    }

    public int f(String pref, String suff) {
        for (int i = dict.length - 1; i >= 0; i--) {
            String word = dict[i];
            if (word.startsWith(pref) && word.endsWith(suff)) {
                return i;
            }
        }
        return -1;
    }
}

class WordFilter2 {
    Map<String, Integer> dictionary;

    public WordFilter2(String[] words) {
        dictionary = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            int m = word.length();
            for (int prefixLen = 1; prefixLen <= m; prefixLen++) {
                for (int suffixLen = 1; suffixLen <= m; suffixLen++) {
                    dictionary.put(word.substring(0, prefixLen) + "#" + word.substring(m - suffixLen), i);
                }
            }
        }
    }

    public int f(String pref, String suff) {
        return dictionary.getOrDefault(pref + "#" + suff, -1);
    }
}