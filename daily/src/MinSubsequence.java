import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1403. 非递增顺序的最小子序列
 * https://leetcode.cn/problems/minimum-subsequence-in-non-increasing-order/
 */
public class MinSubsequence {
    public static void main(String[] args) {
        int[] nums = {4,4,7,6,7};

    }

    public List<Integer> minSubsequence(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        Arrays.sort(nums);
        List<Integer> ans = new ArrayList<>();
        int curr = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            curr += nums[i];
            ans.add(nums[i]);
            if (sum - curr < curr) {
                break;
            }
        }
        return ans;
    }
}
