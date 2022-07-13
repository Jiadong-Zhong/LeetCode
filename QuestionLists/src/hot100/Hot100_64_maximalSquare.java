package hot100;

/**
 * 221. 最大正方形
 * https://leetcode.cn/problems/maximal-square/
 * 这里就不再写暴力解法
 */
public class Hot100_64_maximalSquare {
    public static void main(String[] args) {
        char[][] matrix = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        Hot100_64_maximalSquare solution = new Hot100_64_maximalSquare();
        int ans = solution.maximalSquare(matrix);
        System.out.println(ans);
    }

    // 动态规划
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int maxSide = 0;
        int[][] dp = new int[m][n];  // dp表示以i,j为右下角的正方形的边长最大值
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '0') {
                    dp[i][j] = 0;
                } else {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i][j - 1])) + 1;
                    }
                    maxSide = Math.max(maxSide, dp[i][j]);
                }
            }
        }
        return maxSide * maxSide;
    }
}
