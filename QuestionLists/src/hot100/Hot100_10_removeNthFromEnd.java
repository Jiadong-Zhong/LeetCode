package hot100;

import hot100.util.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 19. 删除链表的倒数第 N 个结点
 * https://leetcode.cn/problems/remove-nth-node-from-end-of-list/
 */
public class Hot100_10_removeNthFromEnd {
    public static void main(String[] args) {
        int[] nums = {1};
        ListNode head = ListNode.arraysToList(nums);
        int n = 1;
        ListNode res = removeNthFromEnd2(head, n);
        ListNode.traversal(res);

    }

    public static ListNode removeNthFromEnd1(ListNode head, int n) {
        int count = 0;
        ListNode tempHead = new ListNode();
        tempHead.next = head;

        ListNode cur = head;
        while (cur != null) {
            cur = cur.next;
            count++;
        }

        cur = tempHead;
        for (int i = 1; i < count - n + 1; i++) {
            cur = cur.next;
        }

        cur.next = cur.next.next;
        return tempHead.next;
    }

    public static ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode tempHead = new ListNode();
        tempHead.next = head;

        Deque<ListNode> stack = new ArrayDeque<>();
        ListNode cur = tempHead;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }

        for (int i = 0; i < n; i++) {
            stack.pop();
        }
        ListNode prev = stack.peek();
        prev.next = prev.next.next;
        return tempHead.next;
    }

    public static ListNode removeNthFromEnd3(ListNode head, int n) {
        ListNode tempHead = new ListNode();
        tempHead.next = head;

        ListNode first = head;
        ListNode second = tempHead;

        for (int i = 0; i < n; i++) {
            first = first.next;
        }

        while (first != null) {
            first = first.next;
            second = second.next;
        }

        second.next = second.next.next;
        return tempHead.next;
    }
}
