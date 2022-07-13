import util.ListNode;

/**
 * 328. 奇偶链表
 * https://leetcode.cn/problems/odd-even-linked-list/
 */
public class OddEvenList {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        ListNode head = ListNode.arraysToList(nums);

    }

    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode evenHead = head.next;
        ListNode odd = head, even = evenHead;
        while(even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = evenHead.next;
        }
        odd.next = evenHead;
        return head;
    }
}
