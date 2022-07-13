package sword_to_offer;

import sword_to_offer.util.TreeNode;

/**
 * 剑指 Offer 55 - I. 二叉树的深度
 * https://leetcode.cn/problems/er-cha-shu-de-shen-du-lcof/
 */
public class Offer55_maxDepth {
    public static void main(String[] args) {
        Integer[] nums = {3,9,20,null,null,15,7};
        TreeNode root = TreeNode.arrayToTreeNode(nums);
        Offer55_maxDepth solution = new Offer55_maxDepth();
        int ans = solution.maxDepth(root);
        System.out.println(ans);
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
