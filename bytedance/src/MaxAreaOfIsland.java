/**
 * 695. 岛屿的最大面积
 * https://leetcode.cn/problems/max-area-of-island/
 */
public class MaxAreaOfIsland {
    public static void main(String[] args) {
        int[][] grid = {
                {0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}};

        MaxAreaOfIsland solution = new MaxAreaOfIsland();
        int ans = solution.maxAreaOfIsland(grid);
        System.out.println(ans);
    }

    int m, n;
    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0,1}};
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        m = grid.length;
        n = grid[0].length;
        int maxArea = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int area = dfs(grid, i , j, 0);
                    maxArea = Math.max(area, maxArea);
                }
            }
        }
        return maxArea;
    }

    public int dfs(int[][] grid, int row, int col, int area) {
        grid[row][col] = 0;
        area++;
        for (int[] dir : dirs) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && grid[newRow][newCol] == 1){
                area = dfs(grid, newRow, newCol, area);
            }
        }
        return area;
    }

    // 更清晰的dfs
    public int dfs(int[][] grid, int i, int j) {
        if (i < 0 || i >= m || j < 0 || j > n || grid[i][j] == 0) {
            return 0;
        }
        grid[i][j] =0;
        int count = 1;
        count += dfs(grid, i + 1, j);
        count += dfs(grid, i - 1, j);
        count += dfs(grid, i, j + 1);
        count += dfs(grid, i, j - 1);
        return count;
    }
}
