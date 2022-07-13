package introduction.d10_tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 144. 二叉树的前序遍历
 * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 */
public class PreorderTraversal {
    public static void main(String[] args) {
        Integer[] nums = {1, null, 2, 3};
        TreeNode root = TreeNode.arrayToTreeNode(nums);
        List<Integer> res = preorderTraversal2(root);
        System.out.println(res);
    }

    public static List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preorder1(root, res);
        return res;
    }

    public static void preorder1(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        preorder1(root.left, res);
        preorder1(root.right, res);
    }

    public static List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                res.add(cur.val);
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            cur = cur.right;
        }
        return res;
    }
}
