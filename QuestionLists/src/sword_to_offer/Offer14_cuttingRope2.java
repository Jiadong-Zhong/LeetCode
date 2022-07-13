package sword_to_offer;

/**
 * 剑指 Offer 14- II. 剪绳子 II
 * https://leetcode.cn/problems/jian-sheng-zi-ii-lcof/
 */
public class Offer14_cuttingRope2 {
    public static void main(String[] args) {
         int n = 2;
         Offer14_cuttingRope2 solution = new Offer14_cuttingRope2();
        int ans = solution.cuttingRope(127);
        System.out.println(ans);
    }

    // 与上一题差距主要在对取余数的处理上，是在计算幂的时候容易产生溢出需要取余
    public int cuttingRope(int n) {
        int mod = 1000000007;
        if (n <= 3) {
            return n - 1;
        }

        int a = n / 3;
        int b = n % 3;

        long res = 1;
        for (int i = 1; i < a; i++) {
            res = 3 * res % mod;
        }

        if (b == 0) {
            return (int) (res * 3 % mod);
        }
        if (b == 1) {
            return (int) (res * 4 % mod);
        }
        return (int) (res * 6 % mod);
    }
}
