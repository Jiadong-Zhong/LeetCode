package sword_to_offer;

public class Offer04_findNumberIn2DArray {
    public static void main(String[] args) {
        int[][] matrix = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        int target = 5;
        Offer04_findNumberIn2DArray solution = new Offer04_findNumberIn2DArray();
        boolean ans = solution.findNumberIn2DArray(matrix, target);
        System.out.println(ans);
    }

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int m = matrix.length;
        int n = matrix[0].length;

        int row = 0;
        int col = n - 1;
        while (row < m && col >= 0) {
            if (matrix[row][col] == target) {
                return true;
            }
            if (matrix[row][col] < target) {
                row++;
                continue;
            }
            if (matrix[row][col] > target) {
                col--;
            }
        }
        return false;
    }
}
