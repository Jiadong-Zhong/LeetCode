package hot100;

/**
 * 152. 乘积最大子数组
 * https://leetcode.cn/problems/maximum-product-subarray/
 */
public class Hot100_54_maxProduct {
    public static void main(String[] args) {
        int[] nums = {2,3,-2,4};
        Hot100_54_maxProduct solution = new Hot100_54_maxProduct();
        int ans = solution.maxProduct2(nums);
        System.out.println(ans);
    }

    // 动态规划
    public int maxProduct1(int[] nums) {
        int n = nums.length;

        int[] maxF = new int[n];
        int[] minF = new int[n];
        System.arraycopy(nums, 0, maxF, 0, n);
        System.arraycopy(nums, 0, minF, 0, n);
        for (int i = 1; i < n; i++) {
            maxF[i] = Math.max(maxF[i - 1] * nums[i], Math.max(nums[i], minF[i - 1] * nums[i]));
            minF[i] = Math.min(minF[i - 1] * nums[i], Math.min(nums[i], maxF[i - 1] * nums[i]));
        }
        int ans = maxF[0];
        for (int i = 1; i < n; i++) {
            ans = Math.max(ans, maxF[i]);
        }
        return ans;
    }

    // 优化空间
    public int maxProduct2(int[] nums) {
        int n = nums.length;

        int maxF = nums[0];
        int minF = nums[0];
        int ans = nums[0];

        for (int i = 1; i < n; i++) {
            int mx = maxF, mn = minF;
            maxF = Math.max(mx * nums[i], Math.max(nums[i], mn * nums[i]));
            minF = Math.min(mn * nums[i], Math.min(nums[i], mx * nums[i]));
            ans = Math.max(maxF, ans);
        }
        return ans;
    }
}
