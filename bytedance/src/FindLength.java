/**
 * 718. 最长重复子数组
 * https://leetcode.cn/problems/maximum-length-of-repeated-subarray/
 */
public class FindLength {
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,2,1};
        int[] nums2 = {3,2,1,4,7};
        FindLength solution = new FindLength();
        int ans = solution.findLength1(nums1, nums2);
        System.out.println(ans);
    }

    // 动态规划
    public int findLength1(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int[][] dp = new int[m + 1][n + 1]; // 以下标i - 1为结尾的1和以j - 1结尾的B，最长重复子数组的长度
        int ans = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    ans = Math.max(ans, dp[i][j]);
                }
            }
        }
        return ans;
    }

    // 滑动窗口
    public int findLength2(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int ans = 0;
        for (int i = 0; i < m; i++) {
            int len = Math.min(n, m - i);
            if (len < ans) {
                break;
            }
            int maxLen = maxLength(nums1, nums2, i, 0, len);
            ans = Math.max(ans, maxLen);
        }

        for (int i = 0 ; i < n ; i++) {
            int len = Math.min(m, n - i);
            if (len < ans) {
                break;
            }
            int maxLen = maxLength(nums1, nums2, 0, i, len);
            ans = Math.max(ans, maxLen);
        }
        return ans;
    }

    public int maxLength(int[] nums1, int[] nums2, int offset1, int offset2, int len) {
        int ans = 0, k = 0;
        for (int i = 0; i < len; i++) {
            if (nums1[offset1 + i] == nums2[offset2 + i]) {
                k++;
            } else {
                k = 0;
            }
            ans = Math.max(ans, k);
        }
        return ans;
    }


}
