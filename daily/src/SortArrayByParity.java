import java.util.Arrays;

/**
 * 905. 按奇偶排序数组
 * https://leetcode-cn.com/problems/sort-array-by-parity/
 */
public class SortArrayByParity {
    public static void main(String[] args) {
        int[] nums = {0, 2};
        int[] res = sortArrayByParity1(nums);
        System.out.println(Arrays.toString(res));
    }

    public static int[] sortArrayByParity1(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return nums;
        }

        int left = 0;
        int right = n - 1;
        while (left < right) {
            while (left < right && nums[left] % 2 == 0) {
                left++;
            }
            while (left < right && nums[right] % 2 == 1) {
                right--;
            }
            if (left < right) {
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
                left++;
                right--;
            }
        }
        return nums;
    }

    public static int[] sortArrayByParity2(int[] nums) {
        int n = nums.length, index = 0;
        int[] res = new int[n];
        for (int num : nums) {
            if (num % 2 == 0) {
                res[index++] = num;
            }
        }
        for (int num : nums) {
            if (num % 2 == 1) {
                res[index++] = num;
            }
        }
        return res;
    }

    public static int[] sortArrayByParity3(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int left = 0, right = n - 1;
        for (int num : nums) {
            if (num % 2 == 0) {
                res[left++] = num;
            } else {
                res[right--] = num;
            }
        }
        return res;
    }

    public static int[] sortArrayByParity4(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            while (left < right && nums[left] % 2 == 0) {
                left++;
            }
            while (left < right && nums[right] % 2 == 1) {
                right--;
            }
            if (left < right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }
        return nums;
    }
}
