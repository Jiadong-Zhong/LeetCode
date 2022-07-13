package basics.d4_array;

/**
 * 240. 搜索二维矩阵 II
 * https://leetcode-cn.com/problems/search-a-2d-matrix-ii/
 */
public class SearchMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        int target = 5;
        boolean res = searchMatrix1(matrix, target);
        System.out.println(res);
    }

    public static boolean searchMatrix1(int[][] matrix, int target) {
        int row = 0;
        int col = matrix[0].length - 1;

        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == target) {
                return true;
            }

            if (matrix[row][col] > target) {
                col--;
            } else {
                row++;
            }
        }
        return false;
    }
}
