package hot100;

import hot100.util.TreeNode;

/**
 * 124. 二叉树中的最大路径和
 * https://leetcode.cn/problems/binary-tree-maximum-path-sum/
 */
public class Hot100_46_maxPathSum {
    public static void main(String[] args) {
        Integer[] nums = {-10,9,20,null,null,15,7};
        TreeNode root = TreeNode.arrayToTreeNode(nums);
        Hot100_46_maxPathSum solution = new Hot100_46_maxPathSum();
        int ans = solution.maxPathSum(root);
        System.out.println(ans);
    }

    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

    public int maxGain(TreeNode node) {
        if (node == null) {
            return 0;
        }

        // 递归计算左右节点的最大贡献值
        // 只有最大贡献大于0时，才会选取对应子节点
        int leftGain = Math.max(maxGain(node.left), 0);
        int rightGain = Math.max(maxGain(node.right), 0);

        // 节点的最大路径和取决于该节点的值和左右子节点的最大贡献值
        int priceNewPath = node.val + leftGain + rightGain;

        // 更新答案
        maxSum = Math.max(maxSum, priceNewPath);

        // 返回节点的最大贡献值
        return node.val + Math.max(leftGain, rightGain);
    }
}
