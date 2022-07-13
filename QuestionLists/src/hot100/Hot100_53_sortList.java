package hot100;

import hot100.util.ListNode;

/**
 * 148. 排序链表
 * https://leetcode.cn/problems/sort-list/
 */
public class Hot100_53_sortList {
    public static void main(String[] args) {
        int[] nums = {-1, 5, 3, 4, 0};
        ListNode head = ListNode.arraysToList(nums);
        Hot100_53_sortList solution = new Hot100_53_sortList();
        ListNode ans = solution.sortList2(head);
        ListNode.traversal(ans);
    }

    // 自顶向下归并
    public ListNode sortList1(ListNode head) {
        return sortList1(head, null);
    }

    public ListNode sortList1(ListNode head, ListNode tail) {
        if (head == null) {
            return head;
        }
        if (head.next == tail) {
            head.next = null;
            return head;
        }

        // 快慢指针找到中点
        ListNode slow = head, fast = head;
        while (fast != tail) {
            slow = slow.next;
            fast = fast.next;
            if (fast != tail) {
                fast = fast.next;
            }
        }
        // 对中点左右两个子链表排序再合并
        ListNode mid = slow;
        ListNode list1 = sortList1(head, mid);
        ListNode list2 = sortList1(mid, tail);
        return merge(list1, list2);
    }

    private ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummyHead = new ListNode();
        ListNode temp = dummyHead, temp1 = head1, temp2 = head2;
        while (temp1 != null && temp2 != null) {
            if (temp1.val <= temp2.val) {
                temp.next = temp1;
                temp1 = temp1.next;
            } else {
                temp.next = temp2;
                temp2 = temp2.next;
            }
            temp = temp.next;
        }
        if (temp1 != null) {
            temp.next = temp1;
        } else if (temp2 != null) {
            temp.next = temp2;
        }
        return dummyHead.next;
    }

    // 自底向上归并
    public ListNode sortList2(ListNode head) {
        if (head == null) {
            return head;
        }

        // 统计长度
        int length = 0;
        ListNode node = head;
        while (node != null) {
            length++;
            node = node.next;
        }
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;

        for (int subLength = 1; subLength < length; subLength <<= 1) {
            ListNode prev = dummyHead, curr = dummyHead.next;
            while (curr != null) {
                // 寻找第一个长度为subLength的子链表
                ListNode head1 = curr;
                for (int i = 1; i < subLength && curr.next != null; i++) {
                    curr = curr.next;
                }
                ListNode head2 = curr.next;
                curr.next = null;

                // 寻找第二个长度为subLength的子链表
                curr = head2;
                for (int i = 1; i < subLength && curr != null && curr.next != null; i++) {
                    curr = curr.next;
                }

                // 记录第二个子链表的后继节点
                ListNode next = null;
                if (curr != null) {
                    next = curr.next;
                    curr.next = null;
                }
                // 合并两个链表，并将前驱指针移动到合并后的链表末尾
                prev.next = merge(head1, head2);
                while (prev.next != null) {
                    prev = prev.next;
                }
                // 移动当前指针到后继节点
                curr = next;
            }
        }
        return dummyHead.next;
    }
}
