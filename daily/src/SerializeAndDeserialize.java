import utils.TreeNode;

import java.util.*;

/**
 * 449. 序列化和反序列化二叉搜索树
 * https://leetcode.cn/problems/serialize-and-deserialize-bst/
 */
public class SerializeAndDeserialize {
    public static void main(String[] args) {
        Integer[] nums = {2,1,3};
        TreeNode root = TreeNode.arrayToTreeNode(nums);
        SerializeAndDeserialize solution = new SerializeAndDeserialize();
        String s = solution.serialize2(root);
        System.out.println(s);
        TreeNode treeNode = solution.deserialize2(s);
        List<Integer> list = TreeNode.inorderTraversal(treeNode);
        System.out.println(list);
    }

    public String serialize1(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        return sb.toString();
    }

    public TreeNode deserialize1(String data) {
        String[] dataArray = data.split(",");
        List<String> dataList = new ArrayList<>(Arrays.asList(dataArray));
        return deserializeHelper(dataList);
    }

    public StringBuilder serializeHelper(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("null,");
        } else {
            sb.append(root.val).append(",");
            sb = serializeHelper(root.left, sb);
            sb = serializeHelper(root.right, sb);
        }
        return sb;
    }

    public TreeNode deserializeHelper(List<String> dataList) {
        if (dataList.get(0).equals("null")) {
            dataList.remove(0);
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(dataList.get(0)));
        dataList.remove(0);
        root.left = deserializeHelper(dataList);
        root.right = deserializeHelper(dataList);

        return root;
    }


    // ***************************************************************************

    public String serialize2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        postOrder(root, list);
        String str = list.toString(); // [1, 3, 2]
        return str.substring(1, str.length() - 1);
    }

    public TreeNode deserialize2(String data) {
        if (data.isEmpty()) {
            return null;
        }
        String[] arr = data.split(", ");
        Deque<Integer> stack = new ArrayDeque<>();
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            stack.push(Integer.parseInt(arr[i]));
        }
        return construct(Integer.MIN_VALUE, Integer.MAX_VALUE, stack);
    }

    private void postOrder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        postOrder(root.left, list);
        postOrder(root.right, list);
        list.add(root.val);
    }

    private TreeNode construct(int lower, int upper, Deque<Integer> stack) {
        if (stack.isEmpty() || stack.peek() < lower || stack.peek() > upper) {
            return null;
        }
        int val = stack.pop();
        TreeNode root = new TreeNode(val);
        root.right = construct(val, upper, stack);
        root.left = construct(lower, val, stack);
        return root;
    }
}
