import java.util.Arrays;
import java.util.Random;

/**
 * 462. 最少移动次数使数组元素相等 II
 * https://leetcode.cn/problems/minimum-moves-to-equal-array-elements-ii/
 */
public class MinMoves2 {
    public static void main(String[] args) {
        int[] nums = {1, 10, 2, 9};
        int res = minMoves21(nums);
        System.out.println(res);
    }

    public static int minMoves21(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int res = 0;
        int x = nums[n / 2];
        for (int i = 0; i < n; i++) {
            res += Math.abs(nums[i] - x);
        }
        return res;
    }

    static Random random = new Random();
    public static int minMoves22(int[] nums) {
        int n = nums.length, x = quickSelect(nums, 0, n - 1, n / 2), res = 0;
        for (int i = 0; i < n; i++) {
            res += Math.abs(nums[i] - x);
        }
        return res;
    }

    public static int quickSelect(int[] nums, int left, int right, int index) {
        int q = randomPartition(nums, left, right);
        if (q == index) {
            return nums[q];
        } else {
            return q < index ? quickSelect(nums, q + 1, right, index) : quickSelect(nums, left, q - 1, index);
        }
    }

    public static int randomPartition(int[] nums, int left, int right) {
        int i = random.nextInt(right - left + 1) + left;
        swap(nums, i, right);
        return partition(nums, left, right);
    }

    public static int partition(int[] nums, int left, int right) {
        int x = nums[right];
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (nums[j] <= x) {
                i++;
                swap(nums, i, j);
            }
        }
        swap(nums, i + 1, right);
        return i + 1;
    }

    public static void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
