package sword_to_offer;

/**
 * 剑指 Offer 42. 连续子数组的最大和
 * https://leetcode.cn/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof/
 */
public class Offer42_maxSubArray {
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};

    }

    public int maxSubArray(int[] nums) {
        int ans = nums[0];
        int pre = 0;
        for (int num : nums) {
            pre = Math.max(pre, pre + num);
            ans = Math.max(ans, pre);
        }
        return ans;
    }
}
