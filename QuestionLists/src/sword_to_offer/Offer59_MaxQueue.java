package sword_to_offer;

import java.util.ArrayDeque;
import java.util.Deque;

public class Offer59_MaxQueue {
    public static void main(String[] args) {

    }
}

// 使用一个队列来存放所有值
// 另外一个双向队列来维护最大值
class MaxQueue {
    Deque<Integer> q;
    Deque<Integer> d;
    public MaxQueue() {
        q = new ArrayDeque<>();
        d = new ArrayDeque<>();
    }

    public int max_value() {
        if (d.isEmpty()) {
            return -1;
        }
        return d.peekFirst();
    }

    public void push_back(int value) {
        while (!d.isEmpty() && d.peekLast() < value) {
            d.pollLast();
        }
        d.offerLast(value);
        q.offer(value);
    }

    public int pop_front() {
        if (q.isEmpty()) {
            return -1;
        }
        int ans = q.poll();
        if (ans == d.peekFirst()) {
            d.pollFirst();
        }
        return ans;
    }
}
