package hot100;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 739. 每日温度
 * https://leetcode.cn/problems/daily-temperatures/
 */
public class Hot100_100_dailyTemperatures {
    public static void main(String[] args) {
        int[] temperatures = {73,74,75,71,69,72,76,73};
        Hot100_100_dailyTemperatures solution = new Hot100_100_dailyTemperatures();
        int[] ans = solution.dailyTemperatures(temperatures);
        System.out.println(Arrays.toString(ans));
    }

    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0 ; i < n; i++) {
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
