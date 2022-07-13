/**
 * 190. 颠倒二进制位
 * https://leetcode.cn/problems/reverse-bits/
 */
public class ReverseBits {
    public static void main(String[] args) {
        int n = 43261596;
        ReverseBits solution = new ReverseBits();
        int ans = solution.reverseBits(n);
        System.out.println(ans);
    }

    public int reverseBits(int n) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            ans = (ans << 1) | (n & 1);
            n >>= 1;
        }
        return ans;
    }
}
