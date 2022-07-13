/**
 * 剑指 Offer 42. 连续子数组的最大和
 * https://leetcode.cn/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof/
 */
public class MaxSubArray42 {
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        MaxSubArray42 solution = new MaxSubArray42();
        int ans = solution.maxSubArray(nums);
        System.out.println(ans);
    }

    public int maxSubArray(int[] nums) {
        int ans = nums[0];
        int pre = 0;
        for (int num : nums) {
            pre = Math.max(num, pre + num);
            ans = Math.max(ans, pre);
        }
        return ans;
    }
}
