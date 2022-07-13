package basics.d4_array;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 435. 无重叠区间
 * https://leetcode-cn.com/problems/non-overlapping-intervals/
 */
public class EraseOverlapIntervals {
    public static void main(String[] args) {
        int[][] intervals = {{1,2}, {2,3}, {3,4}, {1,3}};
        int res = eraseOverlapIntervals2(intervals);
        System.out.println(res);
    }

    public static int eraseOverlapIntervals1(int[][] intervals) {
        int n = intervals.length;
        if (n == 0) {
            return 0;
        }

        Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));

        int right = intervals[0][1];
        int res = 1;
        for (int i = 1; i < n; i++) {
            if (intervals[i][0] >= right) {
                res++;
                right = intervals[i][1];
            }
        }
        return n - res;
    }

    public static int eraseOverlapIntervals2(int[][] intervals) {
        int n = intervals.length;
        if (n == 0) {
            return 0;
        }

        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        int[] f= new int[n];
        Arrays.fill(f, 1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (intervals[j][1] <= intervals[i][0]) {
                    f[i] = Math.max(f[i], f[j] + 1);
                }
            }
        }
        return n - Arrays.stream(f).max().getAsInt();
    }
}
