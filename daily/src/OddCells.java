/**
 * 1252. 奇数值单元格的数目
 * https://leetcode.cn/problems/cells-with-odd-values-in-a-matrix/
 */
public class OddCells {
    public static void main(String[] args) {
        int m = 2, n = 3;
        int[][] indices = {{0, 1}, {1, 1}};

        OddCells solution = new OddCells();
        int ans = solution.oddCells1(m, n, indices);
        System.out.println(ans);

    }


    // 直接模拟
    public int oddCells1(int m, int n, int[][] indices) {
        int ans = 0;
        int[][] matrix = new int[m][n];
        for (int k = 0; k < indices.length; k++) {
            int curRow = indices[k][0];
            int curCol = indices[k][1];

            for (int i = 0; i < m; i++) {
                matrix[i][curCol]++;
            }

            for (int j = 0; j < n; j++) {
                matrix[curRow][j]++;
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] % 2 == 1) {
                    ans++;
                }
            }
        }
        return ans;
    }

    // 空间优化
    public int oddCells2(int m, int n, int[][] indices) {
        int[] rows = new int[m];
        int[] cols = new int[n];
        for (int[] index : indices) {
            rows[index[0]]++;
            cols[index[1]]++;
        }

        int ans = 0;
        for (int i = 0; i < m ; i++) {
            for (int j = 0; j < n; j++) {
                if (((rows[i] + cols[j]) & 1) != 0) {
                    ans++;
                }
            }
        }
        return ans;
    }

}
