/**
 * 329. 矩阵中的最长递增路径
 * https://leetcode.cn/problems/longest-increasing-path-in-a-matrix/
 */
public class LongestIncreasingPath {
    public static void main(String[] args) {
        int[][] matrix = {{9,9,4}, {6,6,8}, {2,1,1}};
        LongestIncreasingPath solution = new LongestIncreasingPath();
        int ans = solution.longestIncreasingPath2(matrix);
        System.out.println(ans);
    }

    // 深度优先搜索，超时
    boolean[][] isVisited;
    int maxPath;
    public int longestIncreasingPath1(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        isVisited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(matrix, i, j, 0);
            }
        }
        return maxPath;
    }

    public void dfs(int[][] matrix, int i, int j, int count) {
        int m = matrix.length;
        int n = matrix[0].length;
        isVisited[i][j] = true;
        count++;
        maxPath = Math.max(count, maxPath);
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int[] dir : dirs) {
            int newRow = i + dir[0];
            int newCol = j + dir[1];
            if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && !isVisited[newRow][newCol] && matrix[newRow][newCol] > matrix[i][j]) {
                dfs(matrix, newRow, newCol, count);
            }
        }
        isVisited[i][j] = false;
    }

    // 记忆化深度优先搜索
    public int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int rows, cols;
    public int[][] memo;
    public int longestIncreasingPath2(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        rows = matrix.length;
        cols = matrix[0].length;
        memo = new int[rows][cols];
        int ans = 0;
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                ans = Math.max(ans, dfs(matrix, i, j));
            }
        }
        return ans;
    }

    public int dfs(int[][] matrix, int row, int column) {
        if (memo[row][column] != 0) {
            return memo[row][column];
        }
        ++memo[row][column];
        for (int[] dir : dirs) {
            int newRow = row + dir[0], newColumn = column + dir[1];
            if (newRow >= 0 && newRow < rows && newColumn >= 0 && newColumn < cols && matrix[newRow][newColumn] > matrix[row][column]) {
                memo[row][column] = Math.max(memo[row][column], dfs(matrix, newRow, newColumn) + 1);
            }
        }
        return memo[row][column];
    }
}
