import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 856. 括号的分数
 * https://leetcode.cn/problems/score-of-parentheses/
 */
public class ScoreOfParentheses {
    public static void main(String[] args) {
        String s = "(()(()))";
        ScoreOfParentheses solution = new ScoreOfParentheses();
        int ans = solution.scoreOfParentheses(s);
        System.out.println(ans);
    }

    public int scoreOfParentheses(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);

        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(0);
            } else {
                int v = stack.pop();
                int w = stack.pop();
                stack.push(w + Math.max(2 * v, 1));
            }
        }
        return stack.pop();
    }
}
