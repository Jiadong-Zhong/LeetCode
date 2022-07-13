package basics.d16_tree;

import java.util.*;

/**
 * 113. 路径总和 II
 * https://leetcode-cn.com/problems/path-sum-ii/
 */
public class PathSum {
    public static void main(String[] args) {
        Integer[] nums = {5,4,8,11,null,13,4,7,2,null,null,5,1};
        int targetSum = 22;
        TreeNode root = TreeNode.arrayToTreeNode(nums);
        List<List<Integer>> res = pathSum1(root, targetSum);
        System.out.println(res);
    }

    static List<List<Integer>> ret = new LinkedList<>();
    static Deque<Integer> path = new LinkedList<>();

    public static List<List<Integer>> pathSum1(TreeNode root, int targetSum) {
        dfs(root, targetSum);
        return ret;
    }

    public static void dfs(TreeNode root, int targetSum) {
        if (root == null) {
            return;
        }
        path.offerLast(root.val);
        targetSum -= root.val;
        if (root.left == null && root.right == null && targetSum == 0) {
            ret.add(new LinkedList<>(path));
        }
        dfs(root.left, targetSum);
        dfs(root.right, targetSum);
        path.pollLast();
    }

    static Map<TreeNode, TreeNode> map = new HashMap<TreeNode, TreeNode>();

    public static List<List<Integer>> pathSum2(TreeNode root, int targetSum) {
        if (root == null) {
            return ret;
        }

        Queue<TreeNode> queueNode = new LinkedList<>();
        Queue<Integer> queueSum = new LinkedList<>();
        queueNode.offer(root);
        queueSum.offer(0);

        while (!queueNode.isEmpty()) {
            TreeNode node = queueNode.poll();
            int rec = queueSum.poll() + node.val;

            if (node.left == null && node.right == null) {
                if (rec == targetSum) {
                    getPath(node);
                }
            } else {
                if (node.left != null) {
                    map.put(node.left, node);
                    queueNode.offer(node.left);
                    queueSum.offer(rec);
                }
                if (node.right != null) {
                    map.put(node.right, node);
                    queueNode.offer(node.right);
                    queueSum.offer(rec);
                }
            }
        }

        return ret;
    }

    public static void getPath(TreeNode node) {
        List<Integer> temp = new LinkedList<>();
        while (node != null) {
            temp.add(node.val);
            node = map.get(node);
        }
        Collections.reverse(temp);
        ret.add(new LinkedList<>(temp));
    }
}
