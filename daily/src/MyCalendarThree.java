import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * 732. 我的日程安排表 III
 * https://leetcode.cn/problems/my-calendar-iii/
 * 线段树没怎么看明白
 */
public class MyCalendarThree {
    public static void main(String[] args) {
        MyCalendarThree2 myCalendarThree2 = new MyCalendarThree2();
        int param_1 = myCalendarThree2.book(10, 20);
        int param_2 = myCalendarThree2.book(50, 60);
        int param_3 = myCalendarThree2.book(10, 40);
        int param_4 = myCalendarThree2.book(5, 15);
        int param_5 = myCalendarThree2.book(5, 10);
        int param_6 = myCalendarThree2.book(25, 55);
        System.out.println(param_1);
        System.out.println(param_2);
        System.out.println(param_3);
        System.out.println(param_4);
        System.out.println(param_5);
        System.out.println(param_6);

    }
}

// 差分数组, 利用start和end计数
// 在TreeMap中元素是有序的，从小到大顺序排列
// 基于红黑树实现
// 红黑树的时间复杂度为O(log n)，因此TreeMap的时间复杂度为O(log n)
class MyCalendarThree1 {
    private TreeMap<Integer, Integer> count;

    public MyCalendarThree1() {
        count = new TreeMap<>();
    }

    public int book(int start, int end) {
        int ans = 0;
        int maxBook = 0;
        count.put(start, count.getOrDefault(start, 0) + 1);
        count.put(end, count.getOrDefault(end, 0) - 1);
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            int freq = entry.getValue();
            maxBook += freq;
            ans = Math.max(maxBook, ans);
        }
        return ans;
    }
}

// 线段树，把一个区间通过树结构划分为一个又一个的子区间，每次分2段，因此是一个二叉树
// 线段树对于数组内每个元素都会以叶子节点的形式存在，根节点存储所有元素之和
// 这里的index可以理解为各个节点
// 对于每个行程预订区间[start, end)，将区间内的每个元素都加1，最终求出数组的最大元素，数组的长度为[0, 1e9]
// 懒标记的作用：如果当前节点区间被索引的区间覆盖时，则将表示此区间的节点值+1，表示此区间内所有元素值都+1
// 每次进行book操作时，更新区间，记当前区间为[start, end)，索引区间为[left, right]
// 如果当该区间不在索引区间内时，即start > right || end < left，该索引区间不需要更新，直接返回
// 如果该区间被索引区间覆盖时，我们无需手动去更新区间内所有元素值，只需要标记一下该区间内的所有元素都被加1即可
// 当该区间内有元素不在索引区间内时，递归左右两边更新线段树
class MyCalendarThree2 {
    private Map<Integer, Integer> tree; // 记录区间[left, right]的最大值
    private Map<Integer, Integer> lazy; // 记录区间[left], right]进行累加的次数

    public MyCalendarThree2() {
        tree = new HashMap<>();
        lazy = new HashMap<>();
    }

    public int book(int start, int end) {
        update(start, end - 1, 0, 1000000000, 1);
        return tree.getOrDefault(1, 0);
    }

    public void update(int start, int end, int left, int right, int index) {
        if (right < start || end < left) { // 当该区间不在索引区间内
            return;
        }
        if (start <= left && right <= end) { // 该区间被索引区间覆盖
            tree.put(index, tree.getOrDefault(index, 0) + 1);
            lazy.put(index, lazy.getOrDefault(index, 0) + 1);
        } else { // 该区间内有元素不在索引区间内
            int mid = (left + right) >> 1;
            update(start, end, left, mid, 2 * index);
            update(start, end, mid + 1, right, 2 * index + 1);
            // 更新时顺便从懒区间内获取该节点被+1，然后把该节点的子节点同时更新
            tree.put(index, lazy.getOrDefault(index, 0) + Math.max(tree.getOrDefault(2 * index, 0), tree.getOrDefault(2 * index + 1, 0)));
        }
    }
}
