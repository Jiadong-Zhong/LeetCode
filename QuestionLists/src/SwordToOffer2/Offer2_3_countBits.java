package SwordToOffer2;

import java.util.Arrays;

/**
 * 剑指 Offer II 003. 前 n 个数字二进制中 1 的个数
 * https://leetcode.cn/problems/w3tCBm/
 */
public class Offer2_3_countBits {
    public static void main(String[] args) {
        int n = 5;
        Offer2_3_countBits solution = new Offer2_3_countBits();
        int[] ans = solution.countBits1(n);
        System.out.println(Arrays.toString(ans));
    }

    // 自己写的
    public int[] countBits1(int n) {
        int[] ans = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            int count = 0;
            int curVal = i;
            while (curVal > 0) {
                if ((curVal & 1) == 1) {
                    count++;
                }
                curVal >>= 1;
            }
            ans[i] = count;
        }
        return ans;
    }

    // Brain Kernighan算法
    public int[] countBits2(int n) {
        int[] ans = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            ans[i] = countOnes(i);
        }
        return ans;
    }

    public int countOnes(int x) {
        int ones = 0;
        while (x > 0) {
            x &= (x - 1);
            ones++;
        }
        return ones;
    }

    // 动态规划，最高有效位
    // 比如66，他和64一样的最高位，那么66的二进制1个数就等于去掉最高位以后，剩下二进制位的数加上最高位的那个1
    // 而66去掉最高位就是66-64=2，那么2的二进制个数是1个，66则是1+1=2个。E
    public int[] countBits3(int n) {
        int[] ans = new int[n + 1];
        int highBit = 0;
        for (int i = 1; i <= n; i++) {
            if ((i & (i - 1)) == 0) {
                highBit = i;
            }
            ans[i] = ans[i - highBit] + 1;
        }
        return ans;
    }
}
