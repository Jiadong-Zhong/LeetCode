import utils.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

/**
 * 919. 完全二叉树插入器
 * https://leetcode.cn/problems/complete-binary-tree-inserter/
 */
public class CBTInserter {
    public static void main(String[] args) {
        Integer[] nums = {1,2};
        TreeNode root = TreeNode.arrayToTreeNode(nums);
        CBTInserter cbtInserter = new CBTInserter(root);
        int param1 = cbtInserter.insert(3);
        int param2 = cbtInserter.insert(4);
        TreeNode ans = cbtInserter.get_root();
        List<Integer> list = TreeNode.inorderTraversal(ans);
        System.out.println(param1);
        System.out.println(param2);
        System.out.println(list);
    }

    TreeNode root;
    Deque<TreeNode> nodes;

    public CBTInserter(TreeNode root) {
        this.root = root;
        nodes = new ArrayDeque<>();

        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
            if (!(node.left != null && node.right != null)) {
                nodes.offer(node);
            }
        }
    }

    public int insert(int val) {
        TreeNode child = new TreeNode(val);
        TreeNode curr = nodes.peek();
        if (curr.left == null) {
            curr.left = child;
        } else {
            curr.right = child;
            nodes.poll();
        }
        nodes.offer(child);
        return curr.val;
    }

    public TreeNode get_root() {
        return root;
    }
}
