import util.TreeNode;

/**
 * 1145. 二叉树着色游戏
 * https://leetcode.cn/problems/binary-tree-coloring-game/
 */
public class BtreeGameWinningMove {
    public static void main(String[] args) {
        Integer[] nums = {1,2,3,4,5,6,7,8,9,10,11};
        int n = 11;
        int x = 3;
        TreeNode root = TreeNode.arrayToTreeNode(nums);
        BtreeGameWinningMove solution = new BtreeGameWinningMove();
        boolean ans = solution.btreeGameWinningMove(root, n, x);
        System.out.println(ans);
    }

    // 玩家1选择了第x个节点，每个节点可以分为3部分，左子树、右子树和父节点
    // 如果x节点的左子树大于一半节点，选择左子树就赢了
    // 如果x节点的右子树大于一半节点，选择右子树就赢了
    // 如果x节点的左子树和右子树之和小于一半，选择父节点就赢了
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        TreeNode xRoot = findNode(root, x);
        int left = countNodes(xRoot.left);
        int right = countNodes(xRoot.right);
        int half = n / 2;
        if (left > half || right > half || left + right < half) {
            return true;
        }
        return false;
    }

    private TreeNode findNode(TreeNode root, int x) {
        if (root == null) {
            return null;
        }
        if (root.val == x) {
            return root;
        }

        TreeNode left = findNode(root.left, x);
        TreeNode right = findNode(root.right, x);
        return left != null ? left : right;
    }

    private int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
}
