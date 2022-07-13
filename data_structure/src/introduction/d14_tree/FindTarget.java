package introduction.d14_tree;

import java.util.*;

/**
 * 653. 两数之和 IV - 输入 BST
 * https://leetcode-cn.com/problems/two-sum-iv-input-is-a-bst/
 */
public class FindTarget {
    public static void main(String[] args) {
        Integer[] nums = {5, 3, 6, 2, 4, null, 7};
        int k = 9;
        TreeNode root = TreeNode.arrayToTreeNode(nums);

        FindTarget helper = new FindTarget();
        boolean res = helper.findTarget1(root, k);
        System.out.println(res);

    }

    public Set<Integer> set = new HashSet<>();
    public boolean findTarget1(TreeNode root, int k) {
        if (root == null) {
            return false;
        }

        if (set.contains(k - root.val)) {
            return true;
        }
        set.add(root.val);
        return findTarget1(root.left, k) || findTarget1(root.right, k);
    }

    public boolean findTarget2(TreeNode root, int k) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (set.contains(k - cur.val)) {
                return true;
            }
            set.add(cur.val);
            if (cur.left != null) {
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
            }
        }
        return false;
    }

    List<Integer> list = new ArrayList<>();
    public boolean findTarget3(TreeNode root, int k) {
        inorderTraversal(root);
        int left = 0;
        int right = list.size() - 1;
        while (left < right) {
            if (list.get(left) + list.get(right) == k) {
                return true;
            }
            if (list.get(left) + list.get(right) < k) {
                left++;
            } else {
                right--;
            }
        }
        return false;
    }

    public void inorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left);
        list.add(root.val);
        inorderTraversal(root.right);
    }

    public boolean findTarget4(TreeNode root, int k) {
        TreeNode left = root;
        TreeNode right = root;
        Deque<TreeNode> leftStack = new ArrayDeque<>();
        Deque<TreeNode> rightStack = new ArrayDeque<>();
        leftStack.push(left);
        while (left.left != null) {
            leftStack.push(left);
            left = left.left;
        }
        rightStack.push(right);
        while (right.right != null) {
            rightStack.push(right);
            right = right.right;
        }
        // 此时left指向BST中最小元素对应的节点，right指向BST中最大元素对应的节点
        while (left != right) {
            if (left.val + right.val == k) {
                return true;
            }
            if (left.val + right.val < k) {
                left = getLeft(leftStack); // left需要右移
            } else {
                right = getRight(rightStack);  // right需要左移
            }
        }
        return false;
    }

    // 取出左子树中次小值
    public TreeNode getLeft(Deque<TreeNode> stack) {
        TreeNode root = stack.pop();
        TreeNode cur = root.right;
        while (cur != null) {
            stack.push(cur);
            cur = cur.left;
        }
        return root;
    }

    public TreeNode getRight(Deque<TreeNode> stack) {
        TreeNode root = stack.pop();
        TreeNode cur = root.left;
        while (cur != null) {
            stack.push(cur);
            cur = cur.right;
        }
        return root;
    }
}
