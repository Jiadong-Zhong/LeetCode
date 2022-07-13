package hot100;

/**
 * 461. 汉明距离
 * https://leetcode.cn/problems/hamming-distance/
 */
public class Hot100_91_hammingDistance {
    public static void main(String[] args) {
        int x = 1, y = 4;
        Hot100_91_hammingDistance solution = new Hot100_91_hammingDistance();
        int ans = solution.hammingDistance1(x, y);
        System.out.println(ans);
    }

    // 自己写的
    public int hammingDistance1(int x, int y) {
        int ans = x ^ y;
        String s = Integer.toBinaryString(ans);
        int count = 0;
        for (int i = 0 ; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                count++;
            }
        }
        return count;
    }

    // 内置位计数器
    public int hammingDistance2(int x, int y) {
        return Integer.bitCount(x ^ y);
    }

    // 移位计数器
    // LeetCode中效果最好
    public int hammingDistance3(int x, int y) {
        int s = x ^ y;
        int count = 0;
        while (s != 0) {
            count += s & 1;
            s >>= 1;
        }
        return count;
    }

    // Brian Kernighan算法，加速移位
    public int hammingDistance4(int x, int y) {
        int s = x ^ y;
        int count = 0;
        while (s != 0) {
            s &= s - 1;
            count++;
        }
        return count;
    }
}
