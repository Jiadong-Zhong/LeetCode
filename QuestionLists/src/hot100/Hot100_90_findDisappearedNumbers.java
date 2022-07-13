package hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * 448. 找到所有数组中消失的数字
 * https://leetcode.cn/problems/find-all-numbers-disappeared-in-an-array/
 */
public class Hot100_90_findDisappearedNumbers {
    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        Hot100_90_findDisappearedNumbers solution = new Hot100_90_findDisappearedNumbers();
        List<Integer> ans = solution.findDisappearedNumbers(nums);
        System.out.println(ans);

    }

    // 原地修改
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        for (int num : nums) {
            int x = (num - 1) % n;
            nums[x] += n;
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] <= n) {
                ans.add(i + 1);
            }
        }
        return ans;
    }
}
