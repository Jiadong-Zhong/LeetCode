package hot100;

/**
 * 70. 爬楼梯
 * https://leetcode.cn/problems/climbing-stairs/
 */
public class Hot100_29_climbStairs {
    public static void main(String[] args) {
        int n = 5;
        Hot100_29_climbStairs solution = new Hot100_29_climbStairs();
        int ans = solution.climbStairs2(n);
        System.out.println(ans);
    }

    // 动态规划
    public int climbStairs1(int n) {
        int left = 0, mid = 0, right = 1;
        for (int i = 1; i <= n; i++) {
            left = mid;
            mid = right;
            right = left + mid;
        }
        return right;
    }

    // 矩阵快速幂
    // 矩阵快速幂的方法解释：https://zhuanlan.zhihu.com/p/42639682
    public int climbStairs2(int n) {
        int[][] q = {{1, 1}, {1, 0}};
        int[][] res = pow(q, n);
        return res[0][0];
    }

    public int[][] pow(int[][] a, int n) {
        int[][] ret = {{1, 0}, {0, 1}};
        while (n > 0) {
            if ((n & 1) == 1) {
                ret = multiply(ret, a);
            }
            n >>= 1;
            a = multiply(a, a);
        }
        return ret;
    }

    public int[][] multiply(int[][] a, int[][] b) {
        int[][] c = new int[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                c[i][j] = a[i][0] * b[0][j] + a[i][1] * b[1][j];
            }
        }
        return c;
    }

    // 通项公式
    public int climbStairs3(int n) {
        double sqrt5 = Math.sqrt(5);
        double fibn = Math.pow((1 + sqrt5) / 2, n + 1) - Math.pow((1 - sqrt5) / 2, n + 1);
        return (int) Math.round(fibn / sqrt5);
    }
}
