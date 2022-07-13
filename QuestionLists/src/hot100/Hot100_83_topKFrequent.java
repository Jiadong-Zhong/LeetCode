package hot100;

import java.util.*;

/**
 * 347. 前 K 个高频元素
 * https://leetcode.cn/problems/top-k-frequent-elements/
 */
public class Hot100_83_topKFrequent {
    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        int k = 2;
        Hot100_83_topKFrequent solution = new Hot100_83_topKFrequent();
        solution.topKFrequent1(nums, k);
    }

    public int[] topKFrequent1(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        List<int[]> values = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            int num = entry.getKey(), val = entry.getValue();
            values.add(new int[] {num, val});
        }

        int[] ans = new int[k];
        quickSort(values, 0, values.size() - 1, ans, 0, k);
        return ans;
    }

    public void quickSort(List<int[]> values, int start, int end, int[] ans, int ansIndex, int k) {
        int picked = (int) (Math.random() * (end - start + 1) + start);
        Collections.swap(values, picked, start);

        int pivot = values.get(start)[1];
        int index = start;
        for (int i = start + 1; i <= end; i++) {
            if (values.get(i)[1] <= pivot) {
                Collections.swap(values, index + 1, i);
                index++;
            }
        }
        Collections.swap(values, start, index);

        if (k <= index - start) {
            quickSort(values, start, index - 1, ans, ansIndex, k);
        } else {
            for (int i = start; i <= index; i++) {
                ans[ansIndex++] = values.get(i)[0];
            }
            if (k > index - start + 1) {
                quickSort(values, index + 1, end, ans, ansIndex, k - (index - start + 1));
            }
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));

        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            int num = entry.getKey(), val = entry.getValue();
            if (queue.size() == k) {
                if (queue.peek()[1] < val) {
                    queue.poll();
                    queue.offer(new int[] {num, val});
                }
            } else {
                queue.offer(new int[] {num, val});
            }
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = queue.poll()[0];
        }
        return res;
    }
}
