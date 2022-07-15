package SwordToOffer2;

import java.util.Arrays;

/**
 * 剑指 Offer II 006. 排序数组中两个数字之和
 * https://leetcode.cn/problems/kLl5u1/
 */
public class Offer2_6_twoSum {
    public static void main(String[] args) {
        int[] numbers = {1,2,4,6,10};
        int target = 8;
        Offer2_6_twoSum solution = new Offer2_6_twoSum();
        int[] ans = solution.twoSum(numbers, target);
        System.out.println(Arrays.toString(ans));
    }

    // 暴力
    public int[] twoSum(int[] numbers, int target) {
        for (int first = 0; first < numbers.length - 1; first++) {
            for (int second = first + 1; second < numbers.length; second++) {
                if (second > first + 1 && numbers[second] == numbers[second - 1]) {
                    continue;
                }
                if (numbers[second] == target - numbers[first]) {
                    return new int[] {first, second};
                }
            }
        }
        return new int[0];
    }

    // 双指针
    public int[] twoSum2(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[] {left, right};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[0];
    }
}
