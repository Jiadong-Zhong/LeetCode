package hot100;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 32. 最长有效括号
 * https://leetcode.cn/problems/longest-valid-parentheses/
 */
public class Hot100_16_longestValidParentheses {
    public static void main(String[] args) {
        String s = "()(()";
        int res = longestValidParentheses1(s);
        System.out.println(res);
    }

    // 暴力解法
    public static int longestValidParentheses1(String s) {
        if (s.length() < 2) {
            return 0;
        }
        int n = s.length();

        n = n % 2 == 0 ? n : (n - 1);
        for (int i = n; i >= 2; i -= 2) {
            for (int j = 0; j <= n - i + 1; j++) {
                String subString = s.substring(j, j + i);
                if (isValid(subString)) {
                    return i;
                }
            }
        }
        return 0;
    }

    public static boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(c);
            } else if (!stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }

    // 动态规划
    public static int longestValidParentheses2(String s) {
        int maxLength = 0;
        int[] dp = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                maxLength = Math.max(maxLength, dp[i]);
            }
        }
        return maxLength;
    }

    // 栈
    public static int longestValidParentheses3(String s) {
        int maxLength = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    maxLength = Math.max(maxLength, i - stack.peek());
                }
            }
        }
        return maxLength;
    }

    // 正向逆向相结合，不需要额外空间
    public static int longestValidParentheses4(String s) {
        int left = 0, right = 0, maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxLength = Math.max(maxLength, 2 * right);
            } else if (right > left) {
                left = right = 0;
            }
        }

        left = right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }

            if (left == right) {
                maxLength = Math.max(maxLength, 2 * left);
            } else if (left > right) {
                left = right = 0;
            }
        }
        return maxLength;
    }
}
