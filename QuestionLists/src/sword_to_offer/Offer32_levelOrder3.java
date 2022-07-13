package sword_to_offer;

import hot100.util.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 剑指 Offer 32 - III. 从上到下打印二叉树 III
 * https://leetcode.cn/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof/
 */
public class Offer32_levelOrder3 {
    public static void main(String[] args) {
        Integer[] nums = {3, 9, 20, null, null, 15, 7};
        TreeNode root = TreeNode.arrayToTreeNode(nums);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        boolean flag = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> curr = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (flag) {
                    curr.add(node.val);
                } else {
                    curr.add(0, node.val);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            ans.add(curr);
            flag = !flag;
        }
        return ans;
    }

}
