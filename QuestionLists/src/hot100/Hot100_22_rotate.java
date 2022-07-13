package hot100;

import java.util.Arrays;

/**
 * 48. 旋转图像
 * https://leetcode.cn/problems/rotate-image/
 */
public class Hot100_22_rotate {
    public static void main(String[] args) {
        int[][] matrix = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        Hot100_22_rotate solution = new Hot100_22_rotate();
        solution.rotate(matrix);
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }


    }

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < (n + 1) / 2; j++) {  // (n + 1) / 2 保证了在n为奇数时候多旋转一次，偶数时候不变
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = temp;
            }
        }
    }

    // i = 0 j = 1
    // matrix[2][0]=13 -> matrix[0][1]=1 -> matrix[1][3]=10 -> matrix[3][2]=12
}
