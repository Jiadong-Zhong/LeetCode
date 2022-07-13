import util.ListNode;

/**
 * 剑指 Offer 24. 反转链表
 * https://leetcode.cn/problems/fan-zhuan-lian-biao-lcof/
 */
public class ReverseList {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        ListNode head = ListNode.arraysToList(nums);
        ReverseList solution = new ReverseList();
        ListNode ans = solution.reverseList(head);
        ListNode.traversal(ans);
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
