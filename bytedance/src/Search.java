/**
 * 704. 二分查找
 * https://leetcode.cn/problems/binary-search/
 */
public class Search {
    public static void main(String[] args) {
        int[] nums = {-1,9,3,5,9,12};
        int target = 9;
    }

    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target > nums[mid]) {
                left = mid + 1;
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
