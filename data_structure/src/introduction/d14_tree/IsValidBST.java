package introduction.d14_tree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 98. 验证二叉搜索树
 * https://leetcode-cn.com/problems/validate-binary-search-tree/
 */
public class IsValidBST {
    public static void main(String[] args) {
        Integer[] nums = {2, 1, 3};
        Integer[] nums1 = {5, 1, 4, null, null, 3, 6};
        Integer[] nums2 = {5, 4, 6, null, null, 3, 7};

        TreeNode root = TreeNode.arrayToTreeNode(nums);
        TreeNode root1 = TreeNode.arrayToTreeNode(nums1);
        TreeNode root2 = TreeNode.arrayToTreeNode(nums2);

        boolean res = isValidBST2(root);
        boolean res1 = isValidBST2(root1);
        boolean res2 = isValidBST2(root2);

        System.out.println(res);
        System.out.println(res1);
        System.out.println(res2);

    }

    public static boolean isValidBST1(TreeNode root) {
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public static boolean helper(TreeNode root, long left, long right) {
        if (root == null) {
            return true;
        }

        if (root.val <= left || root.val >= right) {
            return false;
        }

        return helper(root.left, left, root.val) && helper(root.right, root.val, right);
    }

    public static boolean isValidBST2(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        long preVal = Long.MIN_VALUE;

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.val <= preVal) {
                return false;
            }
            preVal = root.val;
            root = root.right;
        }
        return true;
    }
}
