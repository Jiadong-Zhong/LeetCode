package introduction.d13_tree;

import java.util.List;

/**
 * 701. 二叉搜索树中的插入操作
 * https://leetcode-cn.com/problems/insert-into-a-binary-search-tree/
 */
public class InsertIntoBST {
    public static void main(String[] args) {
        Integer[] nums = {4,2,7,1,3};
        int val = 5;
        TreeNode root = TreeNode.arrayToTreeNode(nums);
        TreeNode newRoot = insertIntoBST1(root, val);
        List<List<Integer>> res = TreeNode.levelOrder(newRoot);
        System.out.println(res);
    }

    public static TreeNode insertIntoBST1(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        TreeNode pos = root;
        while (pos != null) {
            if (val < pos.val) {
                if (pos.left == null) {
                    pos.left = new TreeNode(val);
                    break;
                } else {
                    pos = pos.left;
                }
            } else {
                if (pos.right == null) {
                    pos.right = new TreeNode(val);
                    break;
                } else {
                    pos = pos.right;
                }
            }
        }
        return root;
    }
}
