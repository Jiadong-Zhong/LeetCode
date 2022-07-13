
/**
 * 1037. 有效的回旋镖
 * https://leetcode.cn/problems/valid-boomerang/
 */
public class IsBoomerang {
    public static void main(String[] args) {
        int[][] points = {{1, 1}, {2, 3}, {3, 2}};
        IsBoomerang solution = new IsBoomerang();
        boolean ans = solution.isBoomerang(points);
        System.out.println(ans);
    }

    // 向量叉乘
    public boolean isBoomerang(int[][] points) {
        int[] v1 = {points[1][0] - points[0][0], points[1][1] - points[0][1]};
        int[] v2 = {points[2][0] - points[0][0], points[2][1] - points[0][1]};
        return v1[0] * v2[1] - v1[1] * v2[0] != 0;
    }
}
