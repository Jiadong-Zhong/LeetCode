package hot100;

import java.util.*;

/**
 * 42. 接雨水
 * https://leetcode.cn/problems/trapping-rain-water/
 */
public class Hot100_20_trap {
    public static void main(String[] args) {
        int[] height = {2,0,2};
        Hot100_20_trap solution = new Hot100_20_trap();
        int ans = solution.trap4(height);
        System.out.println(ans);

    }

    // 超时
    public int trap1(int[] height) {
        int ans = 0;
        int n = height.length;
        int maxHeight = 0;
        for (int i = 0; i < n; i++) {
            maxHeight = Math.max(maxHeight, height[i]);
        }

        for (int i = 0; i < maxHeight; i++) {
            List<Integer> index = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if (height[j] >= i + 1) {
                    index.add(j);
                }
            }
            if (index.size() > 1) {
                int right = index.remove(0);
                while (!index.isEmpty()) {
                    int left = right;
                    right = index.remove(0);
                    ans += right - left - 1;
                }
            }
        }
        return ans;
    }

    // 动态规划
    public int trap2(int[] height) {
        int ans = 0;
        int n = height.length;
        if (n < 3) {
            return 0;
        }
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        leftMax[0] = height[0];
        rightMax[n - 1] = height[n - 1];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
            rightMax[n - i - 1] = Math.max(rightMax[n - i], height[n - i - 1]);
        }
        for (int i = 0; i < n; i++) {
            ans += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return ans;
    }

    // 单调栈
    // 方法理解看视频
    // 使用单调递减栈存储索引
    // 从左到右遍历height
    // 当栈非空且当前元素比栈顶元素大时，说明可以形成积水
    // 弹出栈顶元素top，在该位置处可以形成积水
    // 计算积水的宽度，就是当前元素和top元素左边的元素，也就是栈顶元素的距离，currWidth
    // 计算积水的高度，就是当前元素和左边元素的最小值减去top
    // 将当前积水量加入答案，并且将当前元素入栈
    public int trap3(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        int ans = 0;
        while (i < height.length) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int top = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int currWidth = i - stack.peek() - 1;
                int currHeight = Math.min(height[i], height[stack.peek()]) - height[top];
                ans += currWidth * currHeight;
            }
            stack.push(i++);
        }
        return ans;
    }

    // 双指针
    /*
        定理一：在某个位置i处，它能存的水，取决于它左右两边的最大值中较小的一个。
        定理二：当我们从左往右处理到left下标时，左边的最大值left_max对它而言是可信的，但right_max对它而言是不可信的。
            对于left下标而言，right_max未必就是它右边最大的值
        定理三：当我们从右往左处理到right下标时，右边的最大值right_max对它而言是可信的，但left_max对它而言是不可信的。

        对于位置left而言，它左边最大值一定是left_max，右边最大值“大于等于”right_max，
        这时候，如果left_max<right_max成立，那么它就知道自己能存多少水了。
        无论右边将来会不会出现更大的right_max，都不影响这个结果。
        所以当left_max<right_max时，我们就希望去处理left下标，反之，我们希望去处理right下标。
     */
    public int trap4(int[] height) {
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0, ans = 0;
        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if (leftMax < rightMax) {
                ans += leftMax - height[left];
                left++;
            } else {
                ans += rightMax - height[right];
                right--;
            }
        }
        return ans;
    }
}
