package sword_to_offer;

import hot100.util.TreeNode;

import java.util.List;

/**
 * 剑指 Offer 27. 二叉树的镜像
 * https://leetcode.cn/problems/er-cha-shu-de-jing-xiang-lcof/
 */
public class Offer27_mirrorTree {
    public static void main(String[] args) {
        Integer[] nums = {4,2,7,1,3,6,9};
        TreeNode root = TreeNode.arrayToTreeNode(nums);

        Offer27_mirrorTree solution = new Offer27_mirrorTree();
        TreeNode ans = solution.mirrorTree(root);
        List<List<Integer>> list = TreeNode.levelOrder(ans);
        System.out.println(list);
    }

    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = mirrorTree(root.left);
        TreeNode right = mirrorTree(root.right);

        root.left = right;
        root.right = left;
        return root;
    }
}
