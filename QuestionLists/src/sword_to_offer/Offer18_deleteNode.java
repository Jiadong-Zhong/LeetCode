package sword_to_offer;

import hot100.util.ListNode;

/**
 * 剑指 Offer 18. 删除链表的节点
 * https://leetcode.cn/problems/shan-chu-lian-biao-de-jie-dian-lcof/
 */
public class Offer18_deleteNode {
    public static void main(String[] args) {
        int[] nums = {4,5,1,9};
        ListNode head = ListNode.arraysToList(nums);
        int val = 5;
        Offer18_deleteNode solution = new Offer18_deleteNode();
        ListNode ans = solution.deleteNode(head, val);
        ListNode.traversal(ans);
    }

    public ListNode deleteNode(ListNode head, int val) {
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;

        ListNode prev = dummyHead;
        while (prev.next != null) {
            if (prev.next.val == val) {
                prev.next = prev.next.next;
                break;
            }
            prev = prev.next;
        }
        return dummyHead.next;
    }
}
