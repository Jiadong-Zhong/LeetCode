package hot100;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 46. 全排列
 * https://leetcode.cn/problems/permutations/
 */
public class Hot100_21_permute {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        Hot100_21_permute solution = new Hot100_21_permute();
        List<List<Integer>> ans = solution.permute1(nums);
        System.out.println(ans);
    }

    public List<List<Integer>> permute1(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        for (int num : nums) {
            cur.add(num);
        }
        int n = nums.length;
        backtrack(n, ans, cur, 0);
        return ans;
    }

    public void backtrack(int n, List<List<Integer>> ans, List<Integer> cur, int begin) {
        if (begin == n) {
            ans.add(new ArrayList<>(cur));
        }
        for (int i = begin; i < n; i++) {
            // 动态维护数组
            Collections.swap(cur, begin, i);
            // 递归填下一个数
            backtrack(n, ans, cur, begin + 1);
            // 回溯到上一步
            Collections.swap(cur, begin, i);
        }
    }
}
