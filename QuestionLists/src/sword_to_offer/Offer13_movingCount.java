package sword_to_offer;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 剑指 Offer 13. 机器人的运动范围
 * https://leetcode.cn/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/
 */
public class Offer13_movingCount {
    public static void main(String[] args) {
        int m = 3, n = 2, k = 1;
        Offer13_movingCount solution = new Offer13_movingCount();
        int ans = solution.movingCount2(m, n, k);
        System.out.println(ans);
    }

    // 广度优先
    public int movingCount1(int m, int n, int k) {
        if (k == 0) {
            return 1;
        }
        int count = 1;
        int[][] dirs = {{1,0},{0,1}};
        boolean[][] isVisited = new boolean[m][n];
        isVisited[0][0] = true;
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {0, 0});
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int row = curr[0];
            int col = curr[1];
            for (int[] dir : dirs) {
                int newRow = row + dir[0], newCol = col + dir[1];
                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && !isVisited[newRow][newCol]) {
                    if (canEntry(newRow, newCol, k)) {
                        isVisited[newRow][newCol] = true;
                        count++;
                        queue.offer(new int[] {newRow, newCol});
                    }
                }
            }
        }
        return count;
    }

    public boolean canEntry(int row, int col, int k) {
        int count = 0;
        while (row != 0 || col != 0) {
            count += row % 10 + col % 10;
            row /= 10;
            col /= 10;
        }
        return count <= k;
    }

    // 递推
    public int movingCount2(int m, int n, int k) {
        if (k == 0) {
            return 1;
        }

        boolean[][] isVisited = new boolean[m][n];
        int ans = 1;
        isVisited[0][0] = true;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((i == 0 && j == 0) || get(i) + get(j) > k) {
                    continue;
                }
                if (i - 1 >= 0) {
                    isVisited[i][j] |= isVisited[i - 1][j];
                }
                if (j - 1 >= 0) {
                    isVisited[i][j] |= isVisited[i][j - 1];
                }
                ans += isVisited[i][j] ? 1 : 0;
            }
        }
        return ans;
    }

    public int get(int x) {
        int res = 0;
        while (x != 0) {
            res += x % 10;
            x /= 10;
        }
        return res;
    }
}
