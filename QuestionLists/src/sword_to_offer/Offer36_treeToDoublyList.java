package sword_to_offer;

import sword_to_offer.util.TreeNode;

/**
 * 剑指 Offer 36. 二叉搜索树与双向链表
 * https://leetcode.cn/problems/er-cha-sou-suo-shu-yu-shuang-xiang-lian-biao-lcof/
 */
public class Offer36_treeToDoublyList {
    public static void main(String[] args) {
        Integer[] nums = {4,2,5,1,3};

    }

    TreeNode prev, head;
    public TreeNode treeToDoublyList(TreeNode root) {
        if (root == null) {
            return null;
        }
        dfs(root);
        head.left = prev;
        prev.right = head;
        return head;
    }

    public void dfs(TreeNode curr) {
        if (curr == null) {
            return;
        }
        dfs(curr.left);
        if (prev != null) {
            prev.right = curr;
        } else {
            head = curr;
        }
        curr.left = prev;
        prev = curr;
        dfs(curr.right);
    }
}
