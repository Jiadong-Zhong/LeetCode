package sword_to_offer;

/**
 * 剑指 Offer 53 - I. 在排序数组中查找数字 I
 * https://leetcode.cn/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/
 */
public class Offer53_search {
    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int target = 8;
        Offer53_search solution = new Offer53_search();
        int ans = solution.search(nums, target);
        System.out.println(ans);
    }

    public int search(int[] nums, int target) {
        int leftIndex = binarySearch(nums,target, true);
        int rightIndex = binarySearch(nums, target, false) - 1;
        if (leftIndex <= rightIndex && rightIndex < nums.length && nums[leftIndex] == target && nums[leftIndex] == target) {
            return rightIndex - leftIndex + 1;
        }
        return 0;
    }

    // lower为true查找第一个大于等于target的下标
    // 为false查找第一个大于target的下标
    public int binarySearch(int[] nums, int target, boolean lower) {
        int left = 0, right = nums.length - 1, ans = nums.length;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target || (lower && nums[mid] >= target)) {
                right = mid - 1;
                ans = mid;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
}
