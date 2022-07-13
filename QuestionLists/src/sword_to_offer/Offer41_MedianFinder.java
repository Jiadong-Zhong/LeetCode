package sword_to_offer;

import java.lang.reflect.Array;
import java.util.*;

/**
 * 剑指 Offer 41. 数据流中的中位数
 * https://leetcode.cn/problems/shu-ju-liu-zhong-de-zhong-wei-shu-lcof/
 */
public class Offer41_MedianFinder {
    public static void main(String[] args) {

    }
}

// 创建list，每次取中位数进行排序
class MedianFinder1 {
    List<Integer> nums;

    public MedianFinder1() {
        nums = new ArrayList<>();
    }

    public void addNum(int num) {
        nums.add(num);
    }

    public double findMedian() {
        Collections.sort(nums);
        int len = nums.size();
        if (len % 2 == 1) {
            return nums.get(len / 2);
        } else {
            int val1 = nums.get(len / 2);
            int val2 = nums.get(len / 2 - 1);
            return (val1 + val2) / 2.0;
        }
    }
}

// 堆
class MedianFinder2{
    PriorityQueue<Integer> A,B;

    public MedianFinder2() {
        A = new PriorityQueue<>(); // 小顶堆，保存较大的一半
        B = new PriorityQueue<>((o1, o2) -> o2 - o1); // 大顶堆，保存较小的一半
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
