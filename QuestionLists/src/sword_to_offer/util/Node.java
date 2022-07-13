package sword_to_offer.util;

import java.util.HashMap;
import java.util.Map;

public class Node {
    public int val;
    public Node next;
    public Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }

    public static Node arrayToList(Integer[][] nums) {
        Map<Integer, Node> map = new HashMap<>();
        Node dummyHead = new Node(-1);
        Node prev = dummyHead;
        for (int i = 0; i < nums.length; i++) {
            prev.next = new Node(nums[i][0]);
            prev = prev.next;
            map.put(i, prev);
        }
        prev = dummyHead.next;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i][1] == null) {
                prev.random = null;
            } else {
                prev.random = map.get(nums[i][1]);
            }
            prev = prev.next;
        }
        return dummyHead.next;
    }
}
