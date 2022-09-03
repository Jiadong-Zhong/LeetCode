import java.util.Arrays;
import java.util.Comparator;

/**
 * 646. 最长数对链
 * https://leetcode.cn/problems/maximum-length-of-pair-chain/
 */
public class FindLongestChain {
    public static void main(String[] args) {
        int[][] pairs = {{1, 2}, {2, 3}, {3, 4}, {5, 7}, {3, 5}};
        FindLongestChain solution = new FindLongestChain();
        int ans = solution.findLongestChain(pairs);
        System.out.println(ans);
    }

    // 动态规划
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (Comparator.comparingInt(o -> o[0])));
        int[] dp = new int[pairs.length];
        Arrays.fill(dp, 1);
        for (int i = 0; i < pairs.length; i++) {
            for (int j = 0; j < i; j++) {
                if (pairs[i][0] > pairs[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[pairs.length - 1];
    }

    // 贪心
    public int findLongestChain2(int[][] pairs) {
        int curr = Integer.MIN_VALUE;
        int ans = 0;
        Arrays.sort(pairs, Comparator.comparingInt(o -> o[1]));
        for (int[] pair : pairs) {
            if (curr < pair[0]) {
                curr = pair[1];
                ans++;
            }
        }
        return ans;
    }
}
