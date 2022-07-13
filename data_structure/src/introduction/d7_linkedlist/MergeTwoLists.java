package introduction.d7_linkedlist;

/**
 * 21. 合并两个有序链表
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/
 */
public class MergeTwoLists {
    public static void main(String[] args) {
        int[] l1 = {1, 2, 4};
        int[] l2 = {1, 3, 4};
        ListNode root1 = ListNode.arrayToLinkedList(l1);
        ListNode root2 = ListNode.arrayToLinkedList(l2);

        ListNode root = mergeTwoLists1(root1, root2);
        ListNode.preOrder(root);

    }

    public static ListNode mergeTwoLists1(ListNode list1, ListNode list2) {
        ListNode head = new ListNode();
        ListNode t = head;
        while(list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                t.next = list1;
                list1 = list1.next;
            } else {
                t.next = list2;
                list2 = list2.next;
            }
            t = t.next;
        }

        if (list1 != null) {
            t.next = list1;
        }
        if (list2 != null) {
            t.next = list2;
        }
        return head.next;
    }


}
