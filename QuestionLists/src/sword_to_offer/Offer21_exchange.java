package sword_to_offer;

import java.util.Arrays;

/**
 * 剑指 Offer 21. 调整数组顺序使奇数位于偶数前面
 * https://leetcode.cn/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof/
 */
public class Offer21_exchange {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        Offer21_exchange solution = new Offer21_exchange();
        int[] ans = solution.exchange(nums);
        System.out.println(Arrays.toString(ans));
    }

    // 双指针
    public int[] exchange(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            while (left < right && nums[left] % 2 == 1) {
                left++;
            }
            while (left < right && nums[right] % 2 == 0) {
                right--;
            }
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }
        return nums;
    }
}
