import java.util.HashMap;
import java.util.Map;

public class LFUCache {

    public static void main(String[] args) {
        LFUCache lfuCache = new LFUCache(2);
        lfuCache.put(1, 1);
        lfuCache.put(2, 2);
        int param1 = lfuCache.get(1);
        lfuCache.put(3,3);
        int param2 = lfuCache.get(2);
        int param3 = lfuCache.get(3);
        lfuCache.put(4,4);
        int param4 = lfuCache.get(1);
        int param5 = lfuCache.get(3);
        int param6 = lfuCache.get(4);
    }

    int minFreq, capacity;
    Map<Integer, currNode> keyTable;
    Map<Integer, DoublyLinkedList> freqTable;

    public LFUCache(int capacity) {
        this.minFreq = 0;
        this.capacity = capacity;
        keyTable = new HashMap<>();
        freqTable = new HashMap<>();
    }

    public int get(int key) {
        if (capacity == 0) {
            return -1;
        }
        if (!keyTable.containsKey(key)) {
            return -1;
        }

        currNode node = keyTable.get(key);
        int val = node.val, freq = node.freq;
        freqTable.get(freq).remove(node);
        // 如果当前链表为空，则需要在哈希表中删除，并且更新minFreq
        if (freqTable.get(freq).size == 0) {
            freqTable.remove(freq);
            if (minFreq == freq) {
                minFreq += 1;
            }
        }
        // 插入到freq + 1中
        DoublyLinkedList list = freqTable.getOrDefault(freq + 1, new DoublyLinkedList());
        list.addFirst(new currNode(key, val, freq + 1));
        freqTable.put(freq + 1, list);
        keyTable.put(key, freqTable.get(freq + 1).getHead());
        return val;
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        if (!keyTable.containsKey(key)) {
            // 缓存已满，需要进行删除
            if (keyTable.size() == capacity) {
                currNode node = freqTable.get(minFreq).getTail();
                keyTable.remove(node.key);
                freqTable.get(minFreq).remove(node);
                if (freqTable.get(minFreq).size == 0) {
                    freqTable.remove(minFreq);
                }
            }
            DoublyLinkedList list = freqTable.getOrDefault(1, new DoublyLinkedList());
            list.addFirst(new currNode(key, value, 1));
            freqTable.put(1, list);
            keyTable.put(key, freqTable.get(1).getHead());
            minFreq = 1;
        } else {
            currNode node = keyTable.get(key);
            int freq = node.freq;
            freqTable.get(freq).remove(node);
            if (freqTable.get(freq).size == 0) {
                freqTable.remove(freq);
                if (minFreq == freq) {
                    minFreq += 1;
                }
            }
            DoublyLinkedList list = freqTable.getOrDefault(freq + 1, new DoublyLinkedList());
            list.addFirst(new currNode(key, value, freq + 1));
            freqTable.put(freq + 1, list);
            keyTable.put(key, freqTable.get(freq + 1).getHead());
        }


    }
}

class currNode {
    int key, val, freq;
    currNode prev, next;

    currNode() {
        this(-1, -1, 0);
    }

    currNode(int key, int val, int freq) {
        this.key = key;
        this.val = val;
        this.freq = freq;
    }
}

class DoublyLinkedList {
    currNode dummyHead, dummyTail;
    int size;

    DoublyLinkedList() {
        dummyHead = new currNode();
        dummyTail = new currNode();
        dummyHead.next = dummyTail;
        dummyTail.prev = dummyHead;
        size = 0;
    }

    public void addFirst(currNode node) {
        currNode prevHead = dummyHead.next;
        node.prev = dummyHead;
        dummyHead.next = node;
        node.next = prevHead;
        prevHead.prev = node;
        size++;
    }

    public void remove(currNode node) {
        currNode prev = node.prev, next = node.next;
        prev.next = next;
        next.prev = prev;
        size--;
    }

    public currNode getHead() {
        return dummyHead.next;
    }

    public currNode getTail() {
        return dummyTail.prev;
    }
}
