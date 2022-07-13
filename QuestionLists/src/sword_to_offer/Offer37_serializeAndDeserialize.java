package sword_to_offer;

import sword_to_offer.util.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 剑指 Offer 37. 序列化二叉树
 * https://leetcode.cn/problems/xu-lie-hua-er-cha-shu-lcof/
 */
public class Offer37_serializeAndDeserialize {
    public static void main(String[] args) {
        Integer[] nums = {1,2,3,null,null,4,5};
        TreeNode root = TreeNode.arrayToTreeNode(nums);
        Codec codec = new Codec();
        String s = codec.serialize(root);
        TreeNode ans = codec.deserialize(s);

    }
}

class Codec {
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Deque<TreeNode> queue = new ArrayDeque<>();
        sb.append(root.val);
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                sb.append(",").append(node.left.val);
                queue.offer(node.left);
            } else {
                sb.append(",").append("None");
            }
            if (node.right != null) {
                sb.append(",").append(node.right.val);
                queue.offer(node.right);
            } else {
                sb.append(",").append("None");
            }
        }
        return sb.toString();
    }

    public TreeNode deserialize(String data) {
        if (data.length() == 0) {
            return null;
        }
        String[] strings = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(strings[0]));
        boolean isLeft = true;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        for (int i = 1; i < strings.length; i++) {
            TreeNode curr = queue.peek();
            if (isLeft) {
                if (!"None".equals(strings[i])) {
                    curr.left = new TreeNode(Integer.parseInt(strings[i]));
                    queue.offer(curr.left);
                }
                isLeft = false;
            } else {
                if (!"None".equals(strings[i])) {
                    curr.right = new TreeNode(Integer.parseInt(strings[i]));
                    queue.offer(curr.right);
                }
                queue.poll();
                isLeft = true;
            }
        }
        return root;
    }
}
