package hot100;

import java.util.*;

/**
 * 253. 会议室 II
 * https://leetcode.cn/problems/meeting-rooms-ii/
 */
public class Hot100_71_minMeetingRooms {
    public static void main(String[] args) {
        int[][] intervals = {{0, 30}, {5, 10}, {15, 20}};

    }

    // 优先队列
    public int minMeetingRooms1(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }

        // 优先队列中存放会议的结束时间
        PriorityQueue<Integer> allocator = new PriorityQueue<>(Comparator.comparingInt(o -> o));
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        allocator.add(intervals[0][1]);
        for (int i = 1; i < intervals.length; i++) {
            // 如果当前会议的开始时间已经大于队列中的会议的结束时间，因为已经排序过，说明后面没有会议会与队列中的会议冲突，因此可以直接把队列中的会议去除
            if (intervals[i][0] >= allocator.peek()) {
                allocator.poll();
            }
            allocator.add(intervals[i][1]);
        }
        return allocator.size();
    }

    // 有序化
    public int minMeetingRooms2(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }

        Integer[] start = new Integer[intervals.length];
        Integer[] end = new Integer[intervals.length];

        for (int i = 0; i < intervals.length; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }

        Arrays.sort(end, Comparator.comparingInt(o -> o));
        Arrays.sort(start, Comparator.comparingInt(o -> o));

        int startPointer = 0, endPointer = 0;
        int usedRooms = 0;
        while (startPointer < intervals.length) {
            // 如果该开始时间大于endPointer指向的会议，说明有会议结束，可以重用该会议室
            if (start[startPointer] >= end[endPointer]) {
                usedRooms--;
                endPointer++;
            }

            usedRooms++;
            startPointer++;
        }
        return usedRooms;
    }
}
