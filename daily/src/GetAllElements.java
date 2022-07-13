import utils.TreeNode;

import java.util.*;

/**
 * 1305. 两棵二叉搜索树中的所有元素
 * https://leetcode-cn.com/problems/all-elements-in-two-binary-search-trees/
 */
public class GetAllElements {
    public static void main(String[] args) {
        Integer[] nums1 = {2,1,4};
        Integer[] nums2 = {1,0,3};
        TreeNode root1 = TreeNode.arrayToTreeNode(nums1);
        TreeNode root2 = TreeNode.arrayToTreeNode(nums2);

        List<Integer> l1 = TreeNode.inorderTraversal(root1);
        List<Integer> l2 = TreeNode.inorderTraversal(root2);
        System.out.println(l1);
        System.out.println(l2);

        List<Integer> res = getAllElements1(root1, root2);
        System.out.println(res);

    }

    public static List<Integer> getAllElements1(TreeNode root1, TreeNode root2) {
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        inorder(root1, l1);
        inorder(root2, l2);
        List<Integer> res = new ArrayList<>();

        int p1 = 0;
        int p2 = 0;
        while (p1 < l1.size() && p2 < l2.size()) {
            if (l1.get(p1) < l2.get(p2)) {
                res.add(l1.get(p1));
                p1++;
            } else {
                res.add(l2.get(p2));
                p2++;
            }
        }
        while (p1 < l1.size()) {
            res.add(l1.get(p1));
            p1++;
        }
        while (p2 < l2.size()) {
            res.add(l2.get(p2));
            p2++;
        }
        return res;
    }

    public static void inorder(TreeNode node, List<Integer> res) {
        if (node != null) {
            inorder(node.left, res);
            res.add(node.val);
            inorder(node.right, res);
        }
    }
}


