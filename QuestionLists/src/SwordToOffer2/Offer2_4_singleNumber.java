package SwordToOffer2;

import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer II 004. 只出现一次的数字
 * https://leetcode.cn/problems/WGki4K/
 */
public class Offer2_4_singleNumber {
    public static void main(String[] args) {
        int[] nums = {2,2,3,2};
        Offer2_4_singleNumber solution = new Offer2_4_singleNumber();
        int ans = solution.singleNumber(nums);
        System.out.println(ans);
    }

    // 哈希表
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        int ans = 0;
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            int num = entry.getKey(), occ = entry.getValue();
            if (occ == 1) {
                ans = num;
                break;
            }
        }
        return ans;
    }

    // 依次确定每个二进制位
    public int singleNumber2(int[] nums) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int total = 0;
            for (int num : nums) {
                total += ((num >> i) & 1);
            }
            if (total % 3 != 0) {
                ans |= (1 << i);
            }
        }
        return ans;
    }

    // 数电的方法没看
}
