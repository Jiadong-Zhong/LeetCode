package introduction.d8_linkedlist;

/**
 * 206. 反转链表
 * https://leetcode-cn.com/problems/reverse-linked-list/
 */
public class ReverseList {
    public static void main(String[] args) {
        int[] head = {1, 2, 3, 4, 5};
        ListNode root = ListNode.arrayToLinkedList(head);
        ListNode res = reverseList1(root);
        ListNode.preOrder(res);
    }

    public static ListNode reverseList1(ListNode head) {
        ListNode tempHead = new ListNode();

        ListNode next;
        while (head != null) {
            next = head.next;
            head.next = tempHead.next;
            tempHead.next = head;
            head = next;
        }
        return tempHead.next;
    }
}
