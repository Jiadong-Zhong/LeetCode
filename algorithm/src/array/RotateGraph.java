package array;

import java.util.Arrays;

/**
 * 旋转图像
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnhhkv/
 */
public class RotateGraph {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}, {13, 14, 15, 16}};
        rotate1(matrix);
        for (int[] ints : matrix) {
            System.out.println(Arrays.toString(ints));
        }
    }

    // 先上下交换，再对角交换
    public static void rotate1(int[][] matrix) {
        int len = matrix.length;
        // 上下交换
        for (int i = 0; i < len / 2; i++) {
            int[] temp = matrix[i];
            matrix[i] = matrix[len - i - 1];
            matrix[len - i - 1] = temp;
        }
        // 对角交换
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    // 一圈一圈旋转
    public static void rotate2(int[][] matrix) {
        int len = matrix.length;
        for (int i = 0; i < len / 2; i++) {
            for (int j = i; j < len - i - 1; j++) {
                int temp = matrix[i][j];
                int m = len - j - 1;
                int n = len - i - 1;
                matrix[i][j] = matrix[m][i];
                matrix[m][i] = matrix[n][m];
                matrix[n][m] = matrix[j][n];
                matrix[j][n] = temp;
            }
        }
    }
}
