package array;

import java.util.HashMap;
import java.util.Map;

/**
 * 只出现一次的数字
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x21ib6/
 */
public class SingleNumber {
    public static void main(String[] args) {
        int[] nums = {2,2,1};
        int num = singleNumber2(nums);
        System.out.println(num);
    }

    public static int singleNumber1(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return -1;
    }

    // 位运算
    public static int singleNumber2(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            ans ^= num;
        }
        return ans;
    }
}
