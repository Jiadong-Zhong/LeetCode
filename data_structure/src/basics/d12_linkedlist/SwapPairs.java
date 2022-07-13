package basics.d12_linkedlist;

/**
 * 24. 两两交换链表中的节点
 * https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 */
public class SwapPairs {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        ListNode head = ListNode.arrayToLinkedList(nums);
        ListNode res = swapPairs1(head);
        ListNode.preOrder(res);
    }

    public static ListNode swapPairs1(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode tempHead = new ListNode();
        tempHead.next = head;

        ListNode pre = tempHead;

        while (pre.next != null && pre.next.next != null) {
            ListNode cur = pre.next;
            pre.next = cur.next;
            cur.next = cur.next.next;
            pre.next.next = cur;
            pre = cur;
        }
        return tempHead.next;
    }

    // 递归
    public ListNode swapPairs2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = head.next;
        head.next = swapPairs2(newHead.next);
        newHead.next = head;
        return newHead;
    }

}
