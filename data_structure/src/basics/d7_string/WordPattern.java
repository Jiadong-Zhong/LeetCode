package basics.d7_string;

import java.util.HashMap;
import java.util.Map;

/**
 * 290. 单词规律
 * https://leetcode-cn.com/problems/word-pattern/
 */
public class WordPattern {
    public static void main(String[] args) {
        String pattern = "abba";
        String s = "dog cat cat dog";

    }

    public static boolean wordPattern1(String pattern, String s) {
        Map<String, Character> str2ch = new HashMap<>();
        Map<Character, String> ch2str = new HashMap<>();
        int m = s.length();
        int i = 0;
        for (int p = 0; p < pattern.length(); p++) {
            char ch = pattern.charAt(p);
            // 说明模式串比单词串更长
            if (i >= m) {
                return false;
            }
            // 提取单词存放到temp里
            int j = i;
            while (j < m && s.charAt(j) != ' ') {
                j++;
            }
            String temp = s.substring(i, j);

            if (str2ch.containsKey(temp) && str2ch.get(temp) != ch) {
                return false;
            }
            if (ch2str.containsKey(ch) && !temp.equals(ch2str.get(ch))) {
                return false;
            }
            str2ch.put(temp, ch);
            ch2str.put(ch, temp);
            i = j + 1;
        }
        // 遍历结束后i应该在单词串长度之后，如果没有就说明模式串更短
        return i >= m;
    }
}
