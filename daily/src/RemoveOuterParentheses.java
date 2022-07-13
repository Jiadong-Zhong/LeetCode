import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 1021. 删除最外层的括号
 * https://leetcode.cn/problems/remove-outermost-parentheses/
 */
public class RemoveOuterParentheses {
    public static void main(String[] args) {
        String s = "(()())(())";
    }

    public String removeOuterParentheses1(String s) {
        StringBuffer ans = new StringBuffer();
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ')') {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                ans.append(c);
            }
            if (c == '(') {
                stack.push(c);
            }
        }
        return ans.toString();
    }

    public String removeOuterParentheses2(String s) {
        int level = 0;
        StringBuffer ans = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ')') {
                level--;
            }
            if (level > 0) {
                ans.append(c);
            }
            if (c == '(') {
                level++;
            }
        }
        return ans.toString();
    }
}
