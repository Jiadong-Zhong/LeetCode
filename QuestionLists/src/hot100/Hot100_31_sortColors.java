package hot100;

import java.util.Arrays;

/**
 * 75. 颜色分类
 * https://leetcode.cn/problems/sort-colors/
 */
public class Hot100_31_sortColors {
    public static void main(String[] args) {
        int[] nums = {1,2,0,2,1,1,0};
        Hot100_31_sortColors solution = new Hot100_31_sortColors();
        solution.sortColors(nums);
        System.out.println(Arrays.toString(nums));

    }

    public void sortColors(int[] nums) {
        int n = nums.length;
        int p0 = 0;
        int p2 = n - 1;
        for (int i = 0; i <= p2; i++) {
            while (i <= p2 && nums[i] == 2) {
                swap(nums, i, p2);
                p2--;
            }
            if (nums[i] == 0) {
                swap(nums, i, p0);
                p0++;
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
