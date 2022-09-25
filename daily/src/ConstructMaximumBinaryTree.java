import utils.TreeNode;

import java.util.Arrays;
import java.util.List;

/**
 * 654. 最大二叉树
 * https://leetcode.cn/problems/maximum-binary-tree/
 */
public class ConstructMaximumBinaryTree {
    public static void main(String[] args) {
        int[] nums = {3,2,1,6,0,5};
        ConstructMaximumBinaryTree solution = new ConstructMaximumBinaryTree();
        TreeNode root = solution.constructMaximumBinaryTree(nums);
        List<Integer> list = TreeNode.inorderTraversal(root);
        System.out.println(list);
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return null;
        }

        int maxNum = -1;
        int maxIndex = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] > maxNum) {
                maxNum = nums[i];
                maxIndex = i;
            }
        }

        TreeNode root = new TreeNode(maxNum);
        root.left = constructMaximumBinaryTree(Arrays.copyOfRange(nums, 0, maxIndex));
        root.right = constructMaximumBinaryTree(Arrays.copyOfRange(nums, maxIndex + 1, n));
        return root;
    }
}
