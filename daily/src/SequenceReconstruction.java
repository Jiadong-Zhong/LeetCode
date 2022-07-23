import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/**
 * 剑指 Offer II 115. 重建序列
 * https://leetcode.cn/problems/ur2n8P/
 */
public class SequenceReconstruction {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        int[][] sequences = {{1,2},{1,3},{1,2,3}};
        SequenceReconstruction solution = new SequenceReconstruction();
        boolean ans = solution.sequenceReconstruction(nums, sequences);

    }

    // 拓扑排序，其实就是看有没有唯一的从第一个节点到最后一个节点的通路
    public boolean sequenceReconstruction(int[] nums, int[][] sequences) {
        int n = nums.length;
        int[] inDegrees = new int[n + 1];
        Set<Integer>[] graph = new Set[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new HashSet<>();
        }

        for (int[] sequence : sequences) {
            int size = sequence.length;
            for (int i = 1; i < size; i++) {
                int prev = sequence[i - 1], next = sequence[i];
                if (graph[prev].add(next)) {
                    inDegrees[next]++;
                }
            }
        }

        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            if (inDegrees[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            if (queue.size() > 1) {
                return false;
            }
            int num = queue.poll();
            Set<Integer> set = graph[num];
            for (int next : set) {
                inDegrees[next]--;
                if (inDegrees[next] == 0) {
                    queue.offer(next);
                }
            }
        }
        return true;
    }
}
