package hot100;

/**
 * 53. 最大子数组和
 * https://leetcode.cn/problems/maximum-subarray/
 */
public class Hot100_24_maxSubArray {
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        Hot100_24_maxSubArray solution = new Hot100_24_maxSubArray();
        int ans = solution.maxSubArray3(nums);
        System.out.println(ans);
    }

    public int maxSubArray1(int[] nums) {
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            maxSum = Math.max(maxSum, sum);
            if (sum < 0) {
                sum = 0;
            }
        }
        return maxSum;
    }

    public int maxSubArray2(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }

    // 前缀和
    public int maxSubArray3(int[] nums) {
        int preSum = 0;
        int minSum = 0;
        int maxSubSum = Integer.MIN_VALUE;
        for (int num : nums) {
            preSum += num;
            maxSubSum = Math.max(maxSubSum, preSum - minSum);
            minSum = Math.min(minSum, preSum);
        }
        return maxSubSum;
    }
}
