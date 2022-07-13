package basics.d10_linkedlist;

/**
 * 2. 两数相加
 * https://leetcode-cn.com/problems/add-two-numbers/
 */
public class AddTwoNumbers {
    public static void main(String[] args) {
        int[] nums1 = {9,9,9,9,9,9,9};
        int[] nums2 = {9,9,9,9};
        ListNode l1 = ListNode.arrayToLinkedList(nums1);
        ListNode l2 = ListNode.arrayToLinkedList(nums2);
        ListNode res = addTwoNumbers1(l1, l2);
        ListNode.preOrder(res);
    }

    public static ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        ListNode l = new ListNode();
        ListNode curNode = l;
        int add = 0;
        while (l1 != null && l2 != null) {
            int cur = add + l1.val + l2.val;
            add = cur / 10;
            curNode.next = new ListNode(cur % 10);
            curNode = curNode.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            int cur = add + l1.val;
            add = cur / 10;
            curNode.next = new ListNode(cur % 10);
            curNode = curNode.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            int cur = add + l2.val;
            add = cur / 10;
            curNode.next = new ListNode(cur % 10);
            curNode = curNode.next;
            l2 = l2.next;
        }
        if (add != 0) {
            curNode.next = new ListNode(add);
        }
        return l.next;
    }

    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode head = null, tail = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            int sum = n1 + n2 + carry;
            if (head == null) {
                head = tail = new ListNode(sum % 10);
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            carry = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            tail.next = new ListNode(carry);
        }
        return head;
    }
}
