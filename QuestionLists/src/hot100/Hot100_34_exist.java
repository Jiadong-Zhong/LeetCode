package hot100;

/**
 * 79. 单词搜索
 * https://leetcode.cn/problems/word-search/
 */
public class Hot100_34_exist {
    public static void main(String[] args) {
        char[][] board = {{'A', 'B', 'C', 'D'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCCED";
        Hot100_34_exist solution = new Hot100_34_exist();
        boolean ans = solution.exist(board, word);
        System.out.println(ans);
    }

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] isVisited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    boolean flag = check(board, i, j, word, 0, isVisited);
                    if (flag) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean check(char[][] board, int row, int col, String word, int index, boolean[][] isVisited) {
        if (board[row][col] != word.charAt(index)) {
            return false;
        } else if (index == word.length() - 1) {
            return true;
        }
        isVisited[row][col] = true;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        boolean result = false;
        for (int[] dir : directions) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            if (newRow >= 0 && newRow < board.length && newCol >= 0 && newCol < board[0].length) {
                if (!isVisited[newRow][newCol]) {
                    boolean flag = check(board, newRow, newCol, word, index + 1, isVisited);
                    if (flag) {
                        result = true;
                        break;
                    }
                }
            }
        }
        isVisited[row][col] = false;
        return result;
    }
}
