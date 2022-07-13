package basics.d18_tree;

import java.util.*;

/**
 * 236. 二叉树的最近公共祖先
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 */
public class LowestCommonAncestor {
    public static void main(String[] args) {
        Integer[] nums = {3, 5, 1, 6, 2, 0, 8, null, null, 7, 4};
        TreeNode p = new TreeNode(5);
        TreeNode q = new TreeNode(1);
        TreeNode root = TreeNode.arrayToTreeNode(nums);
    }

    private static TreeNode ans = null;

    public static TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return ans;
    }

    private static boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return false;
        boolean lson = dfs(root.left, p, q);
        boolean rson = dfs(root.right, p, q);
        if ((lson && rson) || (root.val == p.val || root.val == q.val) && (lson || rson)) {
            ans = root;
        }
        return lson || rson || (root.val == p.val || root.val == q.val);
    }


    static Map<Integer, TreeNode> parent = new HashMap<>();
    static Set<Integer> visited = new HashSet<>();

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root);
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

    public void dfs(TreeNode root) {
        if (root.left != null) {
            parent.put(root.left.val, root);
            dfs(root.left);
        }
        if (root.right != null) {
            parent.put(root.right.val, root);
            dfs(root.right);
        }
    }
}
