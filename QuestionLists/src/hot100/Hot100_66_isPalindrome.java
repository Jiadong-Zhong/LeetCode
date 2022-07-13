package hot100;

import hot100.util.ListNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 234. 回文链表
 * https://leetcode.cn/problems/palindrome-linked-list/
 */
public class Hot100_66_isPalindrome {
    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 1};
        ListNode head = ListNode.arraysToList(nums);
        Hot100_66_isPalindrome solution = new Hot100_66_isPalindrome();
        boolean ans = solution.isPalindrome1(head);
        System.out.println(ans);
    }

    // 自己写的，用栈来操作，先把所有元素都入栈，然后逐个比较
    // 时间复杂度为O(n) 第一次入栈需要O(n) 比较时候需要O(n / 2)，合起来还是O(n)
    // 空间复杂度为O(n)
    public boolean isPalindrome1(ListNode head) {
        Deque<ListNode> stack = new ArrayDeque<>();
        ListNode cur = head;
        int length = 0;
        while (cur != null) {
            stack.push(cur);
            length++;
            cur = cur.next;
        }
        cur = head;
        for (int i = 0; i < length / 2; i++) {
            if (cur.val != stack.pop().val) {
                return false;
            }
            cur = cur.next;
        }
        return true;
    }

    // 将值复制到数组中后再进行比较，整体上和自己写的差不多
    public boolean isPalindrome2(ListNode head) {
        List<Integer> val = new ArrayList<>();

        ListNode curr = head;
        while (curr != null) {
            val.add(curr.val);
            curr = curr.next;
        }

        // 用双指针判断是否回文
        int front = 0;
        int back = val.size() - 1;
        while (front < back) {
            if (!val.get(front).equals(val.get(back))) {
                return false;
            }
            front++;
            back--;
        }
        return true;
    }

    // 递归，和自己写的栈差不多，这个使用了递归的栈
    private ListNode frontPointer;
    public boolean isPalindrome3(ListNode head) {
        frontPointer = head;
        return recursivelyCheck(head);
    }

    private boolean recursivelyCheck(ListNode curr) {
        if (curr != null) {
            if (!recursivelyCheck(curr.next)) {
                return false;
            }
            return curr.val == frontPointer.val;
        }
        return true;
    }

    // 快慢指针
    public boolean isPalindrome4(ListNode head) {
        if (head == null) {
            return true;
        }

        // 找到前半部分的尾节点并反转后半部分链表
        ListNode firstHalfEnd = endOfFirstHalf(head);
        ListNode secondHalfStart = reverseList(firstHalfEnd.next);

        // 判断是否回文
        ListNode p1 = head;
        ListNode p2 = secondHalfStart;
        boolean result = true;
        while (result && p2 != null) {
            if (p1.val != p2.val) {
                result = false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        // 还原链表并返回
        firstHalfEnd.next = reverseList(secondHalfStart);
        return result;
    }

    private ListNode reverseList(ListNode head) {
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

    private ListNode endOfFirstHalf(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
