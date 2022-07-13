/**
 * 540. 有序数组中的单一元素
 * https://leetcode.cn/problems/single-element-in-a-sorted-array/
 */
public class SingleNonDuplicate {
    public static void main(String[] args) {

    }

    public int singleNonDuplicate(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == nums[mid ^ 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }
}
