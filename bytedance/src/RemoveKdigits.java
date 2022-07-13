import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 402. 移掉 K 位数字
 * https://leetcode.cn/problems/remove-k-digits/
 */
public class RemoveKdigits {
    public static void main(String[] args) {
        String num = "1432219";
        int k = 3;
        RemoveKdigits solution = new RemoveKdigits();
        String ans = solution.removeKdigits(num, k);
        System.out.println(ans);
    }

    public String removeKdigits(String num, int k) {
        Deque<Character> queue = new ArrayDeque<>();
        int n = num.length();
        for (int i = 0; i < n; i++) {
            char digit = num.charAt(i);
            while (!queue.isEmpty() && k > 0 && queue.peekLast() > digit) {
                queue.pollLast();
                k--;
            }
            queue.offerLast(digit);
        }

        // 如果删除的数字小于k，则现在剩余的字符是递减的，因此删除最后一个字符能让剩余字符最小
        for (int i = 0; i < k; i++) {
            queue.pollLast();
        }

        StringBuilder ans = new StringBuilder();
        boolean leadingZero = true;
        while (!queue.isEmpty()) {
            char digit = queue.pollFirst();
            if (leadingZero && digit == '0') {
                continue;
            }
            leadingZero = false;
            ans.append(digit);
        }
        return ans.length() == 0 ? "0" : ans.toString();
    }
}
