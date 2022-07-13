package sword_to_offer;

import java.util.HashSet;
import java.util.Set;

/**
 * 剑指 Offer 03. 数组中重复的数字
 * https://leetcode.cn/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/
 */
public class Offer03_findRepeatNumber {
    public static void main(String[] args) {
        int[] nums = {2,3,1,0,2,5,3};
    }

    // 哈希集合
    public int findRepeatNumber1(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                return num;
            }
        }
        return -1;
    }

    // 优化空间，原地交换
    public int findRepeatNumber2(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] == i) {
                i++;
                continue;
            }
            if (nums[nums[i]] == nums[i]) {
                return nums[i];
            }
            int temp = nums[i];
            nums[i] = nums[temp];
            nums[temp] =temp;
        }
        return -1;
    }
}
