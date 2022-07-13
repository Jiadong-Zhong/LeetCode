package hot100;

import hot100.util.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 142. 环形链表 II
 * https://leetcode.cn/problems/linked-list-cycle-ii/
 */
public class Hot100_51_detectCycle {
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
        ListNode head = arrayToLinkedList(nums, 1);
        Hot100_51_detectCycle solution = new Hot100_51_detectCycle();
        ListNode listNode = solution.detectCycle2(head);
        System.out.println(listNode.val);
    }

    // 迭代+哈希
    public ListNode detectCycle1(ListNode head) {
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

    // 快慢指针
    public ListNode detectCycle2(ListNode head) {
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
                ListNode ptr = head;
                while (ptr != slow) {
                    ptr = ptr.next;
                    slow = slow.next;
                }
                return ptr;
            }
        }
        return null;
    }
}
