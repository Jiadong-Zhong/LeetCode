import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 636. 函数的独占时间
 * https://leetcode.cn/problems/exclusive-time-of-functions/
 */
public class ExclusiveTime {
    public static void main(String[] args) {
        int n = 2;
        List<String> logs = new ArrayList<>();
        logs.add("0:start:0");
        logs.add("1:start:2");
        logs.add("1:start:5");
        logs.add("0:start:6");

    }

    public int[] exclusiveTime(int n, List<String> logs) {
        int[] ans = new int[n];
        Deque<int[]> stack = new ArrayDeque<>();
        for (String log : logs) {
            String[] info = log.split(":");
            int id = Integer.parseInt(info[0]);
            int timestamp = Integer.parseInt(info[2]);
            String type = info[1];
            if ("start".equals(type)) {
                if (!stack.isEmpty()) {
                    ans[stack.peek()[0]] += timestamp - stack.peek()[1];
                    stack.peek()[1] = timestamp;
                }
                stack.push(new int[]{id, timestamp});
            } else {
                int[] t = stack.pop();
                ans[t[0]] += timestamp - t[1] + 1;
                if (!stack.isEmpty()) {
                    stack.peek()[1] = timestamp + 1;
                }
            }
        }
        return ans;
    }
}
