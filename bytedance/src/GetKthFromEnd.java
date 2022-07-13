import util.ListNode;

import java.util.Collections;

/**
 * 剑指 Offer 22. 链表中倒数第k个节点
 * https://leetcode.cn/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/
 */
public class GetKthFromEnd {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        ListNode head = ListNode.arraysToList(nums);
        int k = 2;
        GetKthFromEnd solution = new GetKthFromEnd();
        ListNode ans = solution.getKthFromEnd(head, k);
        ListNode.traversal(ans);
    }

    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode cur = head;
        for (int i = 0; i < k; i++) {
            cur = cur.next;
        }
        ListNode pre = head;
        while (cur != null) {
            pre = pre.next;
            cur = cur.next;
        }
        return pre;
    }
}
