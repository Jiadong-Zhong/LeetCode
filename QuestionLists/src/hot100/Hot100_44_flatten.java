package hot100;

import hot100.util.TreeNode;

import java.util.*;

/**
 * 114. 二叉树展开为链表
 * https://leetcode.cn/problems/flatten-binary-tree-to-linked-list/
 */
public class Hot100_44_flatten {
    public static void main(String[] args) {
        Integer[] nums = {1,2,5,3,4,null,6};
        TreeNode root = TreeNode.arrayToTreeNode(nums);
        Hot100_44_flatten solution = new Hot100_44_flatten();
        solution.flatten3(root);

    }

    // 递归
    public void flatten1(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        preorderTraversal(root, list);
        int size = list.size();
        for (int i = 1; i < size; i++) {
            TreeNode prev = list.get(i - 1), curr = list.get(i);
            prev.left = null;
            prev.right = curr;
        }
    }

    public void preorderTraversal(TreeNode root, List<TreeNode> list) {
        if (root != null) {
            list.add(root);
            preorderTraversal(root.left, list);
            preorderTraversal(root.right, list);
        }
    }

    // 迭代
    public void flatten2(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                list.add(node);
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            node = node.right;
        }
        int size = list.size();
        for (int i = 1; i < size; i++) {
            TreeNode prev = list.get(i - 1), curr = list.get(i);
            prev.left = null;
            prev.right = curr;
        }
    }

    // 前序遍历和展开同步进行，在遍历时先存储左右子节点信息，先存储右子节点再存储左子节点，即可保证是前序
    public void flatten3(TreeNode root) {
        if (root == null) {
            return;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        TreeNode prev = null;
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            if (prev != null) {
                prev.left = null;
                prev.right = curr;
            }
            TreeNode left = curr.left, right = curr.right;
            if (right != null) {
                stack.push(right);
            }
            if (left != null) {
                stack.push(left);
            }
            prev = curr;
        }
    }

    // 寻找前驱节点，左子树最右下的节点，就是右子树的前驱结点，即flatten之后的右子树的父节点
    public void flatten4(TreeNode root) {
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left != null) {
                TreeNode next = curr.left;
                TreeNode predecessor = next;
                while (predecessor.right != null) {
                    predecessor = predecessor.right;
                }
                predecessor.right = curr.right;
                curr.left = null;
                curr.right = next;
            }
            curr = curr.right;
        }
    }
}
