package introduction.d14_tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 235. 二叉搜索树的最近公共祖先
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 */
public class LowestCommonAncestor {
    public static void main(String[] args) {
        Integer[] nums = {6,2,8,0,4,7,9,null,null,3,5};
        TreeNode root = TreeNode.arrayToTreeNode(nums);
        TreeNode p = new TreeNode(2);
        TreeNode q = new TreeNode(4);

        TreeNode res = lowestCommonAncestor2(root, p, q);
        System.out.println(res.val);
    }

    public static TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> path_p = getPath(root, p);
        List<TreeNode> path_q = getPath(root, q);
        TreeNode ancestor = null;
        for (int i = 0; i < path_p.size() && i < path_q.size(); i++) {
            if (path_p.get(i).val == path_q.get(i).val) {
                ancestor = path_p.get(i);
            } else {
                break;
            }
        }
        return ancestor;
    }

    public static List<TreeNode> getPath(TreeNode root, TreeNode target) {
        List<TreeNode> path = new ArrayList<>();
        TreeNode cur = root;
        while (cur.val != target.val) {
            path.add(cur);
            if (target.val < cur.val) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
        path.add(cur);
        return path;
    }

    public static TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ancestor = root;
        while (true) {
            if (ancestor.val > p.val && ancestor.val > q.val) {
                ancestor = ancestor.left;
            } else if (ancestor.val < p.val && ancestor.val < q.val) {
                ancestor = ancestor.right;
            } else {
                break;
            }
        }
        return ancestor;
    }
}
