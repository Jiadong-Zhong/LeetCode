/**
 * 167. 两数之和 II - 输入有序数组
 * https://leetcode.cn/problems/two-sum-ii-input-array-is-sorted/
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] numbers = {2,7,11,15};
        int target = 9;
    }

    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            if (numbers[left] < target - numbers[right]) {
                left++;
            } else if (numbers[left] > target - numbers[right]) {
                right--;
            } else {
                return new int[] {left + 1, right + 1};
            }
        }
        return new int[0];
    }
}
