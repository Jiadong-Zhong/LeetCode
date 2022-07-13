package sword_to_offer;

import com.sun.jdi.ThreadReference;
import sword_to_offer.util.TreeNode;

/**
 * 剑指 Offer 68 - I. 二叉搜索树的最近公共祖先
 * https://leetcode.cn/problems/er-cha-sou-suo-shu-de-zui-jin-gong-gong-zu-xian-lcof/
 */
public class Offer68_lowestCommonAncestor {
    public static void main(String[] args) {
        Integer[] nums = {6,2,8,0,4,7,9,null,null,3,5};
        TreeNode root = TreeNode.arrayToTreeNode(nums);
        TreeNode p = root.left;
        TreeNode q = root.right;

        Offer68_lowestCommonAncestor solution = new Offer68_lowestCommonAncestor();
        TreeNode ans = solution.lowestCommonAncestor1(root, p, q);
        System.out.println(ans);
    }

    // 自己写的递归
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val == root.val || q.val == root.val) {
            return root;
        }
        if (p.val < root.val && q.val > root.val || p.val > root.val && q.val < root.val) {
            return root;
        }
        if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor1(root.right, p, q);
        }
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor1(root.left, p, q);
        }
        return null;
    }

    // 迭代
    public TreeNode lowestCommonAncestor2(TreeNode root , TreeNode p, TreeNode q) {
        if (p.val > q.val) {
            return lowestCommonAncestor2(root, q, p);
        }
        while (root != null) {
            if (root.val < p.val) {
                root = root.right;
            } else if (root.val > q.val) {
                root = root.left;
            } else {
                break;
            }
        }
        return root;
    }

    // 递归
    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor3(root.right, p, q);
        }
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor3(root.left, p, q);
        }
        return root;
    }
}
