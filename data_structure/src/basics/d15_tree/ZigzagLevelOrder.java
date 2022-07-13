package basics.d15_tree;

import java.util.*;

/**
 * 103. 二叉树的锯齿形层序遍历
 * https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/
 */
public class ZigzagLevelOrder {
    public static void main(String[] args) {
        Integer[] nums = {3,9,20,null,null,15,7};
        TreeNode root = TreeNode.arrayToTreeNode(nums);
        List<List<Integer>> res = zigzagLevelOrder1(root);
        System.out.println(res);
    }

    public static List<List<Integer>> zigzagLevelOrder1(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        boolean isOrderLeft = true;

        while (!queue.isEmpty()) {
            int curSize = queue.size();
            Deque<Integer> curLevel = new LinkedList<>();
            for (int i = 0; i < curSize; i++) {
                TreeNode cur = queue.poll();
                if (isOrderLeft) {
                    curLevel.offerLast(cur.val);
                } else {
                    curLevel.offerFirst(cur.val);
                }

                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            res.add(new LinkedList<>(curLevel));
            isOrderLeft = !isOrderLeft;
        }
        return res;
    }
}
