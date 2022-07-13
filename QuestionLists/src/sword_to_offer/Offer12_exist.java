package sword_to_offer;

/**
 * 剑指 Offer 12. 矩阵中的路径
 * https://leetcode.cn/problems/ju-zhen-zhong-de-lu-jing-lcof/
 */
public class Offer12_exist {
    public static void main(String[] args) {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCCED";

        char[][] board1 = {{'C', 'A', 'A'}, {'A', 'A', 'A'}, {'B', 'C', 'D'}};
        String word1 = "AAB";

        Offer12_exist solution = new Offer12_exist();
        boolean ans = solution.exist(board1, word1);
        System.out.println(ans);
    }

    boolean[][] isVisited;
    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int m, n;
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }

        m = board.length;
        n = board[0].length;
        isVisited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    boolean result = dfs(board, word, i, j, 0);
                    if (result) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, String word, int row, int col, int count) {
        if (board[row][col] != word.charAt(count)) {
            return false;
        } else if (count == word.length() - 1) {
            return true;
        }
        isVisited[row][col] = true;
        for (int[] dir : dirs) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && !isVisited[newRow][newCol]) {
                boolean flag = dfs(board, word, newRow, newCol, count + 1);
                if (flag) {
                    return true;
                }
            }
        }
        isVisited[row][col] = false;
        return false;
    }
}
