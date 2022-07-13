import java.util.*;

public class LevelOrder {
    public static void main(String[] args) {
        Integer[] nums = {1, null, 3, 2, 4, null, 5, 6};
        List<Integer> res = new ArrayList<>();
        Node root = arrayToTreeNode(nums);
        dfs(root, res);
        System.out.println(res);

        List<List<Integer>> ans = levelOrder1(root);
        System.out.println(ans);

    }

    public static List<List<Integer>> levelOrder1(Node root) {
        if (root == null) {
            return new ArrayList<List<Integer>>();
        }
        List<List<Integer>> ans = new ArrayList<>();
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int count = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < count; i++) {
                Node cur = queue.poll();
                level.add(cur.val);
                // 下方判断为实现方便使用
                for (Node child : cur.children) {
                    queue.offer(child);
                }
            }
            ans.add(level);
        }
        return ans;
    }

    private static Node arrayToTreeNode(Integer[] nums) {
        // 利用队列辅助，N叉树输入按层序遍历序列化表示，每组子节点由空值分隔
        // 例子：[1,null,3,2,4,null,5,6]，[1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
        if (nums == null || nums.length == 0) {
            return null;
        }
        // 数组的开始下标
        int i = 1;
        Node root = new Node(nums[0]);
        Node current = null;
        Integer value;
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(root);

        // 遍历数组，构造N叉树
        while (i < nums.length) {
            if (nums[i] == null) {
                i++;
                current = queue.poll();
            } else {
                // 获取数组的值，数组下标加1
                value = nums[i];
                i++;
                // 创建当前父节点的孩子
                Node node = new Node(value);
                // assert current != null;
                current.children.add(node);
                queue.add(node);
            }
        }
        return root;
    }


    private static void dfs(Node root, List<Integer> ans) {
        if (root == null) {
            return;
        }
        ans.add(root.val);
        if (root.children != null) {
            for (Node child : root.children) {
                dfs(child, ans);
            }
        }
    }
}

class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
        children = new ArrayList<>();
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
