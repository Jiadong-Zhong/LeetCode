package sword_to_offer;

import hot100.util.ListNode;

/**
 * 剑指 Offer 25. 合并两个排序的链表
 * https://leetcode.cn/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof/
 */
public class Offer25_mergeTwoLists {
    public static void main(String[] args) {
        int[] nums1 = {1,2,4};
        int[] nums2 = {1,3,4};
        ListNode l1 = ListNode.arraysToList(nums1);
        ListNode l2 = ListNode.arraysToList(nums2);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode();
        ListNode curr = dummyHead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        curr.next = l1 == null ? l2 : l1;
        return dummyHead.next;
    }
}
