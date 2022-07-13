package hot100;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 85. 最大矩形
 * https://leetcode.cn/problems/maximal-rectangle/
 */
public class Hot100_36_maximalRectangle {
    public static void main(String[] args) {
        char[][] matrix = {{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
        Hot100_36_maximalRectangle solution = new Hot100_36_maximalRectangle();
        int ans = solution.maximalRectangle2(matrix);
        System.out.println(ans);
    }

    // 暴力解法
    public int maximalRectangle1(char[][] matrix) {
        int m = matrix.length;
        if (m == 0) {
            return 0;
        }
        int n = matrix[0].length;
        int[][] left = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    left[i][j] = (j == 0 ? 0 : left[i][j - 1]) + 1;
                }
            }
        }

        int maxArea = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '0') {
                    continue;
                }
                int width = left[i][j];  // 先将宽初始化左边连续1的个数
                int area = width; // 此时面积就是这个宽度，因为高为1
                for (int k = i - 1; k >= 0; k--) { // 遍历从这个点开始以上的所有行
                    width = Math.min(width, left[k][j]);
                    area = Math.max(area, (i - k + 1) * width);
                }
                maxArea = Math.max(area, maxArea);
            }
        }
        return maxArea;
    }

    // 单调栈，上述方法实际上就是把矩阵拆分成为一系列柱状图，可以使用35_largestRectangleArea里面的方法来解决
    public int maximalRectangle2(char[][] matrix) {
        int m = matrix.length;
        if (m == 0) {
            return 0;
        }
        int n = matrix[0].length;
        int[][] left = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    left[i][j] = (j == 0 ? 0 : left[i][j - 1]) + 1;
                }
            }
        }

        int maxArea = 0;
        for (int j = 0; j < n; j++) {  // 对每列使用基于柱状图的方法
            int[] up = new int[m];  // 表示该列上面第一个比当前值left[i][j]小的索引位置
            int[] down = new int[m]; // 表示该列下面第一个比当前值left[i][j]小的索引位置

            Deque<Integer> stack = new ArrayDeque<>();
            for (int i = 0; i < m; i++) {
                while (!stack.isEmpty() && left[stack.peek()][j] >= left[i][j]) {
                    stack.pop();
                }
                up[i] = stack.isEmpty() ? -1 : stack.peek();
                stack.push(i);
            }
            stack.clear();
            for (int i = m - 1; i >= 0; i--) {
                while (!stack.isEmpty() && left[stack.peek()][j] >= left[i][j]) {
                    stack.pop();
                }
                down[i] = stack.isEmpty() ? m : stack.peek();
                stack.push(i);
            }

            // 如果按照84题的理解，这里的height是84中的宽度，left[i][j]是柱状图的高度
            // 也就是做整体把矩阵逆时针旋转90度，然后从底层向上层逐层使用84题中的方法
            for (int i = 0; i < m; i++) {
                int height = down[i] - up[i] - 1;
                int area = height * left[i][j];
                maxArea = Math.max(maxArea, area);
            }
        }
        return maxArea;
    }

    // 直接引用上一题之中的方法
    public int maximalRectangle3(char[][] matrix) {
        int m = matrix.length;
        if (m == 0) {
            return 0;
        }
        int n = matrix[0].length;
        int maxArea = 0;

        int[] heights = new int[n];
        /*
            heights 的高度依次是，
            第一行时 1 0 1 0 0
            第二行时 2 0 2 1 1
            第三行时 3 1 2 2 2
            第四行时 4 0 0 3 0
         */
        for (int row = 0; row < m; row++) {
            // 一行一行遍历，保存柱高
            for (int col = 0; col < n; col++) {
                if (matrix[row][col] == '1') {
                    heights[col] += 1;
                } else {
                    heights[col] = 0;
                }
            }
            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }
        return maxArea;
    }

    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int area = 0;
        int[] newHeights = new int[n + 2];
        for (int i = 0; i < n; i++) {
            newHeights[i + 1] = heights[i];
        }
        n += 2;
        heights = newHeights;

        Deque<Integer> stack = new ArrayDeque<>();
        stack.addLast(0);

        for (int i = 1; i < n; i++) {
            while (heights[stack.peekLast()] > heights[i]) {
                int height = heights[stack.removeLast()];

                int width = i - stack.peekLast() - 1;

                area = Math.max(area, width * height);
            }
            stack.addLast(i);
        }
        return area;
    }

}
