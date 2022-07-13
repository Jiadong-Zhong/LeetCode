package sword_to_offer;

import sword_to_offer.util.TreeNode;

/**
 * 剑指 Offer 55 - II. 平衡二叉树
 * https://leetcode.cn/problems/ping-heng-er-cha-shu-lcof/
 */
public class Offer55_isBalanced {
    public static void main(String[] args) {
        Integer[] nums = {3,9,20,null,null,15,7};
        TreeNode root = TreeNode.arrayToTreeNode(nums);
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        } else {
            return Math.abs(depth(root.left) - depth(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
        }

    }

    public int   depth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return Math.max(depth(root.left), depth(root.right)) + 1;
        }
    }
}
