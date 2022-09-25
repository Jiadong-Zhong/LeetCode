import java.util.Arrays;

/**
 * 1413. 逐步求和得到正数的最小值
 * https://leetcode.cn/problems/minimum-value-to-get-positive-step-by-step-sum/
 */
public class MinStartValue {
    public static void main(String[] args) {
        int[] nums = {1,-2,-3};
        MinStartValue solution = new MinStartValue();
        int ans = solution.minStartValue(nums);
        System.out.println(ans);
    }

    // 贪心
    public int minStartValue(int[] nums) {
        int n = nums.length;
        int sum = 0;
        int min = 0;
        for (int num : nums) {
            sum += num;
            min = Math.min(min, sum);
        }
        return 1 - min;
    }

    // 二分
    public int minStartValue2(int[] nums) {
        int m = Arrays.stream(nums).min().getAsInt();
        if (m >= 0) {
            return 1;
        }
        int left = 1, right = -m * nums.length + 1;
        while (left < right) {
            int medium = (left + right) / 2;
            if (valid(medium, nums)) {
                right = medium;
            } else {
                left = medium + 1;
            }
        }
        return left;
    }

    public boolean valid(int startValue, int[] nums) {
        for (int num : nums) {
            startValue += num;
            if (startValue <= 0) {
                return false;
            }
        }
        return true;
    }
}
