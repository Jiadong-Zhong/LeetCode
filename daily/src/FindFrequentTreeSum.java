import utils.TreeNode;

import java.util.*;

/**
 * 508. 出现次数最多的子树元素和
 * https://leetcode.cn/problems/most-frequent-subtree-sum/
 */
public class FindFrequentTreeSum {
    public static void main(String[] args) {
        Integer[] nums = {5,2,-5};
        TreeNode root = TreeNode.arrayToTreeNode(nums);
    }

    Map<Integer, Integer> count = new HashMap<>();
    int maxCount = 0;
    public int[] findFrequentTreeSum(TreeNode root) {
        dfs(root);
        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            int s = entry.getKey(), c = entry.getValue();
            if (c == maxCount) {
                list.add(s);
            }
        }
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }

    public int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int sum = node.val + dfs(node.left) + dfs(node.right);
        count.put(sum, count.getOrDefault(sum, 0) + 1);
        maxCount = Math.max(maxCount, count.get(sum));
        return sum;
    }
}
