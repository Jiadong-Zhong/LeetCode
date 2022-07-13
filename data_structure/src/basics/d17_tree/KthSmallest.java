package basics.d17_tree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 230. 二叉搜索树中第K小的元素
 * https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst/
 */
public class KthSmallest {
    public static void main(String[] args) {
        Integer[] nums = {3,1,4,null,2};
        int k = 1;
        TreeNode root = TreeNode.arrayToTreeNode(nums);
        int res = kthSmallest1(root, k);
        System.out.println(res);
    }

    public static int kthSmallest1(TreeNode root, int k) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            k--;
            if (k == 0) {
                break;
            }
            root = root.right;
        }
        return root.val;
    }
}
