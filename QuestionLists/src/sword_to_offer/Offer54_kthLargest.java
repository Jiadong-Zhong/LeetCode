package sword_to_offer;

import sword_to_offer.util.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 剑指 Offer 54. 二叉搜索树的第k大节点
 * https://leetcode.cn/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/
 */
public class Offer54_kthLargest {
    public static void main(String[] args) {
        Integer[] nums = {3,1,4,null,2};
        int k = 1;
        TreeNode root = TreeNode.arrayToTreeNode(nums);
        Offer54_kthLargest solution = new Offer54_kthLargest();
        int ans = solution.kthLargest(root, k);
        System.out.println(ans);
    }

    public int kthLargest(TreeNode root, int k) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.push(node);
                node = node.right;
            }
            node = stack.pop();
            k--;
            if (k == 0) {
                return node.val;
            }
            node = node.left;
        }
        return -1;
    }
}
