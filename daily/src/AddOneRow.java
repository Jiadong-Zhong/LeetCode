import utils.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 623. 在二叉树中增加一行
 * https://leetcode.cn/problems/add-one-row-to-tree/
 */
public class AddOneRow {
    public static void main(String[] args) {
        Integer[] nums = {4,2,6,3,1,5};
        TreeNode root = TreeNode.arrayToTreeNode(nums);
        int val = 1;
        int depth = 1;
        AddOneRow solution = new AddOneRow();
        TreeNode ans = solution.addOneRow(root, val, depth);
        List<Integer> list = TreeNode.inorderTraversal(ans);
        System.out.println(list);
    }

    // 自己写的
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }

        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int curDepth = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            curDepth++;
            if (curDepth == depth) {
                for (int i = 0; i < size; i++) {
                    TreeNode currNode = queue.poll();
                    TreeNode leftNode = new TreeNode(val);
                    leftNode.left = currNode.left == null ? null : currNode.left;
                    TreeNode rightNode = new TreeNode(val);
                    rightNode.right = currNode.right == null ? null : currNode.right;

                    currNode.left = leftNode;
                    currNode.right = rightNode;
                }
                break;
            }
            for (int i = 0; i < size; i++) {
                TreeNode currNode = queue.poll();
                if (currNode.left != null) {
                    queue.offer(currNode.left);
                }
                if (currNode.right != null) {
                    queue.offer(currNode.right);
                }
            }
        }
        return root;
    }

    // dfs
    public TreeNode addOneRow2(TreeNode root, int val, int depth) {
        if (root == null) {
            return null;
        }

        if (depth == 1) {
            return new TreeNode(val, root, null);
        }

        if (depth == 2) {
            root.left = new TreeNode(val, root.left, null);
            root.right = new TreeNode(val, null, root.right);
        } else {
            root.left = addOneRow(root.left, val, depth - 1);
            root.right = addOneRow(root.right, val, depth - 1);
        }
        return root;
    }

    // bfs，和自己写的基本一致
    public TreeNode addOneRow3(TreeNode root, int val, int depth) {
        if (depth == 1) {
            return new TreeNode(val, root, null);
        }
        List<TreeNode> curLevel = new ArrayList<>();
        curLevel.add(root);
        for (int i = 1; i < depth - 1; i++) {
            List<TreeNode> tmpt = new ArrayList<>();
            for (TreeNode node : curLevel) {
                if (node.left != null) {
                    tmpt.add(node.left);
                }
                if (node.right != null) {
                    tmpt.add(node.right);
                }
            }
            curLevel = tmpt;
        }
        for (TreeNode node : curLevel) {
            node.left = new TreeNode(val, node.left, null);
            node.right = new TreeNode(val, null, node.right);
        }
        return root;
    }
}
