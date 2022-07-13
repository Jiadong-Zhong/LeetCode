package sword_to_offer;

import java.util.*;

/**
 * 剑指 Offer 59 - I. 滑动窗口的最大值
 * https://leetcode.cn/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof/
 */
public class Offer59_maxSlidingWindow {
    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        Offer59_maxSlidingWindow solution = new Offer59_maxSlidingWindow();
        int[] ans = solution.maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(ans));
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k == 0) {
            return new int[0];
        }

        Deque<Integer> deque = new ArrayDeque<>();
        int[] res = new int[nums.length - k + 1];
        // 未形成窗口
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.removeLast();
            }
            deque.addLast(nums[i]);
        }
        res[0] = deque.peekFirst();

        // 形成窗口后
        for (int i = k; i < nums.length; i++) {
            if (deque.peekFirst() == nums[i - k]) {
                deque.removeFirst();
            }
            while (!deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.removeLast();
            }
            deque.addLast(nums[i]);
            res[i - k + 1] = deque.peekFirst();
        }
        return res;
    }
}
