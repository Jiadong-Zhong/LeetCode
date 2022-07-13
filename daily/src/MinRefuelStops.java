/**
 * 871. 最低加油次数
 * https://leetcode.cn/problems/minimum-number-of-refueling-stops/
 */
public class MinRefuelStops {
    public static void main(String[] args) {
        int target = 100;
        int startFuel = 10;
        int[][] stations = {{10, 60}, {20,30},{30,30},{60,40}};
    }

    // 动态规划
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int n = stations.length;
        long[] dp = new long[n + 1];
        dp[0] = startFuel;

        for (int i = 0; i < n; i++) {
            for (int j = i; j >= 0; j--) {
                if (dp[j] >= stations[i][0]) {
                    dp[j + 1] = Math.max(dp[j + 1], dp[j] + stations[i][1]);
                }
            }
        }

        for (int i = 0; i <= n; i++) {
            if (dp[i] >= target) {
                return i;
            }
        }
        return -1;
    }
}
