package basics.d13_linkedlist;

/**
 * 25. K 个一组翻转链表
 * https://leetcode-cn.com/problems/reverse-nodes-in-k-group/
 */
public class ReverseKGroup {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        int k = 2;
        ListNode head = ListNode.arrayToLinkedList(nums);
        ListNode res = reverseKGroup1(head, k);
        ListNode.preOrder(res);

    }

    public static ListNode reverseKGroup1(ListNode head, int k) {
        ListNode tempHead = new ListNode();
        tempHead.next = head;
        ListNode pre = tempHead;

        while (head != null) {
            ListNode tail = pre;
            for (int i = 0; i < k; i++) {
                tail = tail.next;
                if (tail == null) {
                    return tempHead.next;
                }
            }

            ListNode next = tail.next;
            ListNode[] reverse = reverseSubList(head, tail);
            head = reverse[0];
            tail = reverse[1];

            pre.next = head;
            tail.next = next;
            pre = tail;
            head = tail.next;
        }
        return tempHead.next;
    }

    private static ListNode[] reverseSubList(ListNode head, ListNode tail) {
        ListNode cur = tail.next;
        ListNode p = head;
        while (cur != tail) {
            ListNode next = p.next;
            p.next = cur;
            cur = p;
            p = next;
        }
        return new ListNode[] {tail, head};
    }

    // 自己写的
    private static ListNode[] reverseSubList1(ListNode head, ListNode tail) {
        ListNode tempHead = new ListNode();
        tempHead.next = tail.next;

        ListNode end = tail.next;
        ListNode next;
        while (head != end) {
            next = head.next;
            head.next = tempHead.next;
            tempHead.next = head;
            head = next;
        }
        return new ListNode[] {tempHead.next, tail.next};
    }

}
