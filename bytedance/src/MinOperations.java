/**
 * 1658. 将 x 减到 0 的最小操作数
 * https://leetcode.cn/problems/minimum-operations-to-reduce-x-to-zero/
 */
public class MinOperations {
    public static void main(String[] args) {
        int[] nums = {1,1,4,2,3};
        int x = 5;
    }

    public int minOperations(int[] nums, int x) {
        int n = nums.length;
        int left = 0, right = 0;
        int maxLength = -1;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }

        int count = sum - x;
        if (count < 0) {
            return -1;
        }

        int sumNums = 0;
        while (right < n) {
            sumNums += nums[right];
            while(sumNums > count) {
                sumNums -= nums[left];
                left++;
            }
            if (sumNums == count) {
                maxLength = Math.max(maxLength, right - left + 1);
            }
            right++;
        }

        if (maxLength == -1) {
            return -1;
        }
        return n - maxLength;
    }
}
