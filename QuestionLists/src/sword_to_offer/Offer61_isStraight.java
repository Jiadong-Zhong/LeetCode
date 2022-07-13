package sword_to_offer;

import java.util.Arrays;

/**
 * 剑指 Offer 61. 扑克牌中的顺子
 * https://leetcode.cn/problems/bu-ke-pai-zhong-de-shun-zi-lcof/
 */
public class Offer61_isStraight {
    public static void main(String[] args) {
        int[] nums = {0,0,1,2,5};
    }

    // 最大牌 - 最小牌 < 5且除joker外无重复即可构成顺子
    public boolean isStraight(int[] nums) {
        int joker = 0;
        Arrays.sort(nums);
        for (int i = 0; i < 4; i++) {
            if (nums[i] == 0) {
                joker++;
            } else if (nums[i] == nums[i + 1]) {
                return false;
            }
        }
        return nums[4] - nums[joker] < 5;
    }
}
