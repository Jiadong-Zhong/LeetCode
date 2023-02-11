package SwordToOffer2;

import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer II 011. 0 和 1 个数相同的子数组
 * https://leetcode.cn/problems/A1NYOS/
 */
public class Offer2_11_findMaxLength {
    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 1};
        Offer2_11_findMaxLength solution = new Offer2_11_findMaxLength();
        int ans = solution.findMaxLength(nums);
        System.out.println(ans);
    }

    public int findMaxLength(int[] nums)  {
        int maxLength = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int counter = 0;
        map.put(counter, -1);
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            if (num == 1) {
                counter++;
            } else {
                counter--;
            }
            if (map.containsKey(counter)) {
                int prevIndex = map.get(counter);
                maxLength = Math.max(maxLength, i - prevIndex);
            } else {
                map.put(counter, i);
            }
        }
        return maxLength;
    }

}
