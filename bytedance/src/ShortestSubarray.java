import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 862. 和至少为 K 的最短子数组
 * https://leetcode.cn/problems/shortest-subarray-with-sum-at-least-k/
 */
public class ShortestSubarray {
    public static void main(String[] args) {
        int[] nums = {84, -37, 32, 40, 95};
        int k = 167;
        ShortestSubarray solution = new ShortestSubarray();
        int ans = solution.shortestSubarray(nums, k);
        System.out.println(ans);
    }

    // 因为有负数，所以使用前缀和
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        long[] p = new long[n + 1];
        for (int i = 0; i < n; i++) {
            p[i + 1] = p[i] + nums[i];
        }

        int ans = n + 1;
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n + 1; i++) {
            // 前缀和又小，且索引还大才留在队列里
            while (!queue.isEmpty() && p[i] <= p[queue.getLast()]) {
                queue.removeLast();
            }
            // 当前前缀和减去队列头部的前缀和 大于 k 说明满足条件，队列头部的索引是最小的
            while (!queue.isEmpty() && p[i] >= p[queue.getFirst()] + k) {
                ans = Math.min(ans, i - queue.removeFirst());
            }

            queue.addLast(i);
        }
        return ans < n + 1 ? ans : -1;
    }
}
