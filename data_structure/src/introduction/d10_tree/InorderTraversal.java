package introduction.d10_tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 94. 二叉树的中序遍历
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 */
public class InorderTraversal {
    public static void main(String[] args) {
        Integer[] nums = {1, null, 2, 3};
        TreeNode root = TreeNode.arrayToTreeNode(nums);
        List<Integer> res = inorderTraversal2(root);
        System.out.println(res);
    }

    public static List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder1(root, res);
        return res;
    }

    public static void inorder1(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        inorder1(root.left, res);
        res.add(root.val);
        inorder1(root.right, res);
    }

    public static List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            res.add(cur.val);
            cur = cur.right;
        }
        return res;
    }
}
