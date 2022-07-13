package hot100;

/**
 * 62. 不同路径
 * https://leetcode.cn/problems/unique-paths/
 */
public class Hot100_27_uniquePaths {
    public static void main(String[] args) {
        int m = 3;
        int n = 7;
        Hot100_27_uniquePaths solution = new Hot100_27_uniquePaths();
        int ans = solution.uniquePaths1(m, n);
        System.out.println(ans);
    }

    // 动态规划
    public int uniquePaths1(int m, int n) {
        int[][] f = new int[m][n];
        for (int i = 0; i < m; i++) {
            f[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            f[0][j] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                f[i][j] = f[i - 1][j] + f[i][j - 1];
            }
        }
        return f[m - 1][n - 1];
    }

    // 组合数学
    public int uniquePaths2(int m, int n) {
        long ans = 1;
        for (int x = n, y = 1; y < m; x++, y++) {
            ans = ans * x / y;
        }
        return (int) ans;
    }

}
