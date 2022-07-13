package basics.d11_linkedlist;

/**
 * 82. 删除排序链表中的重复元素 II
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/
 */
public class DeleteDuplicates {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 3, 4, 4, 5};
        ListNode head = ListNode.arrayToLinkedList(nums);
        ListNode res = deleteDuplicates1(head);
        ListNode.preOrder(res);
    }

    public static ListNode deleteDuplicates1(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode tempHead = new ListNode();
        tempHead.next = head;

        ListNode cur = tempHead;
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                int x = cur.next.val;
                while (cur.next != null && cur.next.val == x) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }
        return tempHead.next;
    }
}
