package sword_to_offer;

import hot100.util.ListNode;

/**
 * 剑指 Offer 52. 两个链表的第一个公共节点
 * https://leetcode.cn/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof/
 */
public class Offer52_getIntersectionNode {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode currA = headA;
        ListNode currB = headB;
        while (currA != currB) {
            currA = currA == null ? headB : currA.next;
            currB = currB == null ? headA : currB.next;
        }
        return currA;
    }


}
