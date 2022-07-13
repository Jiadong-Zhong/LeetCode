package basics.d11_linkedlist;

import java.util.HashSet;
import java.util.Set;

/**
 * 160. 相交链表
 * https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
 */
public class GetIntersectionNode {
    public static void main(String[] args) {
        int[] nums1 = {4,1,8,4,5};
        int[] nums2 = {5,6,1,8,4,5};
        int skipA = 2;
        int skipB = 3;
        int intersectVal = 8;
        ListNode[] roots = arrayToLinkedList(nums1, nums2, skipA, skipB, intersectVal);
        ListNode rootA = roots[0];
        ListNode rootB = roots[1];
        ListNode.preOrder(rootA);
        System.out.println();
        ListNode.preOrder(rootB);


        ListNode res = getIntersectionNode1(rootA, rootB);
        if (res != null) {
            System.out.println(res.val);
        } else {
            System.out.println("null");
        }
    }

    public static ListNode[] arrayToLinkedList(int[] nums1, int[] nums2, int skipA, int skipB, int intersectVal) {
        if (nums1 == null || nums1.length == 0) {
            return null;
        }
        if (nums2 == null || nums2.length == 0) {
            return null;
        }

        ListNode root1 = new ListNode(nums1[0]);
        ListNode root2 = new ListNode(nums2[0]);
        ListNode cur1 = root1;
        ListNode cur2 = root2;
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
        res[0] = root1;
        res[1] = root2;
        return res;
    }

    public static ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        Set<ListNode> isVisited = new HashSet<>();
        ListNode cur1 = headA;
        ListNode cur2 = headB;

        while (cur1 != null || cur2 != null) {
            if (cur1 != null) {
                if (!isVisited.add(cur1)) {
                    return cur1;
                }
                cur1 = cur1.next;
            }

            if (cur2 != null) {
                if (!isVisited.add(cur2)) {
                    return cur2;
                }
                cur2 = cur2.next;
            }
        }
        return null;
    }

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
