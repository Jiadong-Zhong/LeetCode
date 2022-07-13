package introduction.d7_linkedlist;

import java.util.HashSet;
import java.util.Set;

/**
 * 141. 环形链表
 * https://leetcode-cn.com/problems/linked-list-cycle/
 */
public class HasCycle {
    public static void main(String[] args) {
        int[] nums = {-21,10,17,8,4,26,5,35,33,-7,-16,27,-12,6,29,-12,5,9,20,14,14,2,13,-24,21,23,-21,5};
        int pos = -1;
        ListNode root = arrayToLinkedList(nums, pos);
        // preOrder(root);
        boolean ans = hasCycle1(root);
        System.out.println(ans);
    }

    public static boolean hasCycle1(ListNode head) {
        Set<ListNode> isVisited = new HashSet<>();
        ListNode cur = head;
        while (cur != null) {
            if (!isVisited.add(cur)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
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

    public static void preOrder(ListNode root) {
        if (root == null) {
            return;
        }

        ListNode cur = root;
        System.out.println(cur.val);
        while (cur.next != null) {
            cur = cur.next;
            System.out.println(cur.val);
        }
    }
}
