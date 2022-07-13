package hot100;

import java.util.Arrays;

public class Hot100_96_findUnsortedSubarray {
    public static void main(String[] args) {
        int[] nums = {2,6,4,8,10,9,15};
    }

    // 排序
    public int findUnsortedSubarray1(int[] nums) {
        if (isSorted(nums)) {
            return 0;
        }
        int[] numsSorted = new int[nums.length];
        System.arraycopy(nums, 0, numsSorted, 0, nums.length);
        Arrays.sort(numsSorted);
        int left = 0;
        while (nums[left] == numsSorted[left]) {
            left++;
        }
        int right = nums.length - 1;
        while (nums[right] == numsSorted[right]) {
            right--;
        }
        return right - left + 1;
    }

    public boolean isSorted(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                return false;
            }
        }
        return true;
    }

    // 一次遍历
    // 左侧已排序的任何一个数都小于其右侧的所有数，因此可以从右往左遍历，遇到不满足条件的就更新left，最后一个left即要更新数组的左边界
    // 同理从左往右遍历可以找到右边界
    public int findUnsortedSubarray2(int[] nums) {
        int n = nums.length;
        int maxN = Integer.MIN_VALUE, right = -1;
        int minN = Integer.MAX_VALUE, left = -1;
        for (int i = 0; i < n; i++) {
            if (maxN > nums[i]) {
                right = i;
            } else {
                maxN = nums[i];
            }

            if (minN < nums[n - i - 1]) {
                left = n - i - 1;
            } else {
                minN = nums[n - i - 1];
            }
        }
        return right == -1 ? 0 : right - left + 1;
    }
}
