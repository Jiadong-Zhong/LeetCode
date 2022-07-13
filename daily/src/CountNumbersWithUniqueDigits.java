/**
 * 357. 统计各位数字都不同的数字个数
 * https://leetcode-cn.com/problems/count-numbers-with-unique-digits/
 */
public class CountNumbersWithUniqueDigits {
    public static void main(String[] args) {
        int n = 2;
        int res = countNumbersWithUniqueDigits1(n);
        System.out.println(res);
    }

    public static int countNumbersWithUniqueDigits1(int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 10;
        }

        int res = 10;
        int cur = 9;
        for (int i = 0; i < n - 1; i++) {
            cur = cur * (9 - i);
            res += cur;
        }
        return res;
    }
}
