import utils.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 面试题 04.06. 后继者
 * https://leetcode.cn/problems/successor-lcci/
 */
public class InorderSuccessor {
    public static void main(String[] args) {
        Integer[] nums = {2,null,3};
        TreeNode root = TreeNode.arrayToTreeNode(nums);
        TreeNode p = root;
        InorderSuccessor solution = new InorderSuccessor();
        TreeNode res = solution.inorderSuccessor1(root, p);
        System.out.println(res);
    }

    public TreeNode inorderSuccessor1(TreeNode root, TreeNode p) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode prev = null;
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if (prev == p) {
                return cur;
            }
            prev = cur;
            cur = cur.right;
        }
        return null;
    }

    public TreeNode inorderSuccessor2(TreeNode root, TreeNode p) {
        TreeNode successor = null;
        if (p.right != null) {
            successor = p.right;
            while (successor.left != null) {
                successor = successor.left;
            }
            return successor;
        }
        TreeNode node = root;
        while (node != null) {
            if (node.val > p.val) {
                successor = node;
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return successor;
    }
}
