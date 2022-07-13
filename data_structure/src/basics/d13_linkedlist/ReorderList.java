package basics.d13_linkedlist;

import java.util.ArrayList;
import java.util.List;

public class ReorderList {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        ListNode head = ListNode.arrayToLinkedList(nums);
        reorderList4(head);
        ListNode.preOrder(head);
    }

    public static void reorderList1(ListNode head) {
        ListNode cur = head;
        while (cur.next != null) {
            ListNode tail = cur;
            while (tail.next.next != null) {
                tail = tail.next;
            }
            if (tail == cur) {
                break;
            }
            tail.next.next = cur.next;
            cur.next = tail.next;
            tail.next = null;
            cur = cur.next.next;
        }
    }

    public static void reorderList2(ListNode head) {
        if (head == null) {
            return;
        }
        List<ListNode> list = new ArrayList<>();
        ListNode node = head;
        while (node != null) {
            list.add(node);
            node = node.next;
        }
        int i = 0, j = list.size() - 1;
        while (i < j) {
            list.get(i).next = list.get(j);
            i++;
            if (i == j) {
                break;
            }
            list.get(j).next = list.get(i);
            j--;
        }
        list.get(i).next = null;
    }

    public static void reorderList3(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode mid = middleNode(head);
        ListNode l1 = head;
        ListNode l2 = mid.next;
        mid.next = null;
        l2 = reverseList(l2);
        mergeList(l1, l2);
    }

    public static ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    public static void mergeList(ListNode l1, ListNode l2) {
        ListNode l1_tmp;
        ListNode l2_tmp;
        while (l1 != null && l2 != null) {
            l1_tmp = l1.next;
            l2_tmp = l2.next;

            l1.next = l2;
            l1 = l1_tmp;

            l2.next = l1;
            l2 = l2_tmp;
        }
    }

    // 递归方法
    public static void reorderList4(ListNode head) {
        reorderList(head, head);
    }

    public static ListNode reorderList(ListNode head, ListNode tail) {
        // 如果tail为null，说明已经递归到链表尾部，这时候需要重新连接尾部节点与头部节点，需要返回head
        if (tail == null) {
            return head;
        }
        // 一直递归到尾部
        ListNode returnNode = reorderList(head, tail.next);
        // 回溯到方法，returnNode即为与tail对应的正向访问节点
        // 如果为null，说明处理完成，直接返回
        if (returnNode == null) {
            return null;
        }
        // 如果returnNode或returnNode的后继等于tail，说明完成，注意tail即为尾节点，next需要set null
        if (returnNode == tail || returnNode.next == tail) {
            tail.next = null;
            return null;
        }

        // 将尾部遍历节点指向对应的头部遍历节点的next，正向节点指向尾部遍历节点
        tail.next = returnNode.next;
        returnNode.next = tail;
        // 返回头部向后访问的下一节点
        return tail.next;
    }
}
