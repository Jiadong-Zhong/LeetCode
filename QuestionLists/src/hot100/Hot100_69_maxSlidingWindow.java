package hot100;

import java.util.*;

/**
 * 239. 滑动窗口最大值
 * https://leetcode.cn/problems/sliding-window-maximum/
 */
public class Hot100_69_maxSlidingWindow {
    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        Hot100_69_maxSlidingWindow solution = new Hot100_69_maxSlidingWindow();
        int[] ans = solution.maxSlidingWindow4(nums, k);
        System.out.println(Arrays.toString(ans));
    }

    // 暴力解法
    public int[] maxSlidingWindow1(int[] nums, int k) {
        int length = nums.length;
        int[] ans = new int[length - k + 1];
        for (int i = 0; i < length - k + 1; i++) {
            int max = nums[i];
            for (int j = 0; j < k; j++) {
                max = Math.max(max, nums[i + j]);
            }
            ans[i] = max;
        }
        return ans;
    }

    // 优先队列
    public int[] maxSlidingWindow2(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o2[0] != o1[0] ? o2[0] - o1[0] : o2[1] - o1[1]);
        for (int i = 0; i < k; i++) {
            pq.offer(new int[]{nums[i], i});
        }
        int[] ans = new int[n - k + 1];
        ans[0] = pq.peek()[0];
        for (int i = k; i < n; i++) {
            pq.offer(new int[]{nums[i], i});
            while (pq.peek()[1] <= i - k) {
                pq.poll();
            }
            ans[i - k + 1] = pq.peek()[0];
        }
        return ans;
    }

    // 单调队列
    /*
        输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
        输出: [3,3,5,5,6,7]

        解释过程中队列中都是具体的值，方便理解，具体见代码。
        初始状态：L=R=0,队列:{}
        i=0,nums[0]=1。队列为空,直接加入。队列：{1}
        i=1,nums[1]=3。队尾值为1，3>1，弹出队尾值，加入3。队列：{3}
        i=2,nums[2]=-1。队尾值为3，-1<3，直接加入。队列：{3,-1}。此时窗口已经形成，L=0,R=2，result=[3]
        i=3,nums[3]=-3。队尾值为-1，-3<-1，直接加入。队列：{3,-1,-3}。队首3对应的下标为1，L=1,R=3，有效。result=[3,3]
        i=4,nums[4]=5。队尾值为-3，5>-3，依次弹出后加入。队列：{5}。此时L=2,R=4，有效。result=[3,3,5]
        i=5,nums[5]=3。队尾值为5，3<5，直接加入。队列：{5,3}。此时L=3,R=5，有效。result=[3,3,5,5]
        i=6,nums[6]=6。队尾值为3，6>3，依次弹出后加入。队列：{6}。此时L=4,R=6，有效。result=[3,3,5,5,6]
        i=7,nums[7]=7。队尾值为6，7>6，弹出队尾值后加入。队列：{7}。此时L=5,R=7，有效。result=[3,3,5,5,6,7]
     */
    public int[] maxSlidingWindow3(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }

        int[] ans = new int[n - k + 1];
        ans[0] = nums[deque.peekFirst()];
        for (int i = k; i < n; i++) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            while (deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            ans[i - k + 1] = nums[deque.peekFirst()];
        }
        return ans;
    }

    // 分块 + 预处理
    public int[] maxSlidingWindow4(int[] nums, int k) {
        int n = nums.length;
        int[] prefixMax = new int[n];
        int[] suffixMax = new int[n];
        for (int i = 0; i < n; i++) {
            if (i % k == 0) {
                prefixMax[i] = nums[i];
            } else {
                prefixMax[i] = Math.max(prefixMax[i - 1], nums[i]);
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            if (i == n - 1 || (i + 1) % k == 0) {
                suffixMax[i] = nums[i];
            } else {
                suffixMax[i] = Math.max(suffixMax[i + 1], nums[i]);
            }
        }

        int[] ans = new int[n - k + 1];
        for (int i = 0; i <= n - k; i++) {
            ans[i] = Math.max(suffixMax[i], prefixMax[i + k - 1]);
        }
        return ans;
    }
}
