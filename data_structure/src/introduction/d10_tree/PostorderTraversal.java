package introduction.d10_tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 145. 二叉树的后序遍历
 * https://leetcode-cn.com/problems/binary-tree-postorder-traversal/
 * Morris遍历未做
 */
public class PostorderTraversal {
    public static void main(String[] args) {
        Integer[] nums = {3, 9, 4, null, null, 5, 7};
        TreeNode root = TreeNode.arrayToTreeNode(nums);
        List<Integer> res = postorderTraversal2(root);
        System.out.println(res);
    }

    public static List<Integer> postorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postorder1(root, res);
        return res;
    }

    public static void postorder1(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        postorder1(root.left, res);
        postorder1(root.right, res);
        res.add(root.val);
    }

    public static List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode prev = null;
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if (cur.right == null || cur.right == prev) {
                res.add(cur.val);
                prev = cur;
                cur = null;
            } else {
                stack.push(cur);
                cur = cur.right;
            }
        }
        return res;
    }
}
