package sword_to_offer;

import java.util.Arrays;

/**
 * 剑指 Offer 29. 顺时针打印矩阵
 * https://leetcode.cn/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/
 */
public class Offer29_spiralOrder {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        Offer29_spiralOrder solution = new Offer29_spiralOrder();
        int[] ans = solution.spiralOrder(matrix);
        System.out.println(Arrays.toString(ans));
    }

    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[] ans = new int[m * n];
        int index = 0;
        int left = 0, right = n - 1, top = 0, bottom = m - 1;
        while (index < m * n) {
            for (int j = left; j <= right; j++) {
                ans[index++] = matrix[top][j];
            }
            for (int i = top + 1; i <= bottom; i++) {
                ans[index++] = matrix[i][right];
            }
            if (left < right && top < bottom) {
                for (int j = right - 1; j >= left; j--) {
                    ans[index++] = matrix[bottom][j];
                }
                for (int i = bottom - 1; i > top; i--) {
                    ans[index++] = matrix[i][left];
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return ans;
    }
}
