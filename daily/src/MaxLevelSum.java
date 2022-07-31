import utils.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 1161. 最大层内元素和
 * https://leetcode.cn/problems/maximum-level-sum-of-a-binary-tree/
 */
public class MaxLevelSum {
    public static void main(String[] args) {
        Integer[] nums = {1,7,0,7,-8,null,null};
        TreeNode root = TreeNode.arrayToTreeNode(nums);
        MaxLevelSum solution = new MaxLevelSum();
        int ans = solution.maxLevelSum(root);
        System.out.println(ans);
    }

    public int maxLevelSum(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int level = 0;
        int maxValue = Integer.MIN_VALUE;
        int maxLevel = 0;

        while (!queue.isEmpty()) {
            int sum = 0;
            int size = queue.size();
            level++;
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                sum += curr.val;
                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                }
            }
            if (sum > maxValue) {
                maxValue = sum;
                maxLevel = level;
            }
        }
        return maxLevel;
    }
}
