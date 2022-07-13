package sword_to_offer;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 剑指 Offer 31. 栈的压入、弹出序列
 * https://leetcode.cn/problems/zhan-de-ya-ru-dan-chu-xu-lie-lcof/
 */
public class Offer31_validateStackSequences {
    public static void main(String[] args) {
        int[] pushed = {1,2,3,4,5};
        int[] popped = {4,5,3,2,1};
        Offer31_validateStackSequences solution = new Offer31_validateStackSequences();
        boolean ans = solution.validateStackSequences1(pushed, popped);
        System.out.println(ans);
    }

    // 自己写的，是一直push直到不匹配pop
    public boolean validateStackSequences1(int[] pushed, int[] popped) {
        int pushIndex = 0;
        int popIndex = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        while (popIndex < popped.length) {
            while (stack.isEmpty() || popped[popIndex] != stack.peek()) {
                if (pushIndex == pushed.length) {
                    return false;
                }
                stack.push(pushed[pushIndex++]);
            }
            stack.pop();
            popIndex++;
        }
        return true;
    }

    // 题解，是一直pop直到不匹配push
    public boolean validateStackSequence2(int[] pushed, int[] popped) {
        Deque<Integer> stack = new ArrayDeque<>();
        int popIndex = 0;
        for (int num : pushed) {
            stack.push(num);
            while (!stack.isEmpty() && stack.peek() == popped[popIndex]) {
                stack.pop();
                popIndex++;
            }
        }
        return stack.isEmpty();
    }
}
