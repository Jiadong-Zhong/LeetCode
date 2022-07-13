package basics.d16_tree;

import java.util.List;

/**
 * 450. 删除二叉搜索树中的节点
 * https://leetcode-cn.com/problems/delete-node-in-a-bst/
 */
public class DeleteNode {
    public static void main(String[] args) {
        Integer[] nums = {5,3,6,2,4,null,7};
        int key = 3;
        TreeNode root = TreeNode.arrayToTreeNode(nums);
        TreeNode res = deleteNode1(root, key);
        List<List<Integer>> ans = TreeNode.levelOrder(res);
        System.out.println(ans);

    }

    public static TreeNode deleteNode1(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        if (key > root.val) {
            root.right = deleteNode1(root.right, key);
        } else if (key < root.val) {
            root.left = deleteNode1(root.left, key);
        } else {
            if (root.left == null && root.right == null) {
                root = null;
            } else if (root.right != null) {
                root.val = successor(root);
                root.right = deleteNode1(root.right, root.val);
            } else {
                root.val = predecessor(root);
                root.left = deleteNode1(root.left, root.val);
            }
        }
        return root;
    }

    public static int successor(TreeNode root) {
        root = root.right;
        while (root.left != null) {
            root = root.left;
        }
        return root.val;
    }

    public static int predecessor(TreeNode root) {
        root = root.left;
        while (root.right != null) {
            root = root.right;
        }
        return root.val;
    }
}
