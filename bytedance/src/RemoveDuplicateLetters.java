import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 316. 去除重复字母
 * https://leetcode.cn/problems/remove-duplicate-letters/
 */
public class RemoveDuplicateLetters {
    public static void main(String[] args) {
        String s = "cbacdcbc";
        RemoveDuplicateLetters solution = new RemoveDuplicateLetters();
        String ans = solution.removeDuplicateLetters(s);
        System.out.println(ans);
    }

    public String removeDuplicateLetters(String s) {
        boolean[] visited = new boolean[26];
        int[] num = new int[26];
        for (int i = 0; i < s.length(); i++) {
            num[s.charAt(i) - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!visited[ch - 'a']) {
                while (sb.length() > 0 && sb.charAt(sb.length() - 1) > ch) {
                    if (num[sb.charAt(sb.length() - 1) - 'a'] > 0) {
                        visited[sb.charAt(sb.length() - 1) - 'a'] = false;
                        sb.deleteCharAt(sb.length() - 1);
                    } else {
                        break;
                    }
                }
                visited[ch - 'a'] = true;
                sb.append(ch);
            }
            num[ch - 'a']--;
        }
        return sb.toString();
    }
}
