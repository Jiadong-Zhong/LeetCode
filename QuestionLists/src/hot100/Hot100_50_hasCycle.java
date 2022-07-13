package hot100;

import hot100.util.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 141. 环形链表
 * https://leetcode.cn/problems/linked-list-cycle/
 */
public class Hot100_50_hasCycle {
    public static ListNode arrayToLinkedList(int[] nums, int pos) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        ListNode root = new ListNode(nums[0]);
        ListNode cur = root;
        ListNode posNode = null;
        for (int i = 1; i < nums.length; i++) {
            cur.next = new ListNode(nums[i]);
            cur = cur.next;
            if (i == pos) {
                posNode = cur;
            }
        }
        cur.next = posNode;

        return root;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,0,-4};
        int pos = 1;
        ListNode head = arrayToLinkedList(nums, pos);
        Hot100_50_hasCycle solution = new Hot100_50_hasCycle();
        boolean ans = solution.hasCycle(head);
        System.out.println(ans);
    }

    public boolean hasCycle(ListNode head) {
        Set<ListNode> isVisited = new HashSet<>();
        while (head != null) {
            if (isVisited.contains(head)) {
                return true;
            }
            isVisited.add(head);
            head = head.next;
        }
        return false;
    }
}
