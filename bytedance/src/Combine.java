import java.util.ArrayList;
import java.util.List;

/**
 * 77. 组合
 * https://leetcode.cn/problems/combinations/
 */
public class Combine {
    public static void main(String[] args) {
        int n = 4;
        int k = 2;
        Combine solution = new Combine();
        List<List<Integer>> ans = solution.combine(n, k);
        System.out.println(ans);
    }

    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        backtrack(n, k, 1);
        return ans;
    }

    public void backtrack(int n, int k, int begin) {
        if (temp.size() == k) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        for (int i = begin; i <= n; i++) {
            temp.add(i);
            backtrack(n, k, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}
