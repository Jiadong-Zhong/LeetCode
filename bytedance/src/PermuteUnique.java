import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 47. 全排列 II
 * https://leetcode.cn/problems/permutations-ii/
 */
public class PermuteUnique {
    public static void main(String[] args) {
        int[] nums = {3,3,0,3};
        PermuteUnique solution = new PermuteUnique();
        List<List<Integer>> ans = solution.permuteUnique(nums);
        System.out.println(ans);
    }

    boolean[] isVisited;
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        isVisited = new boolean[nums.length];
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(nums);
        backTrack(nums, 0, temp, ans);
        return ans;
    }

    public void backTrack(int[] nums, int count, List<Integer> temp, List<List<Integer>> ans) {
        if (count == nums.length) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (isVisited[i] || (i > 0 && nums[i] == nums[i - 1] && !isVisited[i - 1])) {
                continue;
            }
            temp.add(nums[i]);
            isVisited[i] = true;
            backTrack(nums, count + 1, temp, ans);
            isVisited[i] = false;
            temp.remove(count);
        }
    }
}
