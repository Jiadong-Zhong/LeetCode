package hot100;

import java.util.*;

/**
 * 128. 最长连续序列
 * https://leetcode.cn/problems/longest-consecutive-sequence/
 */
public class Hot100_47_longestConsecutive {
    public static void main(String[] args) {
        int[] nums = {100,4,200,1,3,2};
        Hot100_47_longestConsecutive solution = new Hot100_47_longestConsecutive();
        int ans = solution.longestConsecutive1(nums);
        System.out.println(ans);
    }

    public int longestConsecutive1(int[] nums) {
        Set<Integer> num_set = new HashSet<>();
        for (int num : nums) {
            num_set.add(num);
        }
        int longestStreak = 0;

        for (int num : num_set) {
            if (!num_set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (num_set.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }
        return longestStreak;
    }


}
