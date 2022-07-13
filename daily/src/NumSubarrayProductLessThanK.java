/**
 * 713. 乘积小于 K 的子数组
 * https://leetcode-cn.com/problems/subarray-product-less-than-k/
 */
public class NumSubarrayProductLessThanK {
    public static void main(String[] args) {
        int[] nums = {10,9,10,4,3,8,3,3,6,2,10,10,9,3};
        int k = 19;
        int res = numSubarrayProductLessThanK3(nums, k);
        System.out.println(res);
    }

    public static int numSubarrayProductLessThanK1(int[] nums, int k) {
        int res = 0;
        for (int start = 0; start < nums.length; start++) {
            int product = 1;
            for (int end = start; end >= 0; end--) {
                product *= nums[end];
                if (product < k) {
                    res++;
                } else {
                    break;
                }
            }
        }
        return res;
    }

    public static int numSubarrayProductLessThanK2(int[] nums, int k) {
        if (k == 0) {
            return 0;
        }
        int n = nums.length;
        double[] logPrefix = new double[n + 1];
        for (int i = 0; i < n; i++) {
            logPrefix[i + 1] = logPrefix[i] + Math.log(nums[i]);
        }
        double logk = Math.log(k);
        int res = 0;
        for (int i = 0; i < n; i++) {
            int l = 0;
            int r = i + 1;
            int index = i + 1;
            double val = logPrefix[i + 1] - logk + 1e-10;
            while (l <= r) {
                int mid = (l + r) / 2;
                if (logPrefix[mid] > val) {
                    index = mid;
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
            res += i + 1 - index;
        }
        return res;
    }

    public static int numSubarrayProductLessThanK3(int[] nums, int k) {
        int n = nums.length, ret = 0;
        int prod = 1, i = 0;
        for (int j = 0; j < n; j++) {
            prod *= nums[j];
            while (i <= j && prod >= k) {
                prod /= nums[i];
                i++;
            }
            ret += j - i + 1;
        }
        return ret;
    }
}
