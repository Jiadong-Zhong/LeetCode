package hot100;

import java.util.HashMap;
import java.util.Map;

/**
 * 146. LRU 缓存
 * https://leetcode.cn/problems/lru-cache/
 * 哈希表查找时间复杂度为1
 */
public class Hot100_52_LRUCache {
    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1,1);
        lruCache.put(2,2);
        int param_1 = lruCache.get(1);
        lruCache.put(3,3);
        int param_2 = lruCache.get(2);
        lruCache.put(4,4);
        int param_3 = lruCache.get(1);
        int param_4 = lruCache.get(3);
        int param_5 = lruCache.get(4);
    }
}

class LRUCache{
    class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;

        public DLinkedNode() {
        }

        public DLinkedNode(int _key, int _value) {
            key = _key;
            value = _value;
        }
    }

    // 通过缓存数据的键映射到双向链表中的位置
    private Map<Integer, DLinkedNode> cache = new HashMap<>();
    private int size;
    private int capacity;
    // 双向链表按照使用顺序存储键值对，靠近头部是最近使用，尾部是最久未使用
    private DLinkedNode head, tail;


    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        // 如果key存在，通过哈希表定位，再移到头部
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            // 如果key不存在，创建一个新节点
            DLinkedNode newNode = new DLinkedNode(key, value);
            // 添加进哈希表
            cache.put(key, newNode);
            // 添加到双向链表头部
            addToHead(newNode);
            size++;
            if (size > capacity) {
                // 如果超出容量，删除双向链表尾部节点
                DLinkedNode tail = removeTail();
                // 删除哈希表对应的项
                cache.remove(tail.key);
                size--;
            }
        } else {
            // 如果key存在，先通过哈希表定位，再修改value，并移动到头部
            node.value = value;
            moveToHead(node);
        }
    }

    private void addToHead(DLinkedNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    private DLinkedNode removeTail() {
        DLinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }
}
