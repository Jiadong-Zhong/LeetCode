package hot100;

import hot100.util.ListNode;

/**
 * 21. 合并两个有序链表
 * https://leetcode.cn/problems/merge-two-sorted-lists/
 */
public class Hot100_12_mergeTwoLists {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 4};
        int[] nums2 = {1, 3, 4};
        ListNode l1 = ListNode.arraysToList(nums1);
        ListNode l2 = ListNode.arraysToList(nums2);
        ListNode res = mergeTwoLists(l1, l2);
        ListNode.traversal(res);
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode tempHead = new ListNode();
        ListNode p1 = list1;
        ListNode p2 = list2;
        ListNode cur = tempHead;
        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                cur.next = p1;
                p1 = p1.next;
            } else {
                cur.next = p2;
                p2 = p2.next;
            }
            cur = cur.next;
        }

        while (p1 != null) {
            cur.next = p1;
            p1 = p1.next;
            cur = cur.next;
        }

        while (p2 != null) {
            cur.next = p2;
            p2 = p2.next;
            cur = cur.next;
        }

        return tempHead.next;
    }

    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    public static ListNode mergeTwoLists3(ListNode l1, ListNode l2) {
        ListNode prehead = new ListNode(-1);

        ListNode prev = prehead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        // 合并后 l1 和 l2 最多只有一个还未被合并完，我们直接将链表末尾指向未合并完的链表即可
        prev.next = l1 == null ? l2 : l1;

        return prehead.next;
    }

}
