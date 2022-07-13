package hot100;

import hot100.util.TreeNode;

import java.util.List;

/**
 * 226. 翻转二叉树
 * https://leetcode.cn/problems/invert-binary-tree/
 */
public class Hot100_65_invertTree {
    public static void main(String[] args) {
        Integer[] nums = {1,2};
        TreeNode root = TreeNode.arrayToTreeNode(nums);
        Hot100_65_invertTree solution = new Hot100_65_invertTree();
        TreeNode ans = solution.invertTree2(root);
        List<List<Integer>> levelOrder = TreeNode.levelOrder(ans);
        System.out.println(levelOrder);
    }

    // 自己写的，和题解一致，题解更简洁
    public TreeNode invertTree1(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.left != null || root.right != null) {
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
        }
        invertTree1(root.left);
        invertTree1(root.right);
        return root;
    }

    public TreeNode invertTree2(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = invertTree2(root.left);
        TreeNode right = invertTree2(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}
