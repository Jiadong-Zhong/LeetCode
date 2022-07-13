import util.TreeNode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 剑指 Offer 07. 重建二叉树
 * https://leetcode.cn/problems/zhong-jian-er-cha-shu-lcof/
 */
public class BuildTree {
    public static void main(String[] args) {
        int[] preorder = {3,9,8,5,4,10,20,15,7};
        int[] inorder = {4,5,8,10,9,3,15,20,7};
        BuildTree solution = new BuildTree();
        TreeNode root = solution.buildTree2(preorder, inorder);

    }

    public TreeNode buildTree1(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        int rootIndex = 0;
        while (preorder[0] != inorder[rootIndex]) {
            rootIndex++;
        }
        root.left = buildTree1(Arrays.copyOfRange(preorder, 1, 1 + rootIndex), Arrays.copyOfRange(inorder, 0, rootIndex));
        root.right = buildTree1(Arrays.copyOfRange(preorder, 1+rootIndex, preorder.length), Arrays.copyOfRange(inorder, 1+ rootIndex, inorder.length));
        return root;
    }

    // 迭代
    // 因为在preorder中一直向左子树递归的节点的值的顺序
    // 与inorder中的顺序是倒序
    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode root = new TreeNode(preorder[0]);
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
