package basics.d14_stack_queue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 155. 最小栈
 * https://leetcode-cn.com/problems/min-stack/
 */
public class MinStack {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        int param_1 = minStack.getMin();
        minStack.pop();
        int param_2 = minStack.top();
        int param_3 = minStack.getMin();

        System.out.println(param_1);
        System.out.println(param_2);
        System.out.println(param_3);
    }

    Deque<Integer> xStack;
    Deque<Integer> minStack;

    public MinStack() {
        xStack = new LinkedList<>();
        minStack = new LinkedList<>();
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int x) {
        xStack.push(x);
        minStack.push(Math.min(minStack.peek(), x));
    }

    public void pop() {
        xStack.pop();
        minStack.pop();
    }

    public int top() {
        return xStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
