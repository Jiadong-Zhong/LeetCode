package basics.d13_linkedlist;

public class ListNode {
    int val;
    ListNode next;

    public ListNode() {
    }

    ListNode(int x) {
        val = x;
        next = null;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode arrayToLinkedList(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        ListNode root = new ListNode(nums[0]);
        ListNode cur = root;
        for (int i = 1; i < nums.length; i++) {
            cur.next = new ListNode(nums[i]);
            cur = cur.next;
        }

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
