package SwordToOffer2;

/**
 * 剑指 Offer II 009. 乘积小于 K 的子数组
 * https://leetcode.cn/problems/ZVAVXX/
 */
public class Offer2_9_numSubarrayProductLessThanK {
    public static void main(String[] args) {
        int[] nums = {10,5,2,6};
        int k = 100;
        Offer2_9_numSubarrayProductLessThanK solution = new Offer2_9_numSubarrayProductLessThanK();
        int ans = solution.numSubarrayProductLessThanK(nums, k);
        System.out.println(ans);
    }

    // 暴力
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int product = nums[i];
            if (product < k) {
                ans++;
            }
            for (int j = i + 1; j < nums.length; j++) {
                product *= nums[j];
                if (product < k) {
                    ans++;
                } else {
                    break;
                }
            }
        }
        return ans;
    }

    // 滑动窗口
    public int numSubarrayProductLessThanK2(int[] nums, int k) {
        int n = nums.length, ans = 0;
        int prod = 1, i = 0;
        for (int j = 0; j < n; j++) {
            prod *= nums[j];
            while (i <= j && prod >= k) {
                prod /= nums[i];
                i++;
            }
            ans += j - i + 1;
        }
        return ans;
    }
}
