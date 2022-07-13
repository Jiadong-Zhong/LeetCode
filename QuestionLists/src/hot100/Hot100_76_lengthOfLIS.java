package hot100;

/**
 * 300. 最长递增子序列
 * https://leetcode.cn/problems/longest-increasing-subsequence/
 */
public class Hot100_76_lengthOfLIS {
    public static void main(String[] args) {
        int[] nums = {10, 9, 2,5,3,7,101,18};
        Hot100_76_lengthOfLIS solution = new Hot100_76_lengthOfLIS();
        int ans = solution.lengthOfLIS1(nums);
        System.out.println(ans);
    }

    // 动态规划
    public int lengthOfLIS1(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        int[] dp = new int[length];
        int ans = 1;
        dp[0] = 1;
        for (int i = 1; i < length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

    // 贪心 + 二分
    // d[i]，表示长度为 i 的最长上升子序列的末尾元素的最小值
    public int lengthOfLIS2(int[] nums) {
        int len = 1, n = nums.length;
        if (n == 0) {
            return 0;
        }
        int[] d = new int[n + 1];
        d[len] = nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i] > d[len]) {
                len++;
                d[len] = nums[i];
            } else {
                int left = 1, right = len, pos = 0;  // 如果没有找到pos说明所有数都比nums[i]大，所以更新d[1]
                while (left <= right) {
                    int mid = (left + right) >> 1;
                    if (d[mid] < nums[i]) {
                        pos = mid;
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
                d[pos + 1] = nums[i];
            }
        }
        return len;
    }
}
