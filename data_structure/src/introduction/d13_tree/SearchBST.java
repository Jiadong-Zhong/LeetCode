package introduction.d13_tree;

import java.util.List;

/**
 * 700. 二叉搜索树中的搜索
 * https://leetcode-cn.com/problems/search-in-a-binary-search-tree/
 */
public class SearchBST {
    public static void main(String[] args) {
        Integer[] nums = {18,2,22,null,null,null,63,null,84,null,null};
        int val = 63;
        TreeNode root = TreeNode.arrayToTreeNode(nums);
        TreeNode resRoot = searchBST2(root, val);
        List<List<Integer>> res = TreeNode.levelOrder(resRoot);
        System.out.println(res);

    }

    public static TreeNode searchBST1(TreeNode root, int val) {
        if (root == null) {
            return null;
        }

        if (root.val == val) {
            return root;
        }
        return searchBST1(val < root.val ? root.left : root.right, val);
    }

    public static TreeNode searchBST2(TreeNode root, int val) {
        while (root != null) {
            if (val == root.val){
                return root;
            }
            root = val < root.val ? root.left : root.right;
        }
        return null;
    }
}
