package sword_to_offer;

import hot100.util.TreeNode;

import java.util.*;

/**
 * 剑指 Offer 32 - I. 从上到下打印二叉树
 * https://leetcode.cn/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof/
 */
public class Offer32_levelOrder {
    public static void main(String[] args) {
        Integer[] nums = {3,9,20,null,null,15,7};
        TreeNode root = TreeNode.arrayToTreeNode(nums);
    }

    public int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            list.add(node.val);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }

        int n = list.size();
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }
}
