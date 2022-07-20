package SwordToOffer2;

/**
 * 剑指 Offer II 008. 和大于等于 target 的最短子数组
 * https://leetcode.cn/problems/2VG8Kg/
 */
public class Offer2_8_minSubArrayLen {
    public static void main(String[] args) {
        int target = 7;
        int[] nums = {2,3,1,2,4,3};
        Offer2_8_minSubArrayLen solution = new Offer2_8_minSubArrayLen();
        int ans = solution.minSubArrayLen(target, nums);
        System.out.println(ans);
    }

    public int minSubArrayLen(int target, int[] nums) {
        int minLen = Integer.MAX_VALUE;
        int sum = 0;
        int left = 0, right = 0;
        while (right < nums.length) {
            sum += nums[right];
            while (sum >= target) {
                minLen = Math.min(right - left + 1, minLen);
                sum -= nums[left];
                left++;
            }
            right++;
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}
