package hot100;

import hot100.util.ListNode;

/**
 * 2. 两数相加
 * https://leetcode.cn/problems/add-two-numbers/
 */
public class Hot100_2_addTwoNumbers {
    public static void main(String[] args) {
        int[] nums1 = {2, 4, 3};
        int[] nums2 = {5, 6, 4};
        ListNode l1 = ListNode.arraysToList(nums1);
        ListNode l2 = ListNode.arraysToList(nums2);

        ListNode.traversal(l1);
        ListNode.traversal(l2);

        ListNode res = addTwoNumbers1(l1, l2);
        ListNode.traversal(res);

    }

    public static ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode cur = head;
        int add = 0;
        while (l1 != null || l2 != null) {
            int val1;
            int val2;
            if (l1 != null) {
                val1 = l1.val;
                l1 = l1.next;
            } else {
                val1 = 0;
            }

            if (l2 != null) {
                val2 = l2.val;
                l2 = l2.next;
            } else {
                val2 = 0;
            }

            int curValue = val1 + val2 + add;
            cur.next = new ListNode(curValue % 10);
            add = curValue / 10;
            cur = cur.next;
        }
        if (add != 0) {
            cur.next = new ListNode(add);
        }
        return head.next;
    }
}
