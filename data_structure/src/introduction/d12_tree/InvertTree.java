package introduction.d12_tree;

import java.util.List;

/**
 * 226. 翻转二叉树
 * https://leetcode-cn.com/problems/invert-binary-tree/
 */
public class InvertTree {
    public static void main(String[] args) {
        Integer[] nums = {4,2,7,1,3,6,9};
        TreeNode root = TreeNode.arrayToTreeNode(nums);
        TreeNode newRoot = invertTree1(root);
        List<List<Integer>> res = TreeNode.levelOrder(newRoot);
        System.out.println(res);
    }

    public static TreeNode invertTree1(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode left = invertTree1(root.left);
        TreeNode right = invertTree1(root.right);
        root.right = left;
        root.left = right;
        return root;
    }
}
