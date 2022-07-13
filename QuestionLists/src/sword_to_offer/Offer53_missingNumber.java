package sword_to_offer;

/**
 * 剑指 Offer 53 - II. 0～n-1中缺失的数字
 * https://leetcode.cn/problems/que-shi-de-shu-zi-lcof/
 */
public class Offer53_missingNumber {
    public static void main(String[] args) {
        int[] nums = {0,1,2,3,4,5,6,7,9};
        Offer53_missingNumber solution = new Offer53_missingNumber();
        int ans = solution.missingNumber(nums);
        System.out.println(ans);
    }

    public int missingNumber(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] != mid) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
