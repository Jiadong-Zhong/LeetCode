import java.util.*;

/**
 * 768. 最多能完成排序的块 II
 * https://leetcode.cn/problems/max-chunks-to-make-sorted-ii/
 */
public class MaxChunksToSorted {
    public static void main(String[] args) {
        int[] arr = {2, 1, 3, 4, 4};

    }

    public int maxChunksToSorted(int[] arr) {
        Map<Integer, Integer> count = new HashMap<>();
        int ans = 0;
        int[] sortedArr = new int[arr.length];
        System.arraycopy(arr, 0, sortedArr, 0, arr.length);
        Arrays.sort(sortedArr);
        for (int i = 0; i < sortedArr.length; i++) {
            int x = arr[i], y = sortedArr[i];
            count.put(x, count.getOrDefault(x, 0) + 1);
            if (count.get(x) == 0) {
                count.remove(x);
            }
            count.put(y, count.getOrDefault(y, 0) - 1);
            if (count.get(y) == 0) {
                count.remove(y);
            }
            if (count.isEmpty()) {
                ans++;
            }
        }
        return ans;
    }

    public int maxChunksToSorted2(int[] arr) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int num : arr) {
            if (stack.isEmpty() || num >= stack.peek()) {
                stack.push(num);
            } else {
                int max = stack.pop();
                while (!stack.isEmpty() && stack.peek() > num) {
                    stack.pop();
                }
                stack.push(max);
            }
        }
        return stack.size();
    }
}
