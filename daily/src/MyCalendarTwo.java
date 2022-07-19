import java.util.*;

/**
 * 731. 我的日程安排表 II
 * https://leetcode.cn/problems/my-calendar-ii/
 */
public class MyCalendarTwo {
    public static void main(String[] args) {
        MyCalendarTwo2 myCalendar = new MyCalendarTwo2();
        boolean param1 = myCalendar.book(10, 20);
        boolean param2 = myCalendar.book(50, 60);
        boolean param3 = myCalendar.book(10, 40);
        boolean param4 = myCalendar.book(5, 15);
        boolean param5 = myCalendar.book(5, 10);
        boolean param6 = myCalendar.book(25, 55);
        boolean param7 = myCalendar.book(3, 19);
        boolean param8 = myCalendar.book(3, 14);
        boolean param9 = myCalendar.book(25, 39);
        boolean param10 = myCalendar.book(6, 19);
        System.out.println(param1);
        System.out.println(param2);
        System.out.println(param3);
        System.out.println(param4);
        System.out.println(param5);
        System.out.println(param6);
        System.out.println(param7);
        System.out.println(param8);
        System.out.println(param9);
        System.out.println(param10);
    }

    List<int[]> booked;
    List<int[]> overlaps;

    public MyCalendarTwo() {
        booked = new ArrayList<>();
        overlaps = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        for (int[] overlap : overlaps) {
            int left = overlap[0], right = overlap[1];
            if (left < end && start < right) {
                return false;
            }
        }
        for (int[] book : booked) {
            int left = book[0], right = book[1];
            if (left < end && start < right) {
                overlaps.add(new int[] {Math.max(left, start), Math.min(right, end)});
            }
        }
        booked.add(new int[] {start, end});
        return true;
    }
}

// 线段树
class MyCalendarTwo2 {
    Map<Integer, int[]> tree;

    public MyCalendarTwo2() {
        tree = new HashMap<>();
    }

    public boolean book(int start, int end) {
        // 将区间[start, end)区间中所有元素都+1
        update(start, end - 1, 1, 0 , 1000000000, 1);
        tree.putIfAbsent(1, new int[2]);
        if (tree.get(1)[0] > 2) {
            // 如果区间中最大元素大于2，表示发生三重预定，不能加入
            // 将区间中数值恢复
            update(start, end - 1, -1, 0 , 1000000000, 1);
            // 返回false
            return false;
        }
        return true;
    }

    public void update(int start, int end, int val, int left, int right, int index) {
        // 没有交集直接返回
        if (right < start || end < left) {
            return;
        }

        tree.putIfAbsent(index, new int[2]);

        if (start <= left && right <= end) {
            // [left, right]在[start, end)内，则更新所有元素
            tree.get(index)[0] += val;
            tree.get(index)[1] += val;
        } else {
            // 二分分别更新左区间和右区间
            // 当前树的左子节点的索引为 2 * index
            // 右子节点索引为2 * index + 1
            int mid = (left + right) >> 1;
            update(start, end, val, left, mid, 2 * index);
            update(start, end, val, mid + 1, right, 2 * index + 1);
            tree.putIfAbsent(2 * index, new int[2]);
            tree.putIfAbsent(2 * index + 1, new int[2]);
            // 数组第二位存放的是懒标记
            // 想要进行区间修改时，会对线段树下每个节点都进行修改，十分耗时
            // 所以引入懒标记，只有当查询操作时再对这个标记进行修改
            tree.get(index)[0] = tree.get(index)[1] + Math.max(tree.get(2 * index)[0], tree.get(2 * index + 1)[0]);
        }
    }
}
