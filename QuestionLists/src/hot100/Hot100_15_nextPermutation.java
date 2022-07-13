package hot100;

import java.util.Arrays;

/**
 * 31. 下一个排列
 * https://leetcode.cn/problems/next-permutation/
 */
public class Hot100_15_nextPermutation {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        nextPermutation1(nums);
        System.out.println(Arrays.toString(nums));
    }

    /*
        需要将一个左边的较小数与右边的一个较大数交换，并且较小数尽量靠右，较大数尽可能小，
        因此反向遍历寻找较小数，较大数只比较小数大
        交换较小数和较大数，并且还要对较大数右边的序列按照升序排列，使得序列变大的幅度尽可能小
     */
    public static void nextPermutation1(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    private static void reverse(int[] nums, int start) {
        int left = start;
        int right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
