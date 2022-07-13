package introduction.d4_array;

/**
 * 566. 重塑矩阵
 * https://leetcode-cn.com/problems/reshape-the-matrix/
 */
public class MatrixReshape {
    public static void main(String[] args) {
        int[][] mat = {{1,2},{3,4}};
        int r = 1;
        int c = 4;

    }

    public static int[][] matrixReshape1(int[][] mat, int r, int c) {
        int m = mat.length;
        int n = mat[0].length;

        if (m * n != r * c) {
            return mat;
        }

        int[][] ans = new int[r][c];
        int rowIndex = 0;
        int colIndex = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rowIndex < r && colIndex < c) {
                    ans[rowIndex][colIndex] = mat[i][j];
                    colIndex++;
                } else {
                    colIndex = 0;
                    rowIndex++;
                    ans[rowIndex][colIndex] = mat[i][j];
                    colIndex++;
                }
            }
        }
        return ans;
    }

    public static int[][] matrixReshape2(int[][] mat, int r, int c) {
        int m = mat.length;
        int n = mat[0].length;
        if (m * n != r * c) {
            return mat;
        }

        int[][] ans = new int[r][c];
        for (int x = 0; x < m * n; ++x) {
            ans[x / c][x % c] = mat[x / n][x % n];
        }
        return ans;
    }
}
