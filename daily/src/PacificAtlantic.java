import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 417. 太平洋大西洋水流问题
 * https://leetcode-cn.com/problems/pacific-atlantic-water-flow/
 */
public class PacificAtlantic {
    public static void main(String[] args) {
        int[][] heights = {{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
        List<List<Integer>> res = pacificAtlantic2(heights);
        System.out.println(res);

    }

    static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int[][] heights;
    static int m;
    static int n;

    public static List<List<Integer>> pacificAtlantic1(int[][] _heights) {
        heights = _heights;
        m = _heights.length;
        n = _heights[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            dfs(i, 0, pacific);
        }
        for (int j = 1; j < n; j++) {
            dfs(0, j, pacific);
        }

        for (int i = 0; i < m; i++) {
            dfs(i, n - 1, atlantic);
        }
        for (int j = 0; j < n - 1; j++) {
            dfs(m - 1, j, atlantic);
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    List<Integer> cell = new ArrayList<>();
                    cell.add(i);
                    cell.add(j);
                    res.add(cell);
                }
            }
        }
        return res;
    }

    private static void dfs(int row, int col, boolean[][] ocean) {
        if (ocean[row][col]) {
            return;
        }
        ocean[row][col] = true;
        for (int[] dir : dirs) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && heights[newRow][newCol] >= heights[row][col]) {
                dfs(newRow, newCol, ocean);
            }
        }
    }

    public static List<List<Integer>> pacificAtlantic2(int[][] _heights) {
        heights = _heights;
        m = _heights.length;
        n = _heights[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            bfs(i, 0, pacific);
        }
        for (int j = 1; j < n; j++) {
            bfs(0, j, pacific);
        }

        for (int i = 0; i < m; i++) {
            bfs(i, n - 1, atlantic);
        }
        for (int j = 0; j < n - 1; j++) {
            bfs(m - 1, j, atlantic);
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    List<Integer> cell = new ArrayList<>();
                    cell.add(i);
                    cell.add(j);
                    res.add(cell);
                }
            }
        }
        return res;
    }

    private static void bfs(int row, int col, boolean[][] ocean) {
        if (ocean[row][col]) {
            return;
        }
        ocean[row][col] = true;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {row, col});
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            for (int[] dir : dirs) {
                int newRow = cell[0] + dir[0];
                int newCol = cell[1] + dir[1];
                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && heights[newRow][newCol] >= heights[cell[0]][cell[1]] && !ocean[newRow][newCol]) {
                    ocean[newRow][newCol] = true;
                    queue.offer(new int[] {newRow, newCol});
                }
            }
        }
    }
}
