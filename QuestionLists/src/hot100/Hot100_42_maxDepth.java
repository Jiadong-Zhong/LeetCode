package hot100;

import hot100.util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 104. 二叉树的最大深度
 * https://leetcode.cn/problems/maximum-depth-of-binary-tree/
 */
public class Hot100_42_maxDepth {
    public static void main(String[] args) {
        Integer[] nums = {3,9,20,null,null,15,7};
        TreeNode root = TreeNode.arrayToTreeNode(nums);
        Hot100_42_maxDepth solution = new Hot100_42_maxDepth();
        int ans = solution.maxDepth1(root);
        System.out.println(ans);
    }

    // 自己写的，效率最高
    public int maxDepth1(TreeNode root) {
        return calDepth(root, 0);
    }

    public int calDepth(TreeNode node, int currDepth) {
        if (node == null) {
            return currDepth;
        }
        if (node.left == null && node.right == null) {
            return currDepth + 1;
        }
        int leftDepth = calDepth(node.left, currDepth + 1);
        int rightDepth = calDepth(node.right,currDepth + 1);
        return Math.max(leftDepth, rightDepth);
    }

    // DFS
    public int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int leftHeight = maxDepth2(root.left);
            int rightHeight = maxDepth2(root.right);
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    // BFS
    public int maxDepth3(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int ans = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                size--;
            }
            ans++;
        }
        return ans;
    }
}
