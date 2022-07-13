import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 427. 建立四叉树
 * https://leetcode-cn.com/problems/construct-quad-tree/
 */
public class QuadTree {
    public static void main(String[] args) {
        int[][] grid = {{1, 1, 1, 1, 0, 0, 0, 0}, {1, 1, 1, 1, 0, 0, 0, 0}, {1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 0, 0, 0, 0}, {1, 1, 1, 1, 0, 0, 0, 0}, {1, 1, 1, 1, 0, 0, 0, 0}, {1, 1, 1, 1, 0, 0, 0, 0}};
        QuadTreeNode res = construct2(grid);
        QuadTreeNode.levelOrder(res);

    }

    public static QuadTreeNode construct1(int[][] grid) {
        return dfs(grid, 0, 0, grid.length, grid.length);
    }

    public static QuadTreeNode dfs(int[][] grid, int r0, int c0, int r1, int c1) {
        boolean same = true;
        for (int i = r0; i < r1; i++) {
            for (int j = c0; j < c1; j++) {
                if (grid[i][j] != grid[r0][c0]) {
                    same = false;
                    break;
                }
            }
            if (!same) {
                break;
            }
        }

        if (same) {
            return new QuadTreeNode(grid[r0][c0] == 1, true);
        }

        QuadTreeNode ret = new QuadTreeNode(
                true,
                false,
                dfs(grid, r0, c0, (r0 + r1) / 2, (c0 + c1) / 2),
                dfs(grid, r0, (c0 + c1) / 2, (r0 + r1) / 2, c1),
                dfs(grid, (r0 + r1) / 2, c0, r1, (c0 + c1) / 2),
                dfs(grid, (r0 + r1) / 2, (c0 + c1) / 2, r1, c1)
        );
        return ret;
    }

    public static QuadTreeNode construct2(int[][] grid) {
        int n = grid.length;
        int[][] pre = new int[n + 1][n + 1];
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= n; ++j) {
                pre[i][j] = pre[i - 1][j] + pre[i][j - 1] - pre[i - 1][j - 1] + grid[i - 1][j - 1];
            }
        }
        return dfs(grid, pre, 0, 0, n, n);
    }

    public static QuadTreeNode dfs(int[][] grid, int[][] pre, int r0, int c0, int r1, int c1) {
        int total = getSum(pre, r0, c0, r1, c1);
        if (total == 0) {
            return new QuadTreeNode(false, true);
        } else if (total == (r1 - r0) * (c1 - c0)) {
            return new QuadTreeNode(true, true);
        }

        QuadTreeNode ret = new QuadTreeNode(
                true,
                false,
                dfs(grid, pre, r0, c0, (r0 + r1) / 2, (c0 + c1) / 2),
                dfs(grid, pre, r0, (c0 + c1) / 2, (r0 + r1) / 2, c1),
                dfs(grid, pre, (r0 + r1) / 2, c0, r1, (c0 + c1) / 2),
                dfs(grid, pre, (r0 + r1) / 2, (c0 + c1) / 2, r1, c1)
        );
        return ret;
    }

    public static int getSum(int[][] pre, int r0, int c0, int r1, int c1) {
        return pre[r1][c1] - pre[r1][c0] - pre[r0][c1] + pre[r0][c0];
    }
}






class QuadTreeNode {
    public boolean val;
    public boolean isLeaf;
    public QuadTreeNode topLeft;
    public QuadTreeNode topRight;
    public QuadTreeNode bottomLeft;
    public QuadTreeNode bottomRight;


    public QuadTreeNode() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public QuadTreeNode(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public QuadTreeNode(boolean val, boolean isLeaf, QuadTreeNode topLeft, QuadTreeNode topRight, QuadTreeNode bottomLeft, QuadTreeNode bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }

    public static void levelOrder(QuadTreeNode root) {
        Queue<QuadTreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            QuadTreeNode cur = queue.poll();
            if (!cur.val && !cur.isLeaf) {
                System.out.println("null");
                continue;
            }
            List<Integer> curNode = new ArrayList<>();

            if (cur.isLeaf) {
                curNode.add(1);
            } else {
                curNode.add(0);
            }

            if (cur.val) {
                curNode.add(1);
            } else {
                curNode.add(0);
            }
            System.out.println(curNode);

            if (!cur.isLeaf) {
                queue.offer(cur.topLeft);
                queue.offer(cur.topRight);
                queue.offer(cur.bottomLeft);
                queue.offer(cur.bottomRight);
            } else {
                queue.offer(new QuadTreeNode());
                queue.offer(new QuadTreeNode());
                queue.offer(new QuadTreeNode());
                queue.offer(new QuadTreeNode());
            }
        }
    }
};