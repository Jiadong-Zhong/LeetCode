package introduction.d11_tree;

/**
 * 104. 二叉树的最大深度
 * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 */
public class MaxDepth {
    public static void main(String[] args) {
        Integer[] nums = {3,9,20,null,null,15,7};
        TreeNode root = TreeNode.arrayToTreeNode(nums);
        int res = maxDepth1(root);
        System.out.println(res);
    }

    public static int maxDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int leftHeight = maxDepth1(root.left);
            int rightHeight = maxDepth1(root.right);
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }
}
