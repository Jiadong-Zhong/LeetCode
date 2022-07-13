package sword_to_offer;

import hot100.util.TreeNode;

/**
 * 剑指 Offer 26. 树的子结构
 * https://leetcode.cn/problems/shu-de-zi-jie-gou-lcof/
 */
public class Offer26_isSubStructure {
    public static void main(String[] args) {
        Integer[] nums1 = {3,4,5,1,2};
        Integer[] nums2 = {4,1};

        TreeNode A = TreeNode.arrayToTreeNode(nums1);
        TreeNode B = TreeNode.arrayToTreeNode(nums2);

        Offer26_isSubStructure solution = new Offer26_isSubStructure();
        boolean ans = solution.isSubStructure(A, B);
        System.out.println(ans);
    }

    // 递归
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return (A != null && B != null) && (recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }

    private boolean recur(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        }
        if (A == null || A.val != B.val) {
            return false;
        }
        return recur(A.left, B.left) && recur(A.right, B.right);
    }
}
