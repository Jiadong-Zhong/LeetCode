package hot100;

import hot100.util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 101. 对称二叉树
 * https://leetcode.cn/problems/symmetric-tree/
 */
public class Hot100_40_isSymmetric {
    public static void main(String[] args) {
        Integer[] nums = {1,2,2,null,3,null,3};
        TreeNode root = TreeNode.arrayToTreeNode(nums);
    }

    // 递归
    public boolean isSymmetric1(TreeNode root) {
        return check(root, root);
    }

    public boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
    }

    // 迭代
    public boolean isSymmetric2(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode u = root;
        TreeNode v = root;
        q.offer(u);
        q.offer(v);
        while (!q.isEmpty()) {
            u = q.poll();
            v = q.poll();
            if (u == null && v == null) {
                continue;
            }
            if ((u == null || v == null) || (u.val != v.val)) {
                return false;
            }

            q.offer(u.left);
            q.offer(v.right);

            q.offer(u.right);
            q.offer(v.left);
        }
        return true;
    }
}
