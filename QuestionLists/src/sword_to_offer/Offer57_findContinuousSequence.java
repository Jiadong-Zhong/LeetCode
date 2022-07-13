package sword_to_offer;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer 57 - II. 和为s的连续正数序列
 * https://leetcode.cn/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof/
 */
public class Offer57_findContinuousSequence {
    public static void main(String[] args) {
        int target = 9;

    }

    public int[][] findContinuousSequence(int target) {
        List<int[]> ans = new ArrayList<>();
        for (int left = 1, right = 2; left < right;) {
            int sum = (left + right) * (right - left + 1) / 2;
            if (sum == target) {
                int[] res = new int[right - left + 1];
                for (int i = left; i <= right; i++) {
                    res[i - left] = i;
                }
                ans.add(res);
                left++;
            } else if (sum < target) {
                right++;
            } else {
                left++;
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
}
