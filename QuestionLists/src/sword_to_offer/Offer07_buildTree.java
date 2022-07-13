package sword_to_offer;

import hot100.util.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

/**
 * 剑指 Offer 07. 重建二叉树
 * https://leetcode.cn/problems/zhong-jian-er-cha-shu-lcof/
 */
public class Offer07_buildTree {
    public static void main(String[] args) {
        int[] preorder = {3, 9, 8, 5, 4, 10, 20, 15, 7};
        int[] inorder = {4, 5, 8, 10, 9, 3, 15, 20, 7};
        Offer07_buildTree solution = new Offer07_buildTree();
        TreeNode ans = solution.buildTree(preorder, inorder);
        List<List<Integer>> list = TreeNode.levelOrder(ans);
        System.out.println(list);
    }

    // 迭代
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        int inorderIndex = 0;
        for (int i = 1; i < preorder.length; i++) {
            int preorderVal = preorder[i];
            TreeNode node = stack.peek();
            if (node.val != inorder[inorderIndex]) {
                node.left = new TreeNode(preorderVal);
                stack.push(node.left);
            } else {
                while (!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]) {
                    node = stack.pop();
                    inorderIndex++;
                }
                node.right = new TreeNode(preorderVal);
                stack.push(node.right);
            }
        }
        return root;
    }
}
