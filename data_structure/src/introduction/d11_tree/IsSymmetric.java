package introduction.d11_tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 101. 对称二叉树
 * https://leetcode-cn.com/problems/symmetric-tree/
 * 引入队列是把递归转化成迭代的常用方法
 */
public class IsSymmetric {
    public static void main(String[] args) {
        Integer[] nums = {1, 2, 2, 3, 4, 4, 3};
        TreeNode root = TreeNode.arrayToTreeNode(nums);
        boolean res = isSymmetric2(root);
        System.out.println(res);
    }

    public static boolean isSymmetric1(TreeNode root) {
        return check1(root, root);
    }

    public static boolean check1(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q==null) {
            return false;
        }
        return p.val == q.val && check1(p.left, q.right) && check1(p.right, q.left);
    }

    public static boolean isSymmetric2(TreeNode root) {
        return check2(root, root);
    }

    public static boolean check2(TreeNode u, TreeNode v) {
        Queue<TreeNode> q = new LinkedList<>();
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
