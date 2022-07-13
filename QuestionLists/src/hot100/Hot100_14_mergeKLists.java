package hot100;

import hot100.util.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 23. 合并K个升序链表
 * https://leetcode.cn/problems/merge-k-sorted-lists/
 */
public class Hot100_14_mergeKLists {
    public static void main(String[] args) {
        int[][] nums = {{1,4,5}, {1,3,4}, {2,6}};
        ListNode[] lists = ListNode.arraysToList(nums);
        ListNode res = mergeKLists2(lists);
        ListNode.traversal(res);
    }

    // 顺序合并
    public static ListNode mergeKLists1(ListNode[] lists) {
        ListNode ans = null;
        for (ListNode list : lists) {
            ans = mergeTwoLists(list, ans);
        }
        return ans.next;
    }

    // 分治
    public static ListNode mergeKLists2(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }

    public static ListNode merge(ListNode[] lists, int left, int right) {
        if (left == right) {
            return lists[left];
        }
        if (left > right) {
            return null;
        }
        int mid = (left + right) / 2;
        ListNode leftNode = merge(lists, left, mid);
        ListNode rightNode = merge(lists, mid + 1, right);
        return mergeTwoLists(leftNode, rightNode);
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode prehead = new ListNode(-1);

        ListNode prev = prehead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        // 合并后 l1 和 l2 最多只有一个还未被合并完，我们直接将链表末尾指向未合并完的链表即可
        prev.next = l1 == null ? l2 : l1;

        return prehead.next;
    }

    // 优先队列
    static PriorityQueue<ListNode> queue = new PriorityQueue<>((Comparator.comparingInt(o -> o.val)));
    public static ListNode mergeKLists3(ListNode[] lists) {
        for (ListNode node : lists) {
            if (node != null) {
                queue.offer(node);
            }
        }
        ListNode head = new ListNode();
        ListNode tail = head;
        while (!queue.isEmpty()) {
            ListNode cur = queue.poll();
            tail.next = cur;
            tail = tail.next;
            if (cur.next != null) {
                queue.offer(cur.next);
            }
        }
        return head.next;
    }
}
