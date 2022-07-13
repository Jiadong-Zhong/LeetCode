package basics.d5_array;

/**
 * 334. 递增的三元子序列
 * https://leetcode-cn.com/problems/increasing-triplet-subsequence/
 */
public class IncreasingTriplet {
    public static void main(String[] args) {
        int[] nums = {5, 4, 3, 2, 1};
        boolean res = increasingTriplet2(nums);
        System.out.println(res);
    }

    public static boolean increasingTriplet1(int[] nums) {
        int n = nums.length;
        if (n < 3) {
            return false;
        }

        int[] leftMin = new int[n];
        leftMin[0] = nums[0];
        for (int i = 1; i < n; i++) {
            leftMin[i] = Math.min(leftMin[i - 1], nums[i]);
        }
        int[] rightMax = new int[n];
        rightMax[n-1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], nums[i]);
        }
        for (int i = 1; i < n - 1; i++) {
            if (nums[i] > leftMin[i - 1] && nums[i] < rightMax[i + 1]) {
                return true;
            }
        }
        return false;
    }

    public static boolean increasingTriplet2(int[] nums) {
        int n = nums.length;
        if (n < 3) {
            return false;
        }

        int first = nums[0];
        int second = Integer.MAX_VALUE;

        for (int i = 1; i < n; i++) {
            if (nums[i] > second) {
                return true;
            }
            if (nums[i] > first) {
                second = nums[i];
            } else {
                first = nums[i];
            }
        }
        return false;
    }
}
