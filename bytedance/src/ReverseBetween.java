import util.ListNode;

/**
 * 92. 反转链表 II
 * https://leetcode.cn/problems/reverse-linked-list-ii/
 */
public class ReverseBetween {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        ListNode head = ListNode.arraysToList(nums);
        int left = 2;
        int right = 4;
        ReverseBetween solution = new ReverseBetween();
        ListNode ans = solution.reverseBetween2(head, left, right);
        ListNode.traversal(ans);
    }

    // 拆链，然后反转，再接回去
    public ListNode reverseBetween1(ListNode head, int left, int right) {
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;

        ListNode pre = dummyHead;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }

        ListNode rightNode = pre;
        for (int i = 0; i < right - left + 1; i++) {
            rightNode = rightNode.next;
        }

        ListNode leftNode = pre.next;
        ListNode curr = rightNode.next;

        pre.next = null;
        rightNode.next = null;

        reverseLinkedList(leftNode);
        pre.next = rightNode;
        leftNode.next = curr;
        return dummyHead.next;
    }

    private void reverseLinkedList(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
    }

    // 一次遍历
    public ListNode reverseBetween2(ListNode head, int left, int right) {
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode prev = dummyHead;
        for (int i = 0; i < left - 1; i++) {
            prev = prev.next;
        }
        ListNode curr = prev.next;
        ListNode next;
        for (int i = 0; i < right - left; i++) {
            next = curr.next;
            curr.next = next.next;
            next.next = prev.next;
            prev.next = next;
        }
        return dummyHead.next;
    }
}
