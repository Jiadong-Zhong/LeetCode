package hot100;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 200. 岛屿数量
 * https://leetcode.cn/problems/number-of-islands/
 * 并查集没弄太明白，剑指offer专项突破p341
 */
public class Hot100_59_numIslands {
    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}};
        Hot100_59_numIslands solution = new Hot100_59_numIslands();
        int ans = solution.numIslands3(grid);
        System.out.println(ans);
    }

    // 深度优先搜索
    public int numIslands1(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    count++; // 若出现元素为1，岛屿数量+1
                    dfs(grid, i, j); // dfs将该岛屿元素全部设置为0
                }
            }
        }
        return count;
    }

    public void dfs(char[][] grid, int i, int j) {
        int m = grid.length, n = grid[0].length;
        grid[i][j] = '0';
        if (i - 1 >= 0 && grid[i - 1][j] == '1') {
            dfs(grid, i - 1, j);
        }
        if (i + 1 < m && grid[i + 1][j] == '1') {
            dfs(grid, i + 1, j);
        }
        if (j - 1 >= 0 && grid[i][j - 1] == '1') {
            dfs(grid, i, j - 1);
        }
        if (j + 1 < n && grid[i][j + 1] == '1') {
            dfs(grid, i, j + 1);
        }
    }

    // 广度优先搜索
    public int numIslands2(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    Deque<Integer> neighbors = new ArrayDeque<>();
                    neighbors.offer(i * n + n);
                    while (!neighbors.isEmpty()) {
                        int id = neighbors.poll();
                        int row = id / n;
                        int col = id % n;
                        if (row - 1 >= 0 && grid[row - 1][col] == '1') {
                            neighbors.offer((row - 1) * n + col);
                            grid[row - 1][col] = '0';
                        }
                        if (row + 1 < m && grid[row + 1][col] == '1') {
                            neighbors.offer((row + 1) * n + col);
                            grid[row + 1][col] = '0';
                        }
                        if (col - 1 >= 0 && grid[row][col - 1] == '1') {
                            neighbors.offer(row * n + col - 1);
                            grid[row][col - 1] = '0';
                        }
                        if (col + 1 < n && grid[row][col + 1] == '1') {
                            neighbors.offer(row * n + col + 1);
                            grid[row][col + 1] = '0';
                        }
                    }
                }
            }
        }
        return count;
    }

    // 并查集
    public int numIslands3(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;
        UnionFind uf = new UnionFind(grid);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    grid[i][j] = '0';
                    if (i - 1 >= 0 && grid[i - 1][j] == '1') {
                        uf.union(i * n + j, (i - 1) * n + j);
                    }
                    if (i + 1 < m && grid[i + 1][j] == '1') {
                        uf.union(i * n + j, (i + 1) * n + j);
                    }
                    if (j - 1 >= 0 && grid[i][j - 1] == '1') {
                        uf.union(i * n + j, i * n + j - 1);
                    }
                    if (j + 1 < n && grid[i][j + 1] == '1') {
                        uf.union(i * n + j, i * n + j + 1);
                    }
                }
            }
        }
        return uf.getCount();
    }

    static class UnionFind {
        int count;
        int[] parent;
        int[] rank;

        public UnionFind(char[][] grid) {
            count = 0;
            int m = grid.length;
            int n = grid[0].length;
            parent = new int[m * n];
            rank = new int[m * n];
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (grid[i][j] == '1') {
                        parent[i * n + j] = i * n + j;
                        ++count;
                    }
                    rank[i * n + j] = 0;
                }
            }
        }

        public int find(int i) {
            if (parent[i] != i) parent[i] = find(parent[i]);
            return parent[i];
        }

        public void union(int x, int y) {
            int rootx = find(x);
            int rooty = find(y);
            if (rootx != rooty) {
                if (rank[rootx] > rank[rooty]) {
                    parent[rooty] = rootx;
                } else if (rank[rootx] < rank[rooty]) {
                    parent[rootx] = rooty;
                } else {
                    parent[rooty] = rootx;
                    rank[rootx] += 1;
                }
                --count;
            }
        }

        public int getCount() {
            return count;
        }
    }
}
