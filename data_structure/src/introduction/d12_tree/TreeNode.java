package introduction.d12_tree;

import java.util.*;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

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

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> curList = new ArrayList<>();
            int curSize = queue.size();
            for (int i = 0; i < curSize; i++) {
                TreeNode curNode = queue.poll();
                curList.add(curNode.val);
                if (curNode.left != null) {
                    queue.offer(curNode.left);
                }
                if (curNode.right != null) {
                    queue.offer(curNode.right);
                }
            }
            res.add(curList);
        }
        return res;
    }
}
