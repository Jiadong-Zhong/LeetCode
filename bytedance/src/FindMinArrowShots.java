import java.util.Arrays;
import java.util.Comparator;

/**
 * 452. 用最少数量的箭引爆气球
 * https://leetcode.cn/problems/minimum-number-of-arrows-to-burst-balloons/
 */
public class FindMinArrowShots {
    public static void main(String[] args) {

    }

    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }

        Arrays.sort(points, Comparator.comparingInt(o -> o[1]));

        int pos = points[0][1];
        int ans = 1;
        for (int[] balloon : points) {
            if (balloon[0] > pos) {
                pos = balloon[1];
                ans++;
            }
        }
        return ans;
    }
}
