package hot100;

import hot100.util.TreeNode;

import java.util.*;

/**
 * 102. 二叉树的层序遍历
 * https://leetcode.cn/problems/binary-tree-level-order-traversal/
 */
public class Hot100_41_levelOrder {
    public static void main(String[] args) {
        Integer[] nums = {3,9,20,null,null,15,7};
        TreeNode root = TreeNode.arrayToTreeNode(nums);
        Hot100_41_levelOrder solution = new Hot100_41_levelOrder();
        List<List<Integer>> ans = solution.levelOrder(root);
        System.out.println(ans);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> currList = new ArrayList<>();
            int currLevelSize = queue.size();
            for (int i = 1; i <= currLevelSize; i++) {
                TreeNode curr = queue.poll();
                currList.add(curr.val);
                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                }
            }
            ans.add(currList);
        }
        return ans;
    }
}
