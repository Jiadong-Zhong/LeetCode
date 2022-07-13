import java.util.Arrays;
import java.util.Comparator;

/**
 * 436. 寻找右区间
 * https://leetcode.cn/problems/find-right-interval/
 */
public class FindRightInterval {
    public static void main(String[] args) {
        int[][] intervals = {{1, 2}, {2, 3}, {0, 1}, {3, 4}};
        FindRightInterval solution = new FindRightInterval();
        int[] ans = solution.findRightInterval3(intervals);
        System.out.println(Arrays.toString(ans));
    }

    public int[] findRightInterval1(int[][] intervals) {
        if (intervals.length == 1) {
            return new int[]{-1};
        }

        int[] ans = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            int min = Integer.MAX_VALUE;
            int minIndex = 0;
            for (int j = 0; j < intervals.length; j++) {
                if (intervals[j][0] >= intervals[i][1] && intervals[j][0] >= intervals[i][0]) {
                    if (intervals[j][0] < min) {
                        min = intervals[j][0];
                        minIndex = j;
                    }
                }
            }
            ans[i] = Integer.MAX_VALUE == min ? -1 : minIndex;
        }

        return ans;
    }

    // 二分
    public int[] findRightInterval2(int[][] intervals) {
        int n = intervals.length;
        int[][] startIntervals = new int[n][2];
        for (int i = 0; i < n; i++) {
            startIntervals[i][0] = intervals[i][0];
            startIntervals[i][1] = i;
        }
        Arrays.sort(startIntervals, Comparator.comparingInt(o -> o[0]));

        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int left = 0;
            int right = n - 1;
            int target = -1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (startIntervals[mid][0] >= intervals[i][1]) {
                    target = startIntervals[mid][1];
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            ans[i] = target;
        }
        return ans;
    }

    // 双指针
    public int[] findRightInterval3(int[][] intervals) {
        int n = intervals.length;
        int[][] startIntervals = new int[n][2];
        int[][] endIntervals = new int[n][2];
        for (int i = 0; i < n; i++) {
            startIntervals[i][0] = intervals[i][0];
            startIntervals[i][1] = i;
            endIntervals[i][0] = intervals[i][1];
            endIntervals[i][1] = i;
        }
        Arrays.sort(startIntervals, Comparator.comparingInt(o -> o[0]));
        Arrays.sort(endIntervals, Comparator.comparingInt(o -> o[0]));

        int[] ans = new int[n];
        for (int i = 0, j = 0; i < n; i++) {
            // 遍历startIntervals数组寻找endIntervals[i]对应区间的右边区间
            // endIntervals[i]为第i个区间的右端点，startIntervals[j]为第j个区间的左端点
            // 当右端点比左端点大时，说明不是右边区间
            // 因为左端点是排序递增的，因此j++
            // 当找到第一个右端点比左端点小，就退出循环，即找到了最小的右侧区间
            // 而下一次循环时，endIntervals的第i+1个区间的右端点肯定比第i个区间的大
            // 因此其肯定比startIntervals的第j - 1个区间的左端点大
            // 所以继续从j开始遍历即可，无需重置
            while (j < n && endIntervals[i][0] > startIntervals[j][0]) {
                j++;
            }
            if (j < n) {
                ans[endIntervals[i][1]] = startIntervals[j][1];
            } else {
                ans[endIntervals[i][1]] = -1;
            }
        }
        return ans;
    }
}
