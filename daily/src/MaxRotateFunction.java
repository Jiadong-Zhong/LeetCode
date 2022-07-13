import java.util.Arrays;

/**
 * 396. 旋转函数
 * https://leetcode-cn.com/problems/rotate-function/
 */
public class MaxRotateFunction {
    public static void main(String[] args) {
        int[] nums = {4,3,2,6};
        int res = maxRotateFunction1(nums);
        System.out.println(res);
    }

    public static int maxRotateFunction1(int[] nums) {
        int n = nums.length;
        int f = 0;
        int numSum = Arrays.stream(nums).sum();

        for (int i = 0; i < n; i++) {
            f += i * nums[i];
        }

        int res = f;
        for (int i = n - 1; i > 0; i--) {
            f += numSum - n * nums[i];
            res = Math.max(res, f);
        }
        return res;
    }
}
