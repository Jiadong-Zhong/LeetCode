package sword_to_offer;

import hot100.util.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 剑指 Offer 06. 从尾到头打印链表
 * https://leetcode.cn/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/
 */
public class Offer06_reversePrint {
    public static void main(String[] args) {
        int[] nums = {1,3,2};
        ListNode head = ListNode.arraysToList(nums);
    }

    // 栈
    public int[] reversePrint1(ListNode head) {
        Deque<ListNode> stack = new ArrayDeque<>();
        int length = 0;
        while (head != null) {
            stack.push(head);
            length++;
            head = head.next;
        }

        int[] ans = new int[length];
        for (int i = 0; i < length; i++) {
            ans[i] = stack.pop().val;
        }
        return ans;
    }

    // 优化栈
    public int[] reversePrint2(ListNode head) {
        int length = 0;
        ListNode curr = head;
        while (curr != null) {
            length++;
            curr = curr.next;
        }

        int[] ans = new int[length];
        for (int i = length - 1; i >= 0; i--) {
            ans[i] = head.val;
            head = head.next;
        }
        return ans;
    }
}
