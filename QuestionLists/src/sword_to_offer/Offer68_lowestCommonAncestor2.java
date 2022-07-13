package sword_to_offer;

import sword_to_offer.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer 68 - II. 二叉树的最近公共祖先
 * https://leetcode.cn/problems/er-cha-shu-de-zui-jin-gong-gong-zu-xian-lcof/
 */
public class Offer68_lowestCommonAncestor2 {
    public static void main(String[] args) {
        Integer[] nums = {3,5,1,6,2,0,8,null,null,7,4};
        TreeNode root = TreeNode.arrayToTreeNode(nums);
        TreeNode p = root.left;
        TreeNode q = root.right;
    }

    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if (p == root || q == root) {
            return root;
        }
        if (root != null) {
            TreeNode lNode = lowestCommonAncestor1(root.left, p, q);
            TreeNode rNode = lowestCommonAncestor1(root.right, p, q);
            if (lNode != null && rNode != null) {
                return root;
            } else if (lNode == null) {
                return rNode;
            } else {
                return lNode;
            }
        }
        return null;
    }

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        // 存放根节点到p节点的路径
        List<TreeNode> path1 = new ArrayList<>();
        // 存放根节点到q节点的路径
        List<TreeNode> path2 = new ArrayList<>();
        getPath(root, p, path1);
        getPath(root, q, path2);

        TreeNode result = null;
        int n = Math.min(path1.size(), path2.size());
        for (int i = 0; i < n; i++) {
            if (path1.get(i) == path2.get(i)) {
                result = path1.get(i);
            }
        }
        return result;
    }

    public void getPath(TreeNode root, TreeNode target, List<TreeNode> path) {
        if (root == null) {
            return;
        }
        path.add(root);
        if (root == target) {
            return;
        }
        if (path.get(path.size() - 1) != target) {
            getPath(root.left, target, path);
        }
        if (path.get(path.size() - 1) != target) {
            getPath(root.right, target, path);
        }
        if (path.get(path.size() - 1) != target) {
            path.remove(path.size() - 1);
        }
    }
}
