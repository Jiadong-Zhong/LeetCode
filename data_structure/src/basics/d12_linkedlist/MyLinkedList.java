package basics.d12_linkedlist;

/**
 * 707. 设计链表
 * https://leetcode-cn.com/problems/design-linked-list/
 */
public class MyLinkedList {
    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtIndex(0, 10);
        linkedList.addAtIndex(0, 20);
        linkedList.addAtIndex(1, 30);
        int param_1 = linkedList.get(1);
        linkedList.preOder();
        int param_2 = linkedList.get(0);
    }

    int size;
    MyListNode head;

    public MyLinkedList() {
        size = 0;
        head = new MyListNode();
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }

        MyListNode cur = head;
        for (int i = 0; i < index + 1; i++) {
            cur = cur.next;
        }
        return cur.val;
    }

    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }

        if (index < 0) {
            index = 0;
        }

        size++;
        MyListNode pre = head;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }

        MyListNode newNode = new MyListNode(val);
        newNode.next = pre.next;
        pre.next = newNode;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }

        size--;
        MyListNode pre = head;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }

        pre.next = pre.next.next;
    }

    public void preOder() {
        MyListNode.preOrder(head);
    }
}

class MyListNode {
    public int val;
    public MyListNode next;

    public MyListNode() {
    }

    public MyListNode(int val) {
        this.val = val;
        this.next = null;
    }

    public MyListNode(int val, MyListNode next) {
        this.val = val;
        this.next = next;
    }

    public static void preOrder(MyListNode root) {
        if (root == null) {
            return;
        }

        MyListNode cur = root;
        System.out.println(cur.val);
        while (cur.next != null) {
            cur = cur.next;
            System.out.println(cur.val);
        }
    }
}
