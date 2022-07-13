import utils.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 1022. 从根到叶的二进制数之和
 * https://leetcode.cn/problems/sum-of-root-to-leaf-binary-numbers/
 */
public class SumRootToLeaf {
    public static void main(String[] args) {
        Integer[] nums = {1,0,1,0,1,0,1};
        TreeNode root = TreeNode.arrayToTreeNode(nums);
        SumRootToLeaf solution = new SumRootToLeaf();
        int ans = solution.sumRootToLeaf1(root);
        System.out.println(ans);
    }

    // 递归
    public int sumRootToLeaf1(TreeNode root) {
        return dfs(root, 0);
    }

    public int dfs(TreeNode root, int val) {
        if (root == null) {
            return 0;
        }
        val = (val << 1) | root.val;
        if (root.left == null && root.right == null) {
            return val;
        }
        return dfs(root.left, val) + dfs(root.right, val);
    }

    // 迭代
    public int sumRootToLeaf2(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        int val = 0, ans = 0;
        TreeNode prev = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                val = (val << 1) | root.val;
                stack.push(root);
                root = root.left;
            }
            root = stack.peek();
            if (root.right == null || root.right == prev) {
                if (root.left == null && root.right == null) {
                    ans += val;
                }
                val >>= 1;
                stack.pop();
                prev = root;
                root = null;
            } else {
                root = root.right;
            }
        }
        return ans;
    }
}
