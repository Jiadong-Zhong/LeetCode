import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 257. 二叉树的所有路径
 * https://leetcode.cn/problems/binary-tree-paths/
 */
public class BinaryTreePaths {
    public static void main(String[] args) {
        Integer[] nums = {1,2,3,null,5};
        TreeNode root = TreeNode.arrayToTreeNode(nums);

        BinaryTreePaths solution = new BinaryTreePaths();
        List<String> ans = solution.binaryTreePaths(root);
        System.out.println(ans);
    }

    List<List<TreeNode>> path = new ArrayList<>();
    List<TreeNode> temp = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        dfs(root);

        List<String> ans = new ArrayList<>();

        for (List<TreeNode> curr : path) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < curr.size(); j++) {
                sb.append(curr.get(j).val);
                if (j != curr.size() - 1) {
                    sb.append("->");
                }
            }
            ans.add(sb.toString());
        }
        return ans;
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }

        temp.add(root);
        if (root.left == null && root.right == null) {
            path.add(new ArrayList<>(temp));
        }

        dfs(root.left);
        dfs(root.right);
        temp.remove(temp.size() - 1);
    }
}
