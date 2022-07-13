package basics.d20_priority_queue;

import java.util.*;

/**
 * 347. 前 K 个高频元素
 * https://leetcode-cn.com/problems/top-k-frequent-elements/
 */
public class TopKFrequent {
    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        int k = 2;
        TopKFrequent solution = new TopKFrequent();
        int[] res = solution.topKFrequent1(nums, k);
    }

    public int[] topKFrequent1(int[] nums, int k) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int num : nums) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            int num = entry.getKey();
            int count = entry.getValue();
            if (queue.size() == k) {
                if (queue.peek()[1] < count) {
                    queue.poll();
                    queue.offer(new int[] {num, count});
                }
            } else {
                queue.offer(new int[] {num, count});
            }
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = queue.poll()[0];
        }
        return res;
    }

    public int[] topKFrequent2(int[] nums, int k) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int num : nums) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }
        List<int[]> values = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            int num = entry.getKey();
            int count = entry.getValue();
            values.add(new int[] {num, count});
        }
        int[] res = new int[k];
        quickSelect(values, 0, values.size() - 1, res, 0, k);
        return res;
    }

    public void quickSelect(List<int[]> values, int start, int end, int[] res, int resIndex, int k) {
        Random random = new Random();
        int p =  random.nextInt(end - start + 1) + start;
        Collections.swap(values, p, end);

        int x = values.get(end)[1];
        int index = start;
        for (int i = start + 1; i <= end; i++) {
            if (values.get(i)[1] >= x) {
                Collections.swap(values, index + 1, i);
                index++;
            }
        }
        Collections.swap(values, index, end);

        // 左侧数组的长度为index - start + 1，如果k比其小，前k大的值就是左侧数组前k大的值
        if (k < index - start + 1) {
            quickSelect(values, start, index - 1, res, resIndex, k);
        } else {
            for (int i = start; i <= index; i++) {
                res[resIndex++] = values.get(i)[0];
            }
            if (k > index - start + 1) {
                quickSelect(values, index + 1, start, res, resIndex, k - (index - start + 1));
            }
        }
    }
}
