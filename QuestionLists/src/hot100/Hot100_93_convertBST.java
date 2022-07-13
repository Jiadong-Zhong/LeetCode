package hot100;

import hot100.util.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

/**
 * 538. 把二叉搜索树转换为累加树
 * https://leetcode.cn/problems/convert-bst-to-greater-tree/
 */
public class Hot100_93_convertBST {
    public static void main(String[] args) {
        Integer[] nums = {4,1,6,0,2,5,7,null,null,null,3,null,null,null,8};
        TreeNode root = TreeNode.arrayToTreeNode(nums);
        Hot100_93_convertBST solution = new Hot100_93_convertBST();
        TreeNode ans = solution.convertBST3(root);
        List<List<Integer>> list = TreeNode.levelOrder(ans);
        System.out.println(list);
    }

    // 两次中序遍历
    public TreeNode convertBST1(TreeNode root) {
        int sum = 0;
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode curr = root;
        while (!stack.isEmpty() || curr != null) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            sum += curr.val;
            curr = curr.right;
        }

        curr = root;
        while (!stack.isEmpty() || curr != null) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            int temp = curr.val;
            curr.val = sum;
            sum -= temp;
            curr = curr.right;
        }
        return root;
    }

    // 反序中序遍历，递归，最快
    int sum = 0;
    public TreeNode convertBST2(TreeNode root) {
        if (root != null) {
            convertBST2(root.right);
            sum += root.val;
            root.val = sum;
            convertBST2(root.left);
        }
        return root;
    }

    // 反序中序遍历，迭代
    public TreeNode convertBST3(TreeNode root) {
        int sum = 0;
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode curr = root;
        while (!stack.isEmpty() || curr != null) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.right;
            }
            curr = stack.pop();
            sum += curr.val;
            curr.val = sum;
            curr = curr.left;
        }
        return root;
    }
}
