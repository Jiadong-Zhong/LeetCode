package sword_to_offer;

/**
 * 剑指 Offer 15. 二进制中1的个数
 * https://leetcode.cn/problems/er-jin-zhi-zhong-1de-ge-shu-lcof/
 */
public class Offer15_hammingWeight {
    public static void main(String[] args) {
        int n = 11;
        Offer15_hammingWeight solution = new Offer15_hammingWeight();
        int ans = solution.hammingWeight1(11);
        System.out.println(ans);
    }

    // api
    public int hammingWeight1(int n) {
        return Integer.bitCount(n);
    }

    // 算法
    public int hammingWeight2(int n) {
        int count = 0;
        while (n != 0) {
            n &= n - 1;
            count++;
        }
        return count;
    }
}
