/**
 * 812. 最大三角形面积
 * https://leetcode.cn/problems/largest-triangle-area/
 * 法二：凸包未看
 */
public class LargestTriangleArea {
    public static void main(String[] args) {
        int[][] points = {{0, 0}, {0, 1}, {1, 0}, {0, 2}, {2, 0}};
        double res = largestTriangleArea1(points);
        System.out.println(res);
    }

    public static double largestTriangleArea1(int[][] points) {
        int n = points.length;
        double res = 0.0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    res = Math.max(res, triangleArea(points[i], points[j], points[k]));
                }
            }
        }
        return res;
    }

    public static double triangleArea(int[] point1, int[] point2, int[] point3) {
        return 0.5 * Math.abs(point1[0] * point2[1] + point2[0] * point3[1] + point3[0] * point1[1] - point1[0] * point3[1] - point2[0] * point1[1] - point3[0] * point2[1]);
    }
}
