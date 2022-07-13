package introduction.d12_tree;

import java.util.ArrayDeque;
import java.util.Queue;

public class HasPathSum {
    public static void main(String[] args) {
        Integer[] nums = {5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1};
        int targetSum = 22;
        TreeNode root = TreeNode.arrayToTreeNode(nums);
        boolean res = hasPathSum2(root, targetSum);
        System.out.println(res);
    }

    public static boolean hasPathSum1(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }
        return hasPathSum1(root.left, targetSum - root.val) || hasPathSum1(root.right, targetSum - root.val);
    }

    public static boolean hasPathSum2(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        Queue<TreeNode> queNode = new ArrayDeque<>();
        Queue<Integer> queVal = new ArrayDeque<>();
        queNode.offer(root);
        queVal.offer(root.val);
        while (!queNode.isEmpty()) {
            TreeNode curNode = queNode.poll();
            int curVal = queVal.poll();
            if (curNode.left == null && curNode.right == null) {
                if (curVal == targetSum) {
                    return true;
                }
                continue;
            }
            if (curNode.left != null) {
                queNode.offer(curNode.left);
                queVal.offer(curVal + curNode.left.val);
            }
            if (curNode.right != null) {
                queNode.offer(curNode.right);
                queVal.offer(curVal + curNode.right.val);
            }
        }
        return false;
    }
}
