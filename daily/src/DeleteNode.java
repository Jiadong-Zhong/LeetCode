import utils.TreeNode;

/**
 * 450. 删除二叉搜索树中的节点
 * https://leetcode.cn/problems/delete-node-in-a-bst/
 */
public class DeleteNode {
    public static void main(String[] args) {
        Integer[] nums = {5, 3, 6, 2, 4, null, 7};
        int key = 2;
        TreeNode root = TreeNode.arrayToTreeNode(nums);
        DeleteNode solution = new DeleteNode();
        solution.deleteNode1(root, key);
    }

    // 递归
    public TreeNode deleteNode1(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val > key) {
            root.left = deleteNode1(root.left, key);
            return root;
        }
        if (root.val < key) {
            root.right = deleteNode1(root.right, key);
            return root;
        }
        if (root.val == key) {
            if (root.left == null && root.right == null) {
                return null;
            }
            if (root.right == null) {
                return root.left;
            }
            if (root.left == null) {
                return root.right;
            }
            TreeNode successor = root.right;
            while (successor.left != null) {
                successor = successor.left;
            }
            root.right = deleteNode1(root.right, successor.val);
            successor.right = root.right;
            successor.left = root.left;
            return successor;
        }
        return root;
    }

    // 迭代
    public TreeNode deleteNode2(TreeNode root, int key) {
        TreeNode cur = root, curParent = null;
        while (cur != null && cur.val != key) {
            curParent = cur;
            if (cur.val > key) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
        if (cur == null) {
            return root;
        }
        if (cur.left == null && cur.right == null) {
            cur = null;
        } else if (cur.right == null) {
            cur = cur.left;
        } else if (cur.left == null) {
            cur = cur.right;
        } else {
            TreeNode successor = cur.right, successorParent = cur;
            while (successor.left != null) {
                successorParent = successor;
                successor = successor.left;
            }
            if (successorParent.val == cur.val) {
                successorParent.right = successor.right;
            } else {
                successorParent.left = successor.right;
            }
            successor.right = cur.right;
            successor.left = cur.left;
            cur = successor;
        }
        if (curParent == null) {
            return cur;
        } else {
            if (curParent.left != null && curParent.left.val == key) {
                curParent.left = cur;
            } else {
                curParent.right = cur;
            }
            return root;
        }
    }
}
