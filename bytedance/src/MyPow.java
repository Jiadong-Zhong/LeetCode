/**
 * 50. Pow(x, n)
 * https://leetcode.cn/problems/powx-n/
 */
public class MyPow {
    public static void main(String[] args) {
        double x = 2.1000;
        int n = 3;
    }

    public double myPow(double x, int n) {
        double base = x;
        double ans = 1.0;
        long N = n;
        boolean isNegative = n < 0;
        N = Math.abs(N);
        while (N > 0) {
            if ((N & 1) == 1) {
                ans *= base;
            }
            base *= base;
            N >>= 1;
        }
        return isNegative ? 1.0 / ans : ans;
    }


}
