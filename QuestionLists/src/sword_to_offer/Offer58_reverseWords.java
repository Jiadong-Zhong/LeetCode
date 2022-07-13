package sword_to_offer;

import java.lang.reflect.Array;
import java.util.*;

/**
 * 剑指 Offer 58 - I. 翻转单词顺序
 * https://leetcode.cn/problems/fan-zhuan-dan-ci-shun-xu-lcof/
 */
public class Offer58_reverseWords {
    public static void main(String[] args) {
        String s = "the sky  is blue";
        Offer58_reverseWords solution = new Offer58_reverseWords();
        String ans = solution.reverseWords2(s);
        System.out.println(ans);
    }

    // api
    public String reverseWords1(String s) {
        String[] splits = s.trim().split(" +");
        List<String> wordList = Arrays.asList(splits);
        Collections.reverse(wordList);
        return String.join(" ", wordList);
    }

    public String reverseWords2(String s) {
        int left = 0, right = s.length() - 1;
        while (left <= right && s.charAt(left) == ' ') {
            left++;
        }

        while (left <= right && s.charAt(right) == ' ') {
            right--;
        }

        Deque<String> stack = new ArrayDeque<>();
        StringBuilder word = new StringBuilder();
        while (left <= right) {
            char c = s.charAt(left);
            if ((word.length() != 0) && (c == ' ')) {
                stack.push(word.toString());
                word.setLength(0);
            } else if (c != ' ') {
                word.append(c);
            }
            left++;
        }
        stack.push(word.toString());
        return String.join(" ", stack);
    }
}
