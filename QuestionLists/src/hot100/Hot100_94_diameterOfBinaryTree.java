package hot100;

import hot100.util.TreeNode;

/**
 * 543. 二叉树的直径
 * https://leetcode.cn/problems/diameter-of-binary-tree/
 * 注意：两结点之间的路径长度是以它们之间边的数目表示。
 */
public class Hot100_94_diameterOfBinaryTree {
    public static void main(String[] args) {
        Integer[] nums = {1,2,3,4,5};
        TreeNode root = TreeNode.arrayToTreeNode(nums);
        Hot100_94_diameterOfBinaryTree solution = new Hot100_94_diameterOfBinaryTree();
        int ans = solution.diameterOfBinaryTree(root);
        System.out.println(ans);
    }

    int maxDiameter = Integer.MIN_VALUE;
    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return maxDiameter - 1;
    }

    public int depth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftDepth = depth(node.left);
        int rightDepth = depth(node.right);
        int diameter = 1 + leftDepth + rightDepth;
        maxDiameter = Math.max(diameter, maxDiameter);
        return 1 + Math.max(leftDepth, rightDepth);
    }
}
