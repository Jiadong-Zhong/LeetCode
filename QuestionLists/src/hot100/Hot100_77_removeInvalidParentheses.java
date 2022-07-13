package hot100;

import java.util.*;

/**
 * 301. 删除无效的括号
 * https://leetcode.cn/problems/remove-invalid-parentheses/
 */
public class Hot100_77_removeInvalidParentheses {
    public static void main(String[] args) {
        String s = "()())()";
        Hot100_77_removeInvalidParentheses solution = new Hot100_77_removeInvalidParentheses();
        List<String> ans = solution.removeInvalidParentheses2(s);
        System.out.println(ans);
    }

    // 回溯 + 剪枝
    private List<String> ans = new ArrayList<>();

    public List<String> removeInvalidParentheses1(String s) {
        int lremove = 0;
        int rremove = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                lremove++;
            } else if (ch == ')') {
                if (lremove == 0) {
                    rremove++;
                } else {
                    lremove--;
                }
            }
        }
        helper(s, 0, lremove, rremove);
        return ans;
    }

    private void helper(String str, int start, int lremove, int rremove) {
        if (lremove == 0 && rremove == 0) {
            if (isValid(str)) {
                ans.add(str);
            }
            return;
        }

        for (int i = start; i < str.length(); i++) {
            if (i != start && str.charAt(i) == str.charAt(i - 1)) {
                continue;
            }
            // 如果剩余字符无法满足去掉数量要求，直接返回
            if (lremove + rremove > str.length() - i) {
                return;
            }
            // 尝试去掉左括号
            if (lremove > 0 && str.charAt(i) == '(') {
                helper(str.substring(0, i) + str.substring(i + 1), i, lremove - 1, rremove);
            }
            // 尝试去掉右括号
            if (rremove > 0 && str.charAt(i) == ')') {
                helper(str.substring(0, i) + str.substring(i + 1), i, lremove, rremove - 1);
            }

        }
    }

    private boolean isValid(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                count++;
            } else if (str.charAt(i) == ')') {
                count--;
                if (count < 0) {
                    return false;
                }
            }
        }
        return count == 0;
    }


    // bfs
    // 每轮删除字符串的一个括号，直到出现合法匹配为止
    public List<String> removeInvalidParentheses2(String s) {
        List<String> ans = new ArrayList<>();
        Set<String> currSet = new HashSet<>();

        currSet.add(s);
        while (true) {
            for (String str : currSet) {
                if (isValid(str)) {
                    ans.add(str);
                }
            }
            if (ans.size() > 0) {
                return ans;
            }
            Set<String> nextSet = new HashSet<>();
            for (String str : currSet) {
                for (int i = 0; i < str.length(); i++) {
                    if (i > 0 && str.charAt(i) == str.charAt(i - 1)) {
                        continue;
                    }
                    if (str.charAt(i) == '(' || str.charAt(i) == ')') {
                        nextSet.add(str.substring(0, i) + str.substring(i + 1));
                    }
                }
            }
            currSet = nextSet;
        }
    }
}
