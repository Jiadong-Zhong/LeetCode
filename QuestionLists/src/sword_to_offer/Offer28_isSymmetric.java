package sword_to_offer;

import hot100.util.TreeNode;

/**
 * 剑指 Offer 28. 对称的二叉树
 * https://leetcode.cn/problems/dui-cheng-de-er-cha-shu-lcof/
 */
public class Offer28_isSymmetric {
    public static void main(String[] args) {
        Integer[] nums = {1,2,2,3,4,4,3};
        TreeNode root = TreeNode.arrayToTreeNode(nums);

    }

    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    private boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
    }
}
