import java.util.ArrayList;
import java.util.List;

/**
 * 54. 螺旋矩阵
 * https://leetcode.cn/problems/spiral-matrix/
 */
public class SpiralOrder {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5,6,7,8}, {9,10,11,12}};
        SpiralOrder solution = new SpiralOrder();
        List<Integer> ans = solution.spiralOrder1(matrix);
        System.out.println(ans);
    }

    // 自己写的
    public List<Integer> spiralOrder1(int[][] matrix) {
        int m = matrix.length;  // 3
        int n = matrix[0].length; // 4
        List<Integer> ans = new ArrayList<>();
        int depth = (Math.min(m, n) + 1) / 2;
        for (int i = 0; i < depth; i++) {
            // 上方从左到右，遍历列
            for (int j = i; j < n - i; j++) {
                ans.add(matrix[i][j]);
            }
            // 右侧从上到下，遍历行
            for (int j = i + 1; j < m - i; j++) {
                ans.add(matrix[j][n - i - 1]);
            }
            // 下方从右到左，遍历列
            for (int j = n - i - 2; j >= i && (m - i - 1 != i); j--) {
                ans.add(matrix[m - i - 1][j]);
            }
            // 左侧从下到上，遍历行
            for (int j = m - i - 2; j >= i + 1 && (n - i - 1 != i); j--) {
                ans.add(matrix[j][i]);
            }
        }
        return ans;
    }

    // 题解
    public List<Integer> spiralOrder2(int[][] matrix) {
        List<Integer> order = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return order;
        }
        int rows = matrix.length, columns = matrix[0].length;
        int left = 0, right = columns - 1, top = 0, bottom = rows - 1;
        while (left <= right && top <= bottom) {
            for (int column = left; column <= right; column++) {
                order.add(matrix[top][column]);
            }
            for (int row = top + 1; row <= bottom; row++) {
                order.add(matrix[row][right]);
            }
            if (left < right && top < bottom) {
                for (int column = right - 1; column > left; column--) {
                    order.add(matrix[bottom][column]);
                }
                for (int row = bottom; row > top; row--) {
                    order.add(matrix[row][left]);
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return order;
    }
}
