import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 40. 组合总和 II
 * https://leetcode.cn/problems/combination-sum-ii/
 */
public class CombinationSum2 {
    public static void main(String[] args) {
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        CombinationSum2 solution = new CombinationSum2();
        List<List<Integer>> ans = solution.combinationSum2(candidates, target);
        System.out.println(ans);
    }

    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(candidates, target, 0, 0);
        return ans;
    }

    public void backtrack(int[] candidates, int target, int sum, int begin) {
        if (sum == target) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        for (int i = begin; i < candidates.length; i++) {
            if (i > begin && candidates[i] == candidates[i - 1]) {
                continue;
            }
            int currSum = candidates[i] + sum;
            if (currSum <= target) {
                temp.add(candidates[i]);
                backtrack(candidates, target, currSum, i + 1);
                temp.remove(temp.size() - 1);
            } else {
                break;
            }
        }
    }
}
