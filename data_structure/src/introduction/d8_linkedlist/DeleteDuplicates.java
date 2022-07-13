package introduction.d8_linkedlist;

public class DeleteDuplicates {
    public static void main(String[] args) {
        int[] head = {};
        ListNode root = ListNode.arrayToLinkedList(head);
        ListNode res = deleteDuplicates1(root);
        ListNode.preOrder(res);
    }

    public static ListNode deleteDuplicates1(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = head;
        while (pre.next != null) {
            if (pre.val == pre.next.val) {
                pre.next = pre.next.next;
            } else {
                pre = pre.next;
            }
        }
        return head;
    }
}
