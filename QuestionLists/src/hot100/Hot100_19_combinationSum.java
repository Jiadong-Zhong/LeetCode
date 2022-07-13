package hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * 39. 组合总和
 * https://leetcode.cn/problems/combination-sum/
 */
public class Hot100_19_combinationSum {
    public static void main(String[] args) {
        int[] candidates = {2,3,6,7};
        int target = 7;
        Hot100_19_combinationSum solution = new Hot100_19_combinationSum();
        solution.combinationSum1(candidates, target);
    }

    public List<List<Integer>> combinationSum1(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> combine = new ArrayList<>();
        dfs(candidates, target, ans, combine, 0);
        return ans;
    }

    public void dfs(int[] candidates, int target, List<List<Integer>> ans, List<Integer> combine, int index) {
        if (index == candidates.length) {
            return;
        }
        if (target == 0) {
            ans.add(new ArrayList<>(combine));
            return;
        }
        // 直接跳过
        dfs(candidates, target, ans, combine, index + 1);
        // 选择当前数
        if (target - candidates[index] >= 0) {
            combine.add(candidates[index]);
            dfs(candidates, target - candidates[index], ans, combine, index);
            combine.remove(combine.size() - 1);
        }
    }
}
