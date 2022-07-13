package sword_to_offer;

import hot100.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer 34. 二叉树中和为某一值的路径
 * https://leetcode.cn/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof/
 */
public class Offer34_pathSum {
    public static void main(String[] args) {
        Integer[] nums = {5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1};
        int target = 22;
        TreeNode root = TreeNode.arrayToTreeNode(nums);
        Offer34_pathSum solution = new Offer34_pathSum();
        List<List<Integer>> ans = solution.pathSum(root, target);
        System.out.println(ans);
    }

    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        backtrack(root, target);
        return ans;
    }

    public void backtrack(TreeNode node, int target) {
        if (node == null) {
            return;
        }
        temp.add(node.val);
        target -= node.val;
        if (node.left == null && node.right == null && target == 0) {
            ans.add(new ArrayList<>(temp));
        }
        backtrack(node.left, target);
        backtrack(node.right, target);
        temp.remove(temp.size() - 1);
    }
}
