package hot100;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 84. 柱状图中最大的矩形
 * https://leetcode.cn/problems/largest-rectangle-in-histogram/
 */
public class Hot100_35_largestRectangleArea {
    public static void main(String[] args) {
        int[] heights = {2, 1, 5, 6, 2, 3};
        Hot100_35_largestRectangleArea solution = new Hot100_35_largestRectangleArea();
        int ans = solution.largestRectangleArea2(heights);
        System.out.println(ans);
    }

    // 暴力解法，超时
    public int largestRectangleArea1(int[] heights) {
        int n = heights.length;
        int maxArea = 0;
        for (int mid = 0; mid < n; mid++) {
            int left = mid, right = mid;
            while (left - 1 >= 0 && heights[left - 1] >= heights[mid]) {
                left--;
            }
            while (right + 1 < n && heights[right + 1] >= heights[mid]) {
                right++;
            }
            maxArea = Math.max(maxArea, (right - left + 1) * heights[mid]);
        }
        return maxArea;
    }

    // 栈 加入哨兵思想
    /*
        在数组前后都添加一个高度为0的值
        第一个高度为0的值保证了不用判断栈为空的场景
        第二个高度为0的值保证了栈中元素最终会全部弹出(不弹出位置为0的高度为0的值)
        从而简化讨论
     */
    public int largestRectangleArea2(int[] heights) {
        int n = heights.length;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return heights[0];
        }

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
