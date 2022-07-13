package sword_to_offer;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 剑指 Offer 30. 包含min函数的栈
 * https://leetcode.cn/problems/bao-han-minhan-shu-de-zhan-lcof/
 */
public class Offer30_MinStack {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        int param1 = minStack.min();
        minStack.pop();
        int param2 = minStack.top();
        int param3 = minStack.min();
    }
}

class MinStack {

    Deque<Integer> minStack;
    Deque<Integer> stack;

    public MinStack() {
        minStack = new ArrayDeque<>();
        stack = new ArrayDeque<>();
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int x) {
        stack.push(x);
        minStack.push(Math.min(minStack.peek(), x));
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}
