package hot100;

import java.util.*;

/**
 * 621. 任务调度器
 * https://leetcode.cn/problems/task-scheduler/
 */
public class Hot100_98_leastInterval {
    public static void main(String[] args) {
        char[] tasks = {'A','A','A','B','B','B'};
        int n = 2;
        Hot100_98_leastInterval solution = new Hot100_98_leastInterval();
        int ans = solution.leastInterval2(tasks, n);
        System.out.println(ans);
    }

    // 模拟，nextValid存放每个任务的下一个就绪时间，rest存放每个任务的剩余执行次数
    // 每次选择不在冷却中且执行次数最多的任务
    public int leastInterval1(char[] tasks, int n) {
        Map<Character, Integer> freq = new HashMap<>();
        for (char ch : tasks) {
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }

        int m = freq.size();
        List<Integer> nextValid = new ArrayList<>();
        List<Integer> rest = new ArrayList<>();
        for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
            int value = entry.getValue();
            nextValid.add(1);
            rest.add(value);
        }

        int time = 0;
        for (int i = 0 ; i < tasks.length; i++) {
            time++;
            int minNextValid = Integer.MAX_VALUE;
            for (int j = 0; j < m; j ++) {
                if (rest.get(j) != 0) {
                    minNextValid = Math.min(minNextValid, nextValid.get(j));
                }
            }
            time = Math.max(time, minNextValid);
            // 遍历寻找下一个执行的任务
            int best = -1;
            for (int j = 0; j < m; j++) {
                // 下一个任务的剩余次数不为0并且已经就绪
                if (rest.get(j) != 0 && nextValid.get(j) <= time) {
                    if (best == -1 || rest.get(j) > rest.get(best)) {
                        best = j;
                    }
                }
            }
            nextValid.set(best, time + n + 1);
            rest.set(best, rest.get(best) - 1);
        }
        return time;
    }

    // 构造，方法十分巧妙，看题解
    public int leastInterval2(char[] tasks, int n) {
        Map<Character, Integer> freq = new HashMap<>();
        int maxExec = 0;
        for (char ch : tasks) {
            int exec = freq.getOrDefault(ch, 0) + 1;
            freq.put(ch, exec);
            maxExec = Math.max(maxExec, exec);
        }

        // 具有最多执行次数的任务数量
        int maxCount = 0;
        for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
            int value = entry.getValue();
            if (value == maxExec) {
                maxCount++;
            }
        }
        return Math.max((maxExec - 1) * (n + 1) + maxCount, tasks.length);
    }
}
