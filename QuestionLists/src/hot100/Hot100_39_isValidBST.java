package hot100;

import hot100.util.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 98. 验证二叉搜索树
 * https://leetcode.cn/problems/validate-binary-search-tree/
 */
public class Hot100_39_isValidBST {
    public static void main(String[] args) {
        Integer[] nums = {5,1,4,null,null,3,6};
        TreeNode root = TreeNode.arrayToTreeNode(nums);

        Hot100_39_isValidBST solution = new Hot100_39_isValidBST();
        boolean ans = solution.isValidBST1(root);
        System.out.println(ans);
    }

    // 递归
    public boolean isValidBST1(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode node, long lower, long upper) {
        if (node == null) {
            return true;
        }
        if (node.val <= lower || node.val >= upper) {
            return false;
        }
        return isValidBST(node.left, lower, node.val) && isValidBST(node.right, node.val, upper);
    }

    // 中序遍历
    public boolean isValidBST2(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        double inorder = Double.MIN_VALUE;

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.val <= inorder) {
                return false;
            }
            inorder = root.val;
            root = root.right;
        }
        return true;
    }
}
