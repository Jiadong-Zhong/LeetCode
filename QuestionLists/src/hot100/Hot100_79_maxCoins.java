package hot100;

import java.util.Arrays;

/**
 * 312. 戳气球
 * https://leetcode.cn/problems/burst-balloons/
 */
public class Hot100_79_maxCoins {
    public static void main(String[] args) {
        int[] nums = {3, 1, 5, 8};
        Hot100_79_maxCoins solution = new Hot100_79_maxCoins();
        int ans = solution.maxCoins2(nums);
        System.out.println(ans);
    }

    // 记忆化搜索
    public int[][] rec;
    public int[] val;

    public int maxCoins1(int[] nums) {
        int n = nums.length;
        val = new int[n + 2];
        for (int i = 1; i <= n; i++) {
            val[i] = nums[i - 1];
        }
        val[0] = val[n + 1] = 1;
        rec = new int[n + 2][n + 2];
        for (int i = 0; i <= n + 1; i++) {
            Arrays.fill(rec[i], -1);
        }
        return solve(0, n + 1);
    }

    // solve(i,j)表示将开区间(i,j)内的位置全部填满气球能够得到的最多硬币数
    public int solve(int left, int right) {
        if (left >= right - 1) {
            return 0;
        }
        if (rec[left][right] != -1) {
            return rec[left][right];
        }
        for (int i = left + 1; i < right; i++) {
            int sum = val[left] * val[i] * val[right];
            sum += solve(left, i) + solve(i, right);
            rec[left][right] = Math.max(rec[left][right], sum);
        }
        return rec[left][right];
    }

    // 动态规划
    // rec是动态规划素组，rec[i][j]表示开区间(i,j)能拿到的金币，k是这个区间最后一个被戳爆的气球
    // 所以若要想最后戳破的气球是k，则必须先把(i,k)内和(k,j)内所有气球都戳爆，即得到sum的计算方法
    // https://leetcode.cn/problems/burst-balloons/solution/tu-jie-dong-tai-gui-hua-jie-jue-chuo-qi-cx18h/
    public int maxCoins2(int[] nums) {
        int n = nums.length;
        int[][] rec = new int[n + 2][n + 2];
        int[] val = new int[n + 2];
        val[0] = val[n + 1] = 1;
        for (int i = 1; i <= n; i++) {
            val[i] = nums[i - 1];
        }
        for (int i = n - 1; i >= 0; i--) { // 如果i不倒序，会导致后续需要的没有计算出来因为k比i大
            for (int j = i + 2; j <= n + 1; j++) {
                for (int k = i + 1; k < j; k++) {
                    int sum = val[i] * val[k] * val[j];
                    sum += rec[i][k] + rec[k][j];
                    rec[i][j] = Math.max(rec[i][j], sum);
                }
            }
        }
        return rec[0][n + 1];
    }
}
