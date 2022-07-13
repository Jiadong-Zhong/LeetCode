package introduction.d9_stack_queue;

import java.util.Stack;

/**
 * 232. 用栈实现队列
 * https://leetcode-cn.com/problems/implement-queue-using-stacks/
 */
public class MyQueue {
    public static void main(String[] args) {
        MyQueue obj = new MyQueue();
        obj.push(1);
        obj.push(2);
        obj.push(3);
        obj.push(4);
        int param_1 = obj.pop();
        obj.push(5);
        int param_2 = obj.pop();
        int param_3 = obj.pop();
        int param_4 = obj.pop();
        int param_5 = obj.pop();
        boolean param_6 = obj.empty();
        System.out.println(param_1);
        System.out.println(param_2);
        System.out.println(param_3);
        System.out.println(param_4);
        System.out.println(param_5);
        System.out.println(param_6);
    }


    public static Stack<Integer> s1;
    public static Stack<Integer> s2;

    private int front;

    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public void push(int x) {
        s1.push(x);
    }

    public void push1(int x) {
        if (s1.empty())
            front = x;
        while (!s1.isEmpty())
            s2.push(s1.pop());
        s2.push(x);
        while (!s2.isEmpty())
            s1.push(s2.pop());
    }

    public void push2(int x) {
        if (s1.empty())
            front = x;
        s1.push(x);
    }

    public int pop() {
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        int res = s2.pop();
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
        return res;
    }

    public void pop1() {
        s1.pop();
        if (!s1.empty())
            front = s1.peek();
    }

    public void pop2() {
        if (s2.isEmpty()) {
            while (!s1.isEmpty())
                s2.push(s1.pop());
        }
        s2.pop();
    }

    public int peek() {
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        int res = s2.peek();
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
        return res;
    }

    public int peek1() {
        return front;
    }

    public int peek2() {
        if (!s2.isEmpty()) {
            return s2.peek();
        }
        return front;
    }

    public boolean empty() {
        return s1.isEmpty();
    }

    public boolean empty1() {
        return s1.isEmpty();
    }

    public boolean empty2() {
        return s1.isEmpty() && s2.isEmpty();
    }
}
