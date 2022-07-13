package hot100;

import hot100.util.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 160. 相交链表
 * https://leetcode.cn/problems/intersection-of-two-linked-lists/
 */
public class Hot100_56_getIntersectionNode {

    public static ListNode[] arrayToLinkedList(int[] nums1, int[] nums2, int skipA, int skipB, int intersectVal) {
        if (nums1 == null || nums1.length == 0) {
            return null;
        }
        if (nums2 == null || nums2.length == 0) {
            return null;
        }

        ListNode head1 = new ListNode(nums1[0]);
        ListNode head2 = new ListNode(nums2[0]);
        ListNode cur1 = head1;
        ListNode cur2 = head2;
        for (int i = 1; i < nums1.length; i++) {
            cur1.next = new ListNode(nums1[i]);
            if (cur1.next.val == intersectVal) {
                break;
            }
            cur1 = cur1.next;

        }

        for (int i = 1; i < nums2.length; i++) {
            cur2.next = new ListNode(nums2[i]);
            if (cur2.next.val == intersectVal) {
                break;
            }
            cur2 = cur2.next;

        }

        if (skipA < nums1.length && skipB < nums1.length && nums1[skipA] == intersectVal && nums2[skipB] == intersectVal) {
            ListNode newNode = new ListNode(nums1[skipA]);
            cur1.next = newNode;
            cur2.next = newNode;
            cur1 = cur1.next;

            for (int i = 1; i < nums1.length - skipA; i++) {
                cur1.next = new ListNode(nums1[skipA + i]);
                cur1 = cur1.next;
            }
        }

        ListNode[] res = new ListNode[2];
        res[0] = head1;
        res[1] = head2;
        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = {4,1,8,4,5};
        int[] nums2 = {5,6,1,8,4,5};
        int skipA = 2;
        int skipB = 3;
        int intersectVal = 8;
        ListNode[] heads = arrayToLinkedList(nums1, nums2, skipA, skipB, intersectVal);
        ListNode headA = heads[0];
        ListNode headB = heads[1];

        Hot100_56_getIntersectionNode solution = new Hot100_56_getIntersectionNode();
        ListNode res = solution.getIntersectionNode1(headA, headB);
        if (res != null) {
            System.out.println(res.val);
        } else {
            System.out.println("null");
        }
    }

    // 哈希集合，时间复杂度为O(m + n) 空间为 O(m)
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        Set<ListNode> isVisited = new HashSet<>();
        ListNode currA = headA;
        ListNode currB = headB;
        while (currA != null) {
            isVisited.add(currA);
            currA = currA.next;
        }
        while (currB != null) {
            if (isVisited.contains(currB)) {
                return currB;
            } else {
                currB = currB.next;
            }
        }
        return null;
    }

    // 双指针
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }
}
