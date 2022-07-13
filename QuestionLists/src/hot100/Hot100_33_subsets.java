package hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * 78. 子集
 * https://leetcode.cn/problems/subsets/
 */
public class Hot100_33_subsets {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        Hot100_33_subsets solution = new Hot100_33_subsets();
        List<List<Integer>> ans = solution.subsets1(nums);
        System.out.println(ans);
    }

    List<Integer> t = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();
    // 利用二进制表示是否在子集中，刚好2^n种情况
    public List<List<Integer>> subsets1(int[] nums) {
        int n = nums.length;
        for (int mask = 0; mask < (1 << n); mask++) {
            t.clear();
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    t.add(nums[i]);
                }
            }
            ans.add(new ArrayList<>(t));
        }
        return ans;
    }

    // 递归法
    public List<List<Integer>> subsets2(int[] nums) {
        dfs(0, nums);
        return ans;
    }

    public void dfs(int cur, int[] nums) {
        if (cur == nums.length) {
            ans.add(new ArrayList<>(t));
            return;
        }
        t.add(nums[cur]);
        dfs(cur + 1, nums);
        t.remove(t.size() - 1);
        dfs(cur + 1, nums);
    }

}
