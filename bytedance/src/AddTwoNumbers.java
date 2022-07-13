import util.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 445. 两数相加 II
 * https://leetcode.cn/problems/add-two-numbers-ii/
 */
public class AddTwoNumbers {
    public static void main(String[] args) {
        int[] nums1 = {5};
        int[] nums2 = {5};

        ListNode l1 = ListNode.arraysToList(nums1);
        ListNode l2 = ListNode.arraysToList(nums2);
        AddTwoNumbers solution = new AddTwoNumbers();
        ListNode ans = solution.addTwoNumbers1(l1, l2);
        ListNode.traversal(ans);
    }

    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        Deque<ListNode> stack1 = new ArrayDeque<>();
        Deque<ListNode> stack2 = new ArrayDeque<>();

        ListNode cur = l1;
        while (cur != null) {
            stack1.push(cur);
            cur = cur.next;
        }
        cur = l2;
        while (cur != null) {
            stack2.push(cur);
            cur = cur.next;
        }

        int add = 0;
        Deque<ListNode> stack = new ArrayDeque<>();
        while (!stack1.isEmpty() || !stack2.isEmpty() || add != 0) {
            int val1 = stack1.isEmpty() ? 0 : stack1.pop().val;
            int val2 = stack2.isEmpty() ? 0 : stack2.pop().val;
            int curVal = val1 + val2 + add;
            stack.push(new ListNode(curVal % 10));
            add = curVal / 10;
        }

        ListNode dummyHead = new ListNode();
        cur = dummyHead;
        while (!stack.isEmpty()) {
            cur.next = stack.pop();
            cur = cur.next;
        }
        return dummyHead.next;
    }

}
