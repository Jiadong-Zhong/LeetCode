package sword_to_offer;

/**
 * 剑指 Offer 10- II. 青蛙跳台阶问题
 * https://leetcode.cn/problems/qing-wa-tiao-tai-jie-wen-ti-lcof/
 */
public class Offer10_numWays {
    public static void main(String[] args) {
        Offer10_numWays solution = new Offer10_numWays();
        int ans = solution.numWays(7);
        System.out.println(ans);
    }

    // 这题本质上还是斐波那契数列，但是要多一位
    public int numWays(int n) {
        if (n == 0) {
            return 1;
        }
        int mod = 1000000007;
        int left = 0, right = 1, ans = 1;
        for (int i = 2; i <= n; i++) {
            left = right;
            right = ans;
            ans = (left + right) % mod;
        }
        return ans;
    }
}
