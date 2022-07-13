package basics.d10_linkedlist;

import java.util.HashSet;
import java.util.Set;

/**
 * 142. 环形链表 II
 * https://leetcode-cn.com/problems/linked-list-cycle-ii/
 */
public class DetectCycle {
    public static void main(String[] args) {
        int[] nums = {3, 2, 0, -4};
        int pos = 1;
        ListNode head = arrayToLinkedList(nums, pos);
        ListNode res = detectCycle1(head);
        System.out.println(res.val);
    }

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

    public static ListNode detectCycle1(ListNode head) {
        Set<ListNode> isVisited = new HashSet<>();
        ListNode cur = head;
        while (cur != null) {
            if (!isVisited.add(cur)) {
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }

    public static ListNode detectCycle2(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null) {
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                return null;
            }
            if (fast == slow) {
                ListNode res = head;
                while (res != slow) {
                    res = res.next;
                    slow = slow.next;
                }
                return res;
            }
        }
        return null;
    }
}
