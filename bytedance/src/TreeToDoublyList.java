import util.ListNode;
import util.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 426. 将二叉搜索树转化为排序的双向链表
 * https://leetcode.cn/problems/convert-binary-search-tree-to-sorted-doubly-linked-list/
 */
public class TreeToDoublyList {
    public static void main(String[] args) {
        Integer[] nums = {4,2,5,1,3};
        TreeNode root = TreeNode.arrayToTreeNode(nums);
        TreeToDoublyList solution = new TreeToDoublyList();
        TreeNode ans = solution.treeToDoublyList1(root);


    }

    // 自己写的，先遍历拿出来所有节点，再一个一个连接
    public TreeNode treeToDoublyList1(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode curr = root;
        Deque<TreeNode> stack = new ArrayDeque<>();
        List<TreeNode> inorder = new ArrayList<>();
        while (!stack.isEmpty() || curr != null) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            inorder.add(curr);
            curr = curr.right;
        }

        TreeNode head = inorder.get(0);
        TreeNode prev = head;
        for (int i = 1; i < inorder.size(); i++) {
            curr = inorder.get(i);
            prev.right = curr;
            curr.left = prev;
            prev = curr;
        }
        prev.right = head;
        head.left = prev;

        return head;
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
