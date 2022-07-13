package hot100;

import java.util.HashMap;
import java.util.Map;

/**
 * 560. 和为 K 的子数组
 * https://leetcode.cn/problems/subarray-sum-equals-k/
 */
public class Hot100_95_subarraySum {
    public static void main(String[] args) {
        int[] nums = {1,1,1};
        int k = 2;
        Hot100_95_subarraySum solution = new Hot100_95_subarraySum();
        int ans = solution.subarraySum(nums, k);
        System.out.println(ans);
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
