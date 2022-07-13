package sword_to_offer;

/**
 * 剑指 Offer 47. 礼物的最大价值
 * https://leetcode.cn/problems/li-wu-de-zui-da-jie-zhi-lcof/
 */
public class Offer47_maxValue {
    public static void main(String[] args) {
        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        Offer47_maxValue solution = new Offer47_maxValue();
        int ans = solution.maxValue2(grid);
        System.out.println(ans);
    }


    // 动态规划超时
    int[][] dirs = {{0,1},{1,0}};
    int max = 0;
    int m,n;
    boolean[][] isVisited;
    public int maxValue1(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        m = grid.length;
        n = grid[0].length;

        isVisited = new boolean[m][n];
        dfs(grid, 0, 0, 0);
        return max;
    }

    public void dfs(int[][] grid, int row, int col, int count) {
        count += grid[row][col];
        if (row == m - 1 && col == n - 1) {
            max = Math.max(max, count);
            return;
        }
        isVisited[row][col] = true;
        for (int[] dir : dirs) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            if (newRow < m && newCol < n && !isVisited[newRow][newCol]) {
                dfs(grid, newRow, newCol, count);
            }
        }
        isVisited[row][col] = false;
    }

    // 动态规划
    public int maxValue2(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                if (i == 0) {
                    grid[i][j] += grid[i][j - 1];
                } else if (j == 0) {
                    grid[i][j] += grid[i - 1][j];
                } else {
                    grid[i][j] += Math.max(grid[i - 1][j], grid[i][j - 1]);
                }
            }
        }
        return grid[m - 1][n - 1];
    }
}
