import java.util.Arrays;

/**
 * 剑指 Offer 29. 顺时针打印矩阵
 * https://leetcode.cn/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/
 */
public class SpiralOrder_29 {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        SpiralOrder_29 solution = new SpiralOrder_29();
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
            for (int i = left; i <= right; i++) {
                ans[index++] = matrix[top][i];
            }
            for (int i = top + 1; i <= bottom; i++) {
                ans[index++] = matrix[i][right];
            }
            if (left < right && top < bottom) {
                for (int i = right - 1; i > left; i--) {
                    ans[index++] = matrix[bottom][i];
                }
                for (int i = bottom; i > top; i--) {
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
