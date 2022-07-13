package introduction.d11_tree;

import java.util.*;

/**
 * 102. 二叉树的层序遍历
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 */
public class LevelOrder {
    public static void main(String[] args) {
        Integer[] nums = {3, 9, 20, null, null, 15, 7};
        TreeNode root = TreeNode.arrayToTreeNode(nums);
        List<List<Integer>> res = levelOrder1(root);
        System.out.println(res);
    }

    public static List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> curList = new ArrayList<>();
            int curSize = queue.size();
            for (int i = 0; i < curSize; i++) {
                TreeNode curNode = queue.poll();
                curList.add(curNode.val);
                if (curNode.left != null) {
                    queue.offer(curNode.left);
                }
                if (curNode.right != null) {
                    queue.offer(curNode.right);
                }
            }
            res.add(curList);
        }
        return res;
    }
}
