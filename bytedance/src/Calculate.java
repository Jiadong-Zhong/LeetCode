import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 224. 基本计算器
 * https://leetcode.cn/problems/basic-calculator/
 */
public class Calculate {
    public static void main(String[] args) {
        String s = "(1+(4+5+2)-3)+(6+8)";
        Calculate solution = new Calculate();
        int ans = solution.calculate1(s);
        System.out.println(ans);
    }

    // 括号展开和栈
    // 每个数字的正负只与前面的符号有关
    public int calculate1(String s) {
        Deque<Integer> ops = new ArrayDeque<>();
        ops.push(1);
        int sign = 1;

        int res = 0;
        int n = s.length();
        int i = 0;
        while (i < n) {
            if (s.charAt(i) == ' ') {
                i++;
            } else if (s.charAt(i) == '+') {
                sign = ops.peek();
                i++;
            } else if (s.charAt(i) == '-') {
                sign = -ops.peek();
                i++;
            } else if (s.charAt(i) == '(') {
                ops.push(sign);
                i++;
            } else if (s.charAt(i) == ')') {
                ops.pop();
                i++;
            } else {
                long num = 0;
                while (i < n && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
                res += sign * num;
            }
        }
        return res;
    }
}
