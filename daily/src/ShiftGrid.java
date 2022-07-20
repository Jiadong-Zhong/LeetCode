import java.util.ArrayList;
import java.util.List;

/**
 * 1260. 二维网格迁移
 * https://leetcode.cn/problems/shift-2d-grid/
 */
public class ShiftGrid {
    public static void main(String[] args) {
        int[][] grid = {{3,8,1,9},{19,7,2,5},{4,6,11,10},{12,0,21,13}};
        int[][] grid1 = {{1},{2},{3},{4},{7},{6},{5}};
        int k = 23;
        ShiftGrid solution = new ShiftGrid();
        List<List<Integer>> ans = solution.shiftGrid2(grid1, k);
        System.out.println(ans);
    }

    // 自己写的，模拟
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            int temp = grid[m - 1][n - 1];
            int count = m * n - 1;
            int x = count / n, y = count % n;
            while (count >= 1) {
                int preX = (count - 1) / n, preY = (count - 1) % n;
                grid[x][y] = grid[preX][preY];
                count--;
                x = preX;
                y = preY;
            }
            grid[0][0] = temp;
        }

        for (int i = 0; i < m; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                row.add(grid[i][j]);
            }
            ans.add(row);
        }
        return ans;
    }

    // 优化一下，一次走k步
    public List<List<Integer>> shiftGrid2(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curList = new ArrayList<>();
        k = k % (m * n);
        for (int i = 0; i < k; i++) {
            int count = m * n - k + i;
            int x = count / n, y = count % n;
            curList.add(grid[x][y]);
            if (curList.size() == n) {
                ans.add(curList);
                curList = new ArrayList<>();
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                curList.add(grid[i][j]);
                if (curList.size() == n) {
                    ans.add(curList);
                    if (ans.size() == m) {
                        return ans;
                    }
                    curList = new ArrayList<>();
                }
            }
        }
        return ans;
    }

    // 一维
    public List<List<Integer>> shiftGrid3(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                row.add(0);
            }
            ans.add(row);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int index = (i * n + j + k) % (m * n);
                ans.get(index / n).set(index % n, grid[i][j]);
            }
        }
        return ans;
    }
}
