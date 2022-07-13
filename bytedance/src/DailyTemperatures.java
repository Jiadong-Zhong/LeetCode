import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 739. 每日温度
 * https://leetcode.cn/problems/daily-temperatures/
 * 单调栈使用场景：当需要求左边或者右边第一个比当前位置大或小的元素
 */
public class DailyTemperatures {
    public static void main(String[] args) {
        int[] temperatures = {73,74,75,71,69,72,76,73};
        DailyTemperatures solution = new DailyTemperatures();
        int[] ans = solution.dailyTemperatures1(temperatures);
        System.out.println(Arrays.toString(ans));
    }

    // 暴力
    public int[] dailyTemperatures1(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int index = i;
            while (index < n && temperatures[i] >= temperatures[index]) {
                index++;
            }
            if (index == n) {
                ans[i] = 0;
            } else {
                ans[i] = index - i;
            }
        }
        return ans;
    }

    // 单调栈
    public int[] dailyTemperatures2(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            int temperature = temperatures[i];
            while (!stack.isEmpty() && temperature > temperatures[stack.peek()]) {
                int prevIndex = stack.pop();
                ans[prevIndex] = i - prevIndex;
            }
            stack.push(i);
        }
        return ans;
    }
}
