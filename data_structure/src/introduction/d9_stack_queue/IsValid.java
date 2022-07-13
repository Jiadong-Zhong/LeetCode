package introduction.d9_stack_queue;

import java.util.*;

/**
 * 20. 有效的括号
 * https://leetcode-cn.com/problems/valid-parentheses/
 */
public class IsValid {
    public static void main(String[] args) {
        String s = "}";
        boolean res = isValid1(s);
        System.out.println(res);
    }

    public static boolean isValid1(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            }
            if (c == ')') {
                if (stack.size() == 0 || stack.pop() != '(') {
                    return false;
                }
            } else if (c == ']') {
                if (stack.size() == 0 || stack.pop() != '[') {
                    return false;
                }
            } else if (c == '}') {
                if (stack.size() == 0 || stack.pop() != '{') {
                    return false;
                }
            }
        }
        return stack.size() == 0;
    }

    public static boolean isValid2(String s) {
        if (s.length() % 2 == 1) {
            return false;
        }
        Map<Character, Character> pairs = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};

        Deque<Character> stack = new LinkedList<Character>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (pairs.containsKey(ch)) {
                if (stack.isEmpty() || stack.peek() != pairs.get(ch)) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }
}
