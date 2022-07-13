package basics.d2_array;

import java.util.Arrays;

/**
 * 75. 颜色分类
 * https://leetcode-cn.com/problems/sort-colors/
 */
public class SortColors {
    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};
        sortColors2(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void sortColors1(int[] nums) {
        int n = nums.length;
        int p = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                int temp = nums[i];
                nums[i] = nums[p];
                nums[p] = temp;
                p++;
            }
        }
        for (int i = p; i < n; i++) {
            if (nums[i] == 1) {
                int temp = nums[i];
                nums[i] = nums[p];
                nums[p] = temp;
                p++;
            }
        }
    }

    public static void sortColors2(int[] nums) {
        int p1 = 0;
        int p2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                int temp = nums[i];
                nums[i] = nums[p2];
                nums[p2] = temp;
                p2++;
            } else if (nums[i] == 0) {
                int temp = nums[i];
                nums[i] = nums[p1];
                nums[p1] = temp;
                if (p1 < p2) {
                    temp = nums[i];
                    nums[i] = nums[p2];
                    nums[p2] = temp;
                }
                p1++;
                p2++;
            }
        }
    }

    public static void sortColors3(int[] nums) {
        int p1 = 0;
        int p2 = nums.length - 1;
        for (int i = 0; i <= p2 ; i++) {
            while (i <= p2 && nums[i] == 2) {
                int temp = nums[i];
                nums[i] = nums[p2];
                nums[p2] = temp;
                p2--;
            }
            if (nums[i] == 0) {
                int temp = nums[i];
                nums[i] = nums[p1];
                nums[p1] = temp;
                p1++;
            }
        }
    }
}
