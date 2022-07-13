package utils;

import java.util.*;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode arrayToTreeNode(Integer[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        // 数组的开始下标
        TreeNode root = new TreeNode(nums[0]);
        Deque<TreeNode> deque = new LinkedList<>();
        deque.addFirst(root);

        boolean isLeft = true;
        for (int i = 1; i < nums.length; i++) {
            TreeNode node = deque.getLast();
            if (isLeft) {
                if (nums[i] != null) {
                    node.left = new TreeNode(nums[i]);
                    deque.addFirst(node.left);
                }
                isLeft = false;
            } else {
                if (nums[i] != null) {
                    node.right = new TreeNode(nums[i]);
                    deque.addFirst(node.right);
                }
                deque.removeLast();
                isLeft = true;
            }
        }
        return root;
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            res.add(cur.val);
            cur = cur.right;
        }
        return res;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                '}';
    }
}
