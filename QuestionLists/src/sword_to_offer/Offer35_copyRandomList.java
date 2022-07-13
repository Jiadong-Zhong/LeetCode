package sword_to_offer;

import sword_to_offer.util.Node;

import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer 35. 复杂链表的复制
 * https://leetcode.cn/problems/fu-za-lian-biao-de-fu-zhi-lcof/
 * 实际上就是一个深拷贝
 */
public class Offer35_copyRandomList {
    public static void main(String[] args) {
        Integer[][] nums = {{7, null}, {13, 0}, {11,4},{10,2},{1,0}};
        Node head = Node.arrayToList(nums);
        Offer35_copyRandomList solution = new Offer35_copyRandomList();
        Node ans = solution.copyRandomList1(head);

    }

    // 回溯 + 哈希表
    Map<Node, Node> cachedNode = new HashMap<>();
    public Node copyRandomList1(Node head) {
        if (head == null) {
            return null;
        }
        if (!cachedNode.containsKey(head)) {
            Node headNew = new Node(head.val);
            cachedNode.put(head, headNew);
            headNew.next = copyRandomList1(head.next);
            headNew.random = copyRandomList1(head.random);
        }
        return cachedNode.get(head);
    }

    // 迭代 + 节点拆分
    public Node copyRandomList2(Node head) {
        if (head == null) {
            return null;
        }
        // 在原表中插入新节点
        // A -> B -> C 变为
        // A -> A' -> B -> B' -> C -> C'
        for (Node node = head; node != null; node = node.next.next) {
            Node nodeNew = new Node(node.val);
            nodeNew.next = node.next;
            node.next = nodeNew;
        }
        // 连接random
        for (Node node = head; node != null; node = node.next.next) {
            Node nodeNew = node.next;
            nodeNew.random = (node.random != null) ? node.random.next : null;
        }

        Node headNew = head.next;
        // 断开与原来表的连接
        for (Node node = head; node != null; node = node.next) {
            Node nodeNew = node.next;
            node.next = node.next.next;
            nodeNew.next = (nodeNew.next != null) ? nodeNew.next.next : null;
        }
        return headNew;
    }
}
