import java.util.ArrayList;
import java.util.List;

/**
 * 386. 字典序排数
 * https://leetcode-cn.com/problems/lexicographical-numbers/
 */
public class LexicalOrder {
    public static void main(String[] args) {
        int n = 13;
        List<Integer> res = lexicalOrder1(n);
        System.out.println(res);
    }

    public static List<Integer> lexicalOrder1(int n) {
        List<Integer> res = new ArrayList<>();
        int number = 1;
        for (int i = 0; i < n; i++) {
            res.add(number);
            if (number * 10 <= n) {
                number *= 10;
            } else {
                while (number % 10 == 9 || number + 1 > n) {
                    number /= 10;
                }
                number++;
            }
        }
        return res;
    }
}
