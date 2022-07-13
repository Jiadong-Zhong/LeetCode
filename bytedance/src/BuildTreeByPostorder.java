import util.TreeNode;

import java.util.List;

/**
 * 根据后序遍历数组重建二叉搜索树
 */
public class BuildTreeByPostorder {

    public static void main(String[] args) {
        int[] postorder = {1,3,2,6,5};
        BuildTreeByPostorder solution = new BuildTreeByPostorder();
        TreeNode root = solution.buildTree(postorder, 0, postorder.length - 1);
        List<List<Integer>> ans = TreeNode.levelOrder(root);
        System.out.println(ans);
    }

    public TreeNode buildTree(int[] postorder, int left, int right) {
        if (left > right) {
            return null;
        }

        TreeNode node = new TreeNode(postorder[right]);

        if (left == right) {
            return node;
        }

        // 找左右子树的分解点
        int mid = right - 1;
        while (mid > 0) {
            if (postorder[mid] < node.val) {
                break;
            }
            mid--;
        }

        node.left = buildTree(postorder, left, mid);
        node.right = buildTree(postorder, mid, right - 1);
        return node;
    }
}
