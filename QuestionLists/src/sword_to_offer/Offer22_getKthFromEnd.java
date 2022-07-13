package sword_to_offer;

import hot100.util.ListNode;

/**
 * 剑指 Offer 22. 链表中倒数第k个节点
 * https://leetcode.cn/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/
 */
public class Offer22_getKthFromEnd {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        ListNode head = ListNode.arraysToList(nums);
    }

    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode curr = head;
        for (int i = 0; i < k; i++) {
            curr = curr.next;
        }
        ListNode prev = head;
        while (curr != null) {
            prev = prev.next;
            curr = curr.next;
        }
        return prev;
    }
}
