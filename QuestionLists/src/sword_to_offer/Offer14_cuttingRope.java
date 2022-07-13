package sword_to_offer;

/**
 * 剑指 Offer 14- I. 剪绳子
 * https://leetcode.cn/problems/jian-sheng-zi-lcof/
 */
public class Offer14_cuttingRope {
    public static void main(String[] args) {
        int n = 10;
        Offer14_cuttingRope solution = new Offer14_cuttingRope();
        int ans = solution.cuttingRope(n);
        System.out.println(ans);
    }

    // 主要是数学推导，推导出切为3的时候是最优的，如果剩余的绳子为1，则应该少切一段3，换为2和2，因为2*2 > 1*3
    public int cuttingRope(int n) {
        if (n <= 3) {
            return n - 1;
        }
        int a = n / 3;
        int b = n % 3;
        if (b == 0) {
            return (int) Math.pow(3, a);
        }
        if (b == 1) {
            return (int) Math.pow(3, a - 1) * 4;
        }
        return (int) Math.pow(3, a) * 2;
    }
}
