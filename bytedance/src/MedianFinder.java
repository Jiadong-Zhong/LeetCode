import java.util.PriorityQueue;

/**
 * 295. 数据流的中位数
 * https://leetcode.cn/problems/find-median-from-data-stream/
 */
public class MedianFinder {


    PriorityQueue<Integer> A, B;

    public MedianFinder() {
        A = new PriorityQueue<>();
        B = new PriorityQueue<>((o1, o2) -> o2 - o1);
    }

    public void addNum(int num) {
        if (A.size() != B.size()) {
            A.add(num);
            B.add(A.poll());
        } else {
            B.add(num);
            A.add(B.poll());
        }
    }

    public double findMedian() {
        return A.size() != B.size() ? A.peek() : (A.peek() + B.peek()) / 2.0;
    }
}
