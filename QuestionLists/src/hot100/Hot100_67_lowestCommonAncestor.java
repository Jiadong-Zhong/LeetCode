package hot100;

import hot100.util.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 236. 二叉树的最近公共祖先
 * https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/
 */
public class Hot100_67_lowestCommonAncestor {
    public static void main(String[] args) {
        Integer[] nums = {3, 5, 1, 6, 2, 0, 8, null, null, 7, 4};
        TreeNode root = TreeNode.arrayToTreeNode(nums);
        TreeNode p = root.left;
        TreeNode q = root.left.right.right;
        Hot100_67_lowestCommonAncestor solution = new Hot100_67_lowestCommonAncestor();
        TreeNode ans = solution.lowestCommonAncestor3(root, p, q);
        System.out.println(ans);
    }


    // 递归
    private TreeNode ans = null;

    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        dfs1(root, p, q);
        return ans;
    }

    public boolean dfs1(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }
        boolean lson = dfs1(root.left, p, q);
        boolean rson = dfs1(root.right, p, q);
        if ((lson && rson) || (root.val == p.val || root.val == q.val) && (lson || rson)) {
            ans = root;
        }
        return lson || rson || (root.val == p.val || root.val == q.val);
    }

    // 存储父节点
    Map<Integer, TreeNode> parent = new HashMap<>();
    Set<Integer> visited = new HashSet<>();

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        dfs2(root);
        while (p != null) {
            visited.add(p.val);
            p = parent.get(p.val);
        }
        while (q != null) {
            if (visited.contains(q.val)) {
                return q;
            }
            q = parent.get(q.val);
        }
        return null;
    }

    public void dfs2(TreeNode root) {
        if (root.left != null) {
            parent.put(root.left.val, root);
            dfs2(root.left);
        }
        if (root.right != null) {
            parent.put(root.right.val, root);
            dfs2(root.right);
        }
    }

    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode p, TreeNode q) {
        if (root == p || root == q) {
            return root;
        }
        if (root != null) {
            TreeNode lNode = lowestCommonAncestor3(root.left, p, q);
            TreeNode rNode = lowestCommonAncestor3(root.right, p, q);
            if (lNode != null && rNode != null)
                return root;
            else if (lNode == null) {// 两个都在右子树
                return rNode;
            } else { // 两个都在左子树里面
                return lNode;
            }
        }
        return null;
    }
}
