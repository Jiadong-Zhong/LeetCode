package hot100;

import hot100.util.ListNode;

/**
 * 206. 反转链表
 * https://leetcode.cn/problems/reverse-linked-list/
 */
public class Hot100_60_reverseList {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        ListNode head = ListNode.arraysToList(nums);
        Hot100_60_reverseList solution = new Hot100_60_reverseList();
        ListNode ans = solution.reverseList2(head);
        ListNode.traversal(ans);
    }

    // 迭代
    public ListNode reverseList1(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    // 递归
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
