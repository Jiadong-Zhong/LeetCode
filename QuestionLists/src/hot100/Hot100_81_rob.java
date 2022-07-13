package hot100;

import hot100.util.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 337. 打家劫舍 III
 * https://leetcode.cn/problems/house-robber-iii/
 */
public class Hot100_81_rob {
    public static void main(String[] args) {
        Integer[] nums = {2,1,3,null,4};
        TreeNode root = TreeNode.arrayToTreeNode(nums);
        Hot100_81_rob solution = new Hot100_81_rob();
        int ans = solution.rob2(root);
        System.out.println(ans);
    }

    // 自己写的，有问题
    public int rob1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int robed = 0;
        int noRobed = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            int curValue = 0;
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                curValue += cur.val;
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            int newRobed = noRobed + curValue;
            int newNoRobed = Math.max(noRobed, robed);
            robed = newRobed;
            noRobed = newNoRobed;
        }
        return Math.max(robed, noRobed);
    }

    // 动态规划
    public int rob2(TreeNode root) {
        int[] rootStatus = dfs(root);
        return Math.max(rootStatus[0], rootStatus[1]);
    }

    public int[] dfs(TreeNode node) {
        if (node == null) {
            return new int[] {0, 0};
        }
        int[] left = dfs(node.left);
        int[] right = dfs(node.right);
        int selected = node.val + left[1] + right[1];
        int noSelected = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return new int[] {selected, noSelected};
    }
}
