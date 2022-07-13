package sword_to_offer;

/**
 * 剑指 Offer 11. 旋转数组的最小数字
 * https://leetcode.cn/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/
 */
public class Offer11_minArray {
    public static void main(String[] args) {
        int[] nums = {3,4,5,1,2};
        Offer11_minArray solution = new Offer11_minArray();
        int ans = solution.minArray(nums);
        System.out.println(ans);
    }

    public int minArray(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > nums[high]) {
                low = mid + 1;
            } else if (nums[mid] < nums[high]) {
                high = mid;
            } else {
                high--;
            }
        }
        return nums[low];
    }
}
