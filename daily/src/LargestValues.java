import utils.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 515. 在每个树行中找最大值
 * https://leetcode.cn/problems/find-largest-value-in-each-tree-row/
 */
public class LargestValues {
    public static void main(String[] args) {
        Integer[] nums = {1,3,2,5,3,null,9};
        TreeNode root = TreeNode.arrayToTreeNode(nums);
        LargestValues solution = new LargestValues();
        List<Integer> ans = solution.largestValues(root);
        System.out.println(ans);
    }

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            int maxVal = Integer.MIN_VALUE;
            for (int i = 0 ; i < size; i++) {
                TreeNode curr = queue.poll();
                maxVal = Math.max(curr.val, maxVal);
                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                }
            }
            ans.add(maxVal);
        }
        return ans;
    }
}
