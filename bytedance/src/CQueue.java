import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 剑指 Offer 09. 用两个栈实现队列
 * https://leetcode.cn/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/
 */
public class CQueue {

    public static void main(String[] args) {
        CQueue cQueue = new CQueue();
        int param_1 = cQueue.deleteHead();
        cQueue.appendTail(5);
        cQueue.appendTail(2);
        int param_2 = cQueue.deleteHead();
        int param_3 = cQueue.deleteHead();
        System.out.println(param_1);
        System.out.println(param_2);
        System.out.println(param_3);
    }

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
