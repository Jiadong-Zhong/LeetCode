package SwordToOffer2;

import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer II 010. 和为 k 的子数组
 * https://leetcode.cn/problems/QTMn0o/
 */
public class Offer2_10_subarraySum {
    public static void main(String[] args) {
        int[] nums = {1,1,1};
        int k = 2;
    }

    public int subarraySum(int[] nums, int k) {
        int count = 0, pre = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (map.containsKey(pre - k)) {
                count += map.get(pre - k);
            }
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }
        return count;
    }
}
