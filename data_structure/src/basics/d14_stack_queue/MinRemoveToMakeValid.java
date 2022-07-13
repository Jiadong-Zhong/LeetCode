package basics.d14_stack_queue;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * 1249. 移除无效的括号
 * https://leetcode-cn.com/problems/minimum-remove-to-make-valid-parentheses/
 */
public class MinRemoveToMakeValid {
    public static void main(String[] args) {
        String s = "lee(t(c)o)de)";


    }

    public static String minRemoveToMakeValid1(String s) {
        Stack<Integer> brackets = new Stack<>();
        Set<Integer> indexesToRemove = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                brackets.push(i);
            } else if (s.charAt(i) == ')') {
                if (brackets.isEmpty()) {
                    indexesToRemove.add(i);
                } else {
                    brackets.pop();
                }
            }
        }
        while (!brackets.isEmpty()) {
            indexesToRemove.add(brackets.pop());
        }

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!indexesToRemove.contains(i)) {
                res.append(s.charAt(i));
            }
        }
        return res.toString();
    }

    public String minRemoveToMakeValid2(String s) {
        StringBuilder result = removeInvalidClosing(s, '(', ')');
        result = removeInvalidClosing(result.reverse(), ')', '(');
        return result.reverse().toString();
    }

    private StringBuilder removeInvalidClosing(CharSequence string, char open, char close) {
        StringBuilder sb = new StringBuilder();
        int balance = 0;
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            if (c == open) {
                balance++;
            } if (c == close) {
                if (balance == 0) continue;
                balance--;
            }
            sb.append(c);
        }
        return sb;
    }

    public String minRemoveToMakeValid3(String s) {
        // Parse 1: Remove all invalid ")"
        StringBuilder sb = new StringBuilder();
        int openSeen = 0;
        int balance = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                openSeen++;
                balance++;
            } if (c == ')') {
                if (balance == 0) continue;
                balance--;
            }
            sb.append(c);
        }

        // Parse 2: Remove the rightmost "("
        StringBuilder result = new StringBuilder();
        int openToKeep = openSeen - balance;
        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            if (c == '(') {
                openToKeep--;
                if (openToKeep < 0) continue;
            }
            result.append(c);
        }

        return result.toString();
    }

}
