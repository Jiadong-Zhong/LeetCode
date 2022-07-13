import java.util.HashSet;
import java.util.Set;

/**
 * 824. 山羊拉丁文
 * https://leetcode-cn.com/problems/goat-latin/
 */
public class ToGoatLatin {
    public static void main(String[] args) {
        String sentence = "I speak Goat Latin";
        String res = toGoatLatin1(sentence);
        System.out.println(res);
    }

    public static String toGoatLatin1(String sentence) {
        Set<Character> vowels = new HashSet<Character>() {{
            add('a');
            add('e');
            add('i');
            add('o');
            add('u');
            add('A');
            add('E');
            add('I');
            add('O');
            add('U');
        }};

        StringBuilder res = new StringBuilder();

        String[] s_array = sentence.split(" ");
        for (int i = 0; i < s_array.length; i++) {
            if (!vowels.contains(s_array[i].charAt(0))) {
                s_array[i] = s_array[i].substring(1) + s_array[i].charAt(0);
            }
            s_array[i] += "ma";

            for (int j = 0; j < i + 1; j++) {
                s_array[i] += "a";
            }
            if (i != s_array.length - 1) {
                res.append(s_array[i]).append(" ");
            } else {
                res.append(s_array[i]);
            }
        }
        return res.toString();
    }


    public static String toGoatLatin2(String sentence) {
        Set<Character> vowels = new HashSet<Character>() {{
            add('a');
            add('e');
            add('i');
            add('o');
            add('u');
            add('A');
            add('E');
            add('I');
            add('O');
            add('U');
        }};

        int n = sentence.length();
        int i = 0, cnt = 1;
        StringBuffer ans = new StringBuffer();

        while (i < n) {
            int j = i;
            while (j < n && sentence.charAt(j) != ' ') {
                ++j;
            }

            ++cnt;
            if (cnt != 2) {
                ans.append(' ');
            }
            if (vowels.contains(sentence.charAt(i))) {
                ans.append(sentence, i, j);
            } else {
                ans.append(sentence, i + 1, j);
                ans.append(sentence.charAt(i));
            }
            ans.append('m');
            for (int k = 0; k < cnt; ++k) {
                ans.append('a');
            }

            i = j + 1;
        }

        return ans.toString();
    }
}
