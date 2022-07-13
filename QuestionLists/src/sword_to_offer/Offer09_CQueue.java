package sword_to_offer;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 剑指 Offer 09. 用两个栈实现队列
 * https://leetcode.cn/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/
 */
public class Offer09_CQueue {
    public static void main(String[] args) {
        CQueue obj = new CQueue();
        int param1 = obj.deleteHead();
        obj.appendTail(5);
        obj.appendTail(2);
        int param2 = obj.deleteHead();
        int param3 = obj.deleteHead();
    }
}

class CQueue {
    private Deque<Integer> inStack;
    private Deque<Integer> outStack;

    public CQueue() {
        inStack = new ArrayDeque<>();
        outStack = new ArrayDeque<>();
    }

    public void appendTail(int value) {
        inStack.push(value);
    }

    public int deleteHead() {
        if (outStack.isEmpty()) {
            if (inStack.isEmpty()) {
                return -1;
            }
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }

        }
        return outStack.pop();
    }
}
