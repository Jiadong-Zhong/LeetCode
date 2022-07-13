package hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成
 * https://leetcode.cn/problems/generate-parentheses/
 *
 * 第三种方法略有不懂
 */
public class Hot100_13_generateParenthesis {
    public static void main(String[] args) {
        int n = 3;
        List<String> strings = generateParenthesis3(n);
        System.out.println(strings);
    }

    public static List<String> generateParenthesis1(int n) {
        List<String> combinations = new ArrayList<>();
        generateAll(new char[2 * n], 0, combinations);
        return combinations;
    }

    public static void generateAll(char[] current, int pos, List<String> result) {
        if (pos == current.length) {
            if (valid(current)) {
                result.add(new String(current));
            }
        } else {
            current[pos] = '(';
            generateAll(current, pos + 1, result);
            current[pos] = ')';
            generateAll(current, pos + 1, result);
        }
    }

    public static boolean valid(char[] current) {
        int balance = 0;
        for (char c : current) {
            if (c == '(') {
                balance++;
            } else {
                balance--;
            }
            if (balance < 0) {
                return false;
            }
        }
        return balance == 0;
    }

    public static List<String> generateParenthesis2(int n) {
        List<String> ans = new ArrayList<>();
        backtrack(ans, new StringBuilder(), 0, 0, n);
        return ans;
    }

    public static void backtrack(List<String> ans, StringBuilder cur, int open, int close, int max) {
        if (cur.length() == max * 2) {
            ans.add(cur.toString());
            return;
        }
        if (open < max) {
            cur.append('(');
            backtrack(ans, cur, open + 1, close, max);
            cur.deleteCharAt(cur.length() - 1);
        }
        if (close < open) {
            cur.append(')');
            backtrack(ans, cur, open, close + 1, max);
            cur.deleteCharAt(cur.length() - 1);
        }
    }

    static ArrayList[] cache = new ArrayList[100];
    public static List<String> generate(int n) {
        if (cache[n] != null) {
            return cache[n];
        }
        ArrayList<String> ans = new ArrayList<>();
        if (n == 0) {
            ans.add("");
        } else {
            for (int c = 0; c < n; c++) {
                List<String> leftList = generate(c);
                for (String left : leftList) {
                    List<String> rightList = generate(n - 1 - c);
                    for (String right : rightList) {
                        ans.add("(" + left + ")" + right);
                    }
                }
            }
        }
        cache[n] = ans;
        return ans;
    }

    public static List<String> generateParenthesis3(int n) {
        return generate(n);
    }
}
