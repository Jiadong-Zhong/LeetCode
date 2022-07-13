package hot100;

import hot100.util.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 437. 路径总和 III
 * https://leetcode.cn/problems/path-sum-iii/
 */
public class Hot100_88_pathSum {
    public static void main(String[] args) {
        Integer[] nums = {10,5,-3,3,2,null,11,3,-2,null,1};
        int targetSum = 8;
        TreeNode root = TreeNode.arrayToTreeNode(nums);
        Hot100_88_pathSum solution = new Hot100_88_pathSum();
        int ans = solution.pathSum2(root, targetSum);
        System.out.println(ans);
    }

    // 深度优先搜索
    public int pathSum1(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }

        int res = rootSum(root, targetSum);
        res += pathSum1(root.left, targetSum);
        res += pathSum1(root.right, targetSum);
        return res;
    }

    public int rootSum(TreeNode root, int targetSum) {
        int res = 0;
        if (root == null) {
            return 0;
        }
        int val = root.val;
        if (val == targetSum) {
            res++;
        }
        res += rootSum(root.left, targetSum - val);
        res += rootSum(root.right, targetSum - val);
        return res;
    }

    // 前缀和
    Map<Long, Integer> prefix = new HashMap<>();
    public int pathSum2(TreeNode root, int targetSum) {
        prefix.put(0L, 1); // 前缀和为0的路径个数有1个，满足单节点路径的合法性
        return dfs(root, 0, targetSum);
    }

    public int dfs(TreeNode root, long curr, int targetSum) {
        if (root == null) {
            return 0;
        }

        int res = 0;
        curr += root.val;

        res = prefix.getOrDefault(curr - targetSum, 0); // 以当前节点为结尾满足和为target的路径条数
        prefix.put(curr, prefix.getOrDefault(curr, 0) + 1);
        res += dfs(root.left, curr, targetSum);
        res += dfs(root.right, curr, targetSum);
        prefix.put(curr, prefix.get(curr) - 1);
        return res;
    }
}

