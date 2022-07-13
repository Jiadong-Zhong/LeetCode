package hot100;

import java.util.Arrays;

/**
 * 238. 除自身以外数组的乘积
 * https://leetcode.cn/problems/product-of-array-except-self/
 */
public class Hot100_68_productExceptSelf {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        Hot100_68_productExceptSelf solution = new Hot100_68_productExceptSelf();
        int[] ans = solution.productExceptSelf1(nums);
        System.out.println(Arrays.toString(ans));
    }

    // 暴力解法
    public int[] productExceptSelf1(int[] nums) {
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = 1;
            for (int j = 0; j < nums.length; j++) {
                if (i == j) {
                    continue;
                }
                ans[i] *= nums[j];
            }
        }
        return ans;
    }

    // 左右乘积列表
    public int[] productExceptSelf2(int[] nums) {
        int length = nums.length;
        int[] L = new int[length];
        int[] R = new int[length];

        int[] ans = new int[length];

        L[0] = 1;
        for (int i = 1; i < length; i++) {
            L[i] = nums[i - 1] * L[i - 1];
        }

        R[length - 1] = 1;
        for (int i = length - 2; i>= 0; i--) {
            R[i] = nums[i + 1] * R[i + 1];
        }

        for (int i = 0; i < length; i++) {
            ans[i] = L[i] * R[i];
        }
        return ans;
    }

    // 将上面方法改为空间复杂度为O(1)
    public int[] productExceptSelf3(int[] nums) {
        int length = nums.length;
        int[] ans = new int[length];
        ans[0] = 1;
        for (int i = 1; i < length; i++) {
            ans[i] = nums[i - 1] * ans[i - 1];
        }
        int R = 1;
        for (int i = length - 1; i >= 0; i--) {
            ans[i] = ans[i] * R;
            R *= nums[i];
        }
        return ans;
    }
}
