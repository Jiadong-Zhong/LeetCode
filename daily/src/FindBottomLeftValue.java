import utils.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * 513. 找树左下角的值
 * https://leetcode.cn/problems/find-bottom-left-tree-value/
 */
public class FindBottomLeftValue {
    public static void main(String[] args) {
        Integer[] nums = {1,2,3,4,null,5,6,null,null,7};
        TreeNode root = TreeNode.arrayToTreeNode(nums);
        FindBottomLeftValue solution = new FindBottomLeftValue();
        int ans = solution.findBottomLeftValue3(root);
        System.out.println(ans);
    }

    public int findBottomLeftValue1(TreeNode root) {
        Deque<TreeNode> nodeStack = new ArrayDeque<>();
        Deque<Integer> depthStack = new ArrayDeque<>();
        Map<Integer, Integer> leftMost = new HashMap<>();

        int maxDepth = -1;
        nodeStack.push(root);
        depthStack.push(1);

        while (!nodeStack.isEmpty()) {
            TreeNode node = nodeStack.pop();
            Integer depth = depthStack.pop();
            if (node != null) {
                maxDepth = Math.max(depth, maxDepth);

                if (!leftMost.containsKey(depth)) {
                    leftMost.put(depth, node.val);
                }

                if (node.right != null) {
                    nodeStack.push(node.right);
                    depthStack.push(depth + 1);
                }
                if (node.left != null) {
                    nodeStack.push(node.left);
                    depthStack.push(depth + 1);
                }
            }
        }
        return leftMost.get(maxDepth);
    }

    // 深度优先
    int curVal = 0;
    int curHeight = 0;
    public int findBottomLeftValue2(TreeNode root) {
        dfs(root, 0);
        return curVal;
    }

    public void dfs(TreeNode root, int height) {
        if (root == null) {
            return;
        }
        height++;
        dfs(root.left, height);
        dfs(root.right, height);
        if (height > curHeight) {
            curHeight = height;
            curVal = root.val;
        }
    }


    // 广度优先
    public int findBottomLeftValue3(TreeNode root) {
        int ans = 0;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.right != null) {
                queue.offer(node.right);
            }
            if (node.left != null) {
                queue.offer(node.left);
            }
            ans = node.val;
        }
        return ans;
    }
}
