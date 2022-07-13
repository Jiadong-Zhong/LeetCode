/**
 * 883. 三维形体投影面积
 * https://leetcode-cn.com/problems/projection-area-of-3d-shapes/
 */
public class ProjectionArea {
    public static void main(String[] args) {
        int[][] grid = {{1,2}, {3,4}};
        int res = projectionArea1(grid);
        System.out.println(res);
    }

    public static int projectionArea1(int[][] grid) {
        // 分别为grid中不等于0的元素个数
        // 每一列最大值的和
        // 每一行最大值的和
        int xyArea = 0;
        int zxArea = 0;
        int yzArea = 0;

        for (int i = 0; i < grid.length; i++) {
            int yzHeight = 0;
            int zxHeight = 0;
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != 0) {
                    xyArea++;
                }
                yzHeight = Math.max(yzHeight, grid[j][i]);
                zxHeight = Math.max(zxHeight, grid[i][j]);
            }
            zxArea += zxHeight;
            yzArea += yzHeight;
        }
        return xyArea + zxArea + yzArea;
    }
}
