package basics.d5_array;

import java.util.HashMap;
import java.util.Map;

/**
 * 560. 和为 K 的子数组
 * https://leetcode-cn.com/problems/subarray-sum-equals-k/
 * 注意：子数组就是连续的
 */
public class SubarraySum {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int k = 3;
    }

    public static int subarraySum1(int[] nums, int k) {
        int res = 0;
        int n = nums.length;
        for (int start = 0; start < n; start++) {
            int sum = 0;
            for (int end = start; end >= 0; end--) {
                sum += nums[end];
                if (sum == k) {
                    res++;
                }
            }
        }
        return res;
    }

    public static int subarraySum2(int[] nums, int k) {
        int count = 0;
        int pre = 0;
        Map<Integer, Integer> mp = new HashMap<>();
        mp.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (mp.containsKey(pre - k)) {
                count += mp.get(pre - k);
                /*
                为什么是 count += mp.get(pre - k); 呢 ? 举个例子:
                k = 6, 数组 [1, 2, 3, 0, 6] 累加和为: [1, 3, 6, 6, 12],
                明显答案应该是 4, 当我们来到第一个累加和为 6 的位置上时,
                pre - k = 0, 也就是说从下标 0 到当前位置的累加和是一个答案,
                当来到第二个 6 的位置上时, 也就是说从下标 0 到当前位置的累加和是一个答案,
                而当来到 12 位置上时, pre - k = 6,
                也就是说从累加和为 6 的子数组的后一个位置到当前位置也是满足条件的答案,
                而累加和为 6 的子数组只有一个吗 ? 不 ! 这个例子中他有两个,
                所以 count 是 加 mp.get(pre - k);, 而不是加 1,
                 */
            }
            mp.put(pre, mp.getOrDefault(pre, 0) + 1);
        }
        return count;
    }
}
