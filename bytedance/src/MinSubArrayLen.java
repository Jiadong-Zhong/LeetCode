/**
 * 209. 长度最小的子数组
 * https://leetcode.cn/problems/minimum-size-subarray-sum/
 */
public class MinSubArrayLen {
    public static void main(String[] args) {
        int target = 7;
        int[] nums = {2,3,1,2,4,3};

        MinSubArrayLen solution = new MinSubArrayLen();
        int ans = solution.minSubArrayLen(target, nums);
        System.out.println(ans);

    }

    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int minLen = Integer.MAX_VALUE;
        int sum = 0;
        int left = 0, right = 0;
        while (right < n) {
            sum += nums[right];
            while (sum >= target) {
                minLen = Math.min(minLen, right - left + 1);
                sum -= nums[left];
                left++;
            }
            right++;
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}
