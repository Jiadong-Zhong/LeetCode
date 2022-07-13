package sword_to_offer;

/**
 * 剑指 Offer 16. 数值的整数次方
 * https://leetcode.cn/problems/shu-zhi-de-zheng-shu-ci-fang-lcof/
 */
public class Offer16_myPow {
    public static void main(String[] args) {
        double x = 2.0000;
        int n = -2147483648;
        Offer16_myPow solution = new Offer16_myPow();
        double ans = solution.myPow(x, n);
        System.out.println(ans);
    }

    // 快速幂
    // 用long的原因是有可能产生溢出，当n=Integer.MIN_VALUE时
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
