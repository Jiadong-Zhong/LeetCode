package array;

import java.util.Arrays;

/**
 * 旋转数组
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2skh7/
 */
public class RotateArray {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6};
        int k = 3;
        rotate3(nums, k);
        System.out.println(Arrays.toString(nums));
    }

    // 临时数组
    public static void rotate1(int[] nums, int k) {
        if (nums.length == 1) {
            return;
        }
        k = k % nums.length;
        int[] temp = Arrays.copyOf(nums, nums.length - k);
        for (int i = 0; i < nums.length; i++) {
            if (i < k) {
                nums[i] = nums[nums.length - k + i];
            } else {
                nums[i] = temp[i - k];
            }
        }
    }

    // 多次翻转
    public static void rotate2(int[] nums, int k) {
        if (nums.length == 1) {
            return;
        }
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);

    }

    public static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    // 环形旋转
    public static void rotate3(int[] nums, int k) {
        int hold = nums[0];
        int index = 0;
        boolean[] visited = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            index = (index + k) % nums.length;
            if (visited[index]) {
                index = (index + 1) % nums.length;
                hold = nums[index];
                i--;
            } else {
                visited[index] = true;
                int temp = nums[index];
                nums[index] = hold;
                hold = temp;
            }
        }
    }
}
