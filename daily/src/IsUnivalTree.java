import utils.TreeNode;

import java.util.Stack;

/**
 * 965. 单值二叉树
 * https://leetcode.cn/problems/univalued-binary-tree/
 */
public class IsUnivalTree {
    public static void main(String[] args) {
        Integer[] nums = {2,2,2,5,2};
        TreeNode root = TreeNode.arrayToTreeNode(nums);
        IsUnivalTree solution = new IsUnivalTree();
        boolean ans = solution.isUnivalTree1(root);
        System.out.println(ans);
    }

    public boolean isUnivalTree1(TreeNode root) {
        int val = root.val;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            if (cur.val != val) {
                return false;
            } else {
                if (cur.left != null) {
                    stack.push(cur.left);
                }
                if (cur.right != null) {
                    stack.push(cur.right);
                }
            }
        }
        return true;
    }

    public boolean isUnivalTree2(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left != null) {
            if (root.val != root.left.val || !isUnivalTree2(root.left)) {
                return false;
            }
        }
        if (root.right != null) {
            if (root.val != root.right.val || !isUnivalTree2(root.right)) {
                return false;
            }
        }
        return true;
    }
}
