package hot100;

/**
 * 338. 比特位计数
 * https://leetcode.cn/problems/counting-bits/
 * 方法三、四没有看
 */
public class Hot100_82_countBits {
    public static void main(String[] args) {
        int n = 5;
        Hot100_82_countBits solution = new Hot100_82_countBits();
        int[] ans = solution.countBits2(5);
    }

    // Brian Kernighan 算法
    // 对于任意的整数x，令 x = x & (x - 1) 将二进制表示的最后一个1变为0，直到x变为0
    public int[] countBits1(int n) {
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
    public int[] countBits2(int n) {
        int[] bits = new int[n + 1];
        int highBit = 0;
        for (int i = 1; i <= n; i++) {
            if ((i & (i - 1)) == 0) {
                highBit = i;
            }
            bits[i] = bits[i - highBit] + 1;
        }
        return bits;
    }

    // 动态规划，最低有效位
    // 动态规划，最低设置位
}
