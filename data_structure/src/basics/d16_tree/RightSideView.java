package basics.d16_tree;

import java.util.*;

/**
 * 199. 二叉树的右视图
 * https://leetcode-cn.com/problems/binary-tree-right-side-view/
 */
public class RightSideView {
    public static void main(String[] args) {
        Integer[] nums = {1, 2, 3, null, 5, null, 4};
        TreeNode root = TreeNode.arrayToTreeNode(nums);
        List<Integer> res = rightSideView1(root);
        System.out.println(res);

    }

    public static List<Integer> rightSideView1(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Map<Integer, Integer> rightMostValueAtDepth = new HashMap<>();
        int max_depth = -1;

        Deque<TreeNode> nodeStack = new ArrayDeque<>();
        Deque<Integer> depthStack = new ArrayDeque<>();
        nodeStack.push(root);
        depthStack.push(0);

        while (!nodeStack.isEmpty()) {
            TreeNode node = nodeStack.pop();
            int depth = depthStack.pop();

            if (node != null) {
                max_depth = Math.max(max_depth, depth);

                if (!rightMostValueAtDepth.containsKey(depth)) {
                    rightMostValueAtDepth.put(depth, node.val);
                }

                if (node.left != null) {
                    nodeStack.push(node.left);
                    depthStack.push(depth + 1);
                }
                if (node.right != null) {
                    nodeStack.push(node.right);
                    depthStack.push(depth + 1);
                }
            }
        }

        List<Integer> rightView = new ArrayList<>();
        for (int depth = 0; depth <= max_depth; depth++) {
            rightView.add(rightMostValueAtDepth.get(depth));
        }

        return rightView;
    }

    public static List<Integer> rightSideView2(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        Map<Integer, Integer> rightmostValueAtDepth = new HashMap<>();
        int max_depth = -1;

        Queue<TreeNode> nodeQueue = new ArrayDeque<>();
        Queue<Integer> depthQueue = new ArrayDeque<>();
        nodeQueue.add(root);
        depthQueue.add(0);

        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();
            int depth = depthQueue.remove();

            if (node != null) {
                // 维护二叉树的最大深度
                max_depth = Math.max(max_depth, depth);

                // 由于每一层最后一个访问到的节点才是我们要的答案，因此不断更新对应深度的信息即可
                rightmostValueAtDepth.put(depth, node.val);

                if (node.left != null) {
                    nodeQueue.add(node.left);
                    depthQueue.add(depth + 1);
                }

                if (node.right != null) {
                    nodeQueue.add(node.right);
                    depthQueue.add(depth + 1);
                }
            }
        }

        List<Integer> rightView = new ArrayList<Integer>();
        for (int depth = 0; depth <= max_depth; depth++) {
            rightView.add(rightmostValueAtDepth.get(depth));
        }

        return rightView;
    }

    public static List<Integer> rightSideView3(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                if (i == size - 1) {  //将当前层的最后一个节点放入结果列表
                    res.add(node.val);
                }
            }
        }
        return res;
    }

    static List<Integer> res = new ArrayList<>();

    public static List<Integer> rightSideView4(TreeNode root) {
        dfs(root, 0); // 从根节点开始访问，根节点深度是0
        return res;
    }

    private static void dfs(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        // 先访问 当前节点，再递归地访问 右子树 和 左子树。
        if (depth == res.size()) {   // 如果当前节点所在深度还没有出现在res里，说明在该深度下当前节点是第一个被访问的节点，因此将当前节点加入res中。
            res.add(root.val);
        }
        depth++;
        dfs(root.right, depth);
        dfs(root.left, depth);
    }
}
