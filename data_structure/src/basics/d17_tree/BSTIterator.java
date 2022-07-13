package basics.d17_tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 173. 二叉搜索树迭代器
 * https://leetcode-cn.com/problems/binary-search-tree-iterator/
 */
public class BSTIterator {
    private int index;
    private List<Integer> arr;

    public BSTIterator(TreeNode root) {
        index = 0;
        arr = new ArrayList<>();
        inorderTraversal(root, arr);

    }

    public int next() {
        return arr.get(index++);
    }

    public boolean hasNext() {
        return index < arr.size();
    }

    private void inorderTraversal(TreeNode root, List<Integer> arr) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left, arr);
        arr.add(root.val);
        inorderTraversal(root.right, arr);
    }
}

class BSTIterator1 {
    private TreeNode cur;
    private Deque<TreeNode> stack;

    public BSTIterator1(TreeNode root) {
        cur = root;
        stack = new LinkedList<>();
    }

    public int next() {
        while (cur != null) {
            stack.push(cur);
            cur = cur.left;
        }
        cur = stack.pop();
        int ret = cur.val;
        cur = cur.right;
        return ret;
    }

    public boolean hasNext() {
        return cur != null || !stack.isEmpty();
    }
}
