package basics.d5_array;

/**
 * 238. 除自身以外数组的乘积
 * https://leetcode-cn.com/problems/product-of-array-except-self/
 */
public class ProductExceptSelf {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
    }

    public static int[] productExceptSelf1(int[] nums){
        int n = nums.length;

        int[] L = new int[n];
        L[0] = 1;
        for (int i = 1; i < n; i++) {
            L[i] = L[i - 1] * nums[i - 1];
        }

        int[] R = new int[n];
        R[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            R[i] = R[i + 1] * nums[i + 1];
        }

        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = L[i] * R[i];
        }
        return res;
    }

    public static int[] productExceptSelf2(int[] nums) {
        int n = nums.length;

        int[] ans = new int[n];
        ans[0] = 1;
        for (int i = 1; i < n; i++) {
            ans[i] = ans[i - 1] * nums[i - 1];
        }

        int R = 1;
        for (int i = n - 1; i >= 0; i--) {
            ans[i] *= R;
            R *= nums[i];
        }
        return ans;
    }
}
