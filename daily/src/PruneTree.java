import utils.TreeNode;

/**
 * 814. 二叉树剪枝
 * https://leetcode.cn/problems/binary-tree-pruning/
 */
public class PruneTree {
    public static void main(String[] args) {
        Integer[] nums = {1, 0, 1, 0, 0, 0, 1};
        TreeNode root = TreeNode.arrayToTreeNode(nums);
        PruneTree solution = new PruneTree();
        solution.pruneTree(root);
    }

    public TreeNode pruneTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);

        if (root.left == null && root.right == null && root.val == 0) {
            return null;
        }
        return root;
    }
}
