package introduction.d7_linkedlist;

/**
 * 203. 移除链表元素
 * https://leetcode-cn.com/problems/remove-linked-list-elements/
 */
public class RemoveElements {
    public static void main(String[] args) {
        int[] nums = {7, 7, 7, 7};
        int val = 7;
        ListNode head = ListNode.arrayToLinkedList(nums);
        ListNode ans = removeElements2(head, val);
        ListNode.preOrder(ans);
    }

    public static ListNode removeElements1(ListNode head, int val) {
        while (head != null && head.val == val) {
            head = head.next;
        }

        if (head == null) {
            return null;
        }

        ListNode pre = head;
        while (pre.next != null) {
            if (pre.next.val == val) {
                pre.next = pre.next.next;
            } else {
                pre = pre.next;
            }
        }

        return head;
    }

    public static ListNode removeElements2(ListNode head, int val) {
        if (head == null) {
            return null;
        }

        ListNode tempHead = new ListNode();
        tempHead.next = head;
        ListNode pre = tempHead;
        while (pre.next != null) {
            if (pre.next.val == val) {
                pre.next = pre.next.next;
            } else {
                pre = pre.next;
            }
        }

        return tempHead.next;
    }
}
