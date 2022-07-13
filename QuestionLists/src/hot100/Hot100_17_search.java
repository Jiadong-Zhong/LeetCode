package hot100;

/**
 * 33. 搜索旋转排序数组
 * https://leetcode.cn/problems/search-in-rotated-sorted-array/
 */
public class Hot100_17_search {
    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        Hot100_17_search solution = new Hot100_17_search();
        int res = solution.search(nums, target);
        System.out.println(res);
    }

    public int search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return -1;

        }
        if (n == 1) {
            return nums[0] == target ? 0 : -1;
        }

        int left = 0;
        int right = n - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[0] <= nums[mid]) { // mid 左侧是有序的
                if (nums[0] <= target && target < nums[mid]) { // 目标值在有序区间内
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else { // mid 右侧是有序的
                if (nums[mid] < target && target <= nums[n - 1]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
