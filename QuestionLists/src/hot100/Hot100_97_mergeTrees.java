package hot100;

import hot100.util.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Queue;

/**
 * 617. 合并二叉树
 * https://leetcode.cn/problems/merge-two-binary-trees/
 */
public class Hot100_97_mergeTrees {
    public static void main(String[] args) {
        Integer[] nums1 = {1,3,2,5};
        Integer[] nums2 = {2,1,3,null,4,null,7};
        TreeNode root1 = TreeNode.arrayToTreeNode(nums1);
        TreeNode root2 = TreeNode.arrayToTreeNode(nums2);
        Hot100_97_mergeTrees solution = new Hot100_97_mergeTrees();
        TreeNode ans = solution.mergeTrees3(root1, root2);
        List<List<Integer>> list = TreeNode.levelOrder(ans);
        System.out.println(list);
    }

    // 自己写的
    public TreeNode mergeTrees1(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return null;
        }
        int val1 = root1 == null ? 0 : root1.val;
        int val2 = root2 == null ? 0 : root2.val;
        TreeNode root = new TreeNode();
        root.val = val1 + val2;
        if (root1 != null && root2 != null) {
            root.left = mergeTrees1(root1.left, root2.left);
            root.right = mergeTrees1(root1.right, root2.right);
        } else if (root1 == null) {
            root.left = root2.left;
            root.right = root2.right;
        } else {
            root.left = root1.left;
            root.right = root1.right;
        }
        return root;
    }

    // dfs
    public TreeNode mergeTrees2(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        TreeNode merged = new TreeNode(root1.val + root2.val);
        merged.left = mergeTrees1(root1.left, root2.left);
        merged.right = mergeTrees1(root1.right, root2.right);
        return merged;
    }

    // bfs
    public TreeNode mergeTrees3(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }

        TreeNode merged = new TreeNode(root1.val + root2.val);
        Deque<TreeNode> queue = new ArrayDeque<>();
        Deque<TreeNode> queue1 = new ArrayDeque<>();
        Deque<TreeNode> queue2 = new ArrayDeque<>();
        queue.offer(merged);
        queue1.offer(root1);
        queue2.offer(root2);
        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            TreeNode node = queue.poll(), node1 = queue1.poll(), node2 = queue2.poll();
            TreeNode left1 = node1.left, left2 = node2.left, right1 = node1.right, right2 = node2.right;
            if (left1 != null || left2 != null) {
                if (left1 != null && left2 != null) {
                    TreeNode left = new TreeNode(left1.val + left2.val);
                    node.left = left;
                    queue.offer(left);
                    queue1.offer(left1);
                    queue2.offer(left2);
                } else if (left1 != null) {
                    node.left = left1;
                } else if (left2 != null) {
                    node.left = left2;
                }
            }

            if (right1 != null || right2 != null) {
                if (right1 != null && right2 != null) {
                    TreeNode right = new TreeNode(right1.val + right2.val);
                    node.right = right;
                    queue.offer(right);
                    queue1.offer(right1);
                    queue2.offer(right2);
                } else if (right1 != null) {
                    node.right = right1;
                } else if (right2 != null) {
                    node.right = right2;
                }
            }
        }
        return merged;
    }
}
