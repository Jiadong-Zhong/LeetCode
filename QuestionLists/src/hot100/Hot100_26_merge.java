package hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 56. 合并区间
 * https://leetcode.cn/problems/merge-intervals/
 */
public class Hot100_26_merge {
    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        Hot100_26_merge solution = new Hot100_26_merge();
        int[][] ans = solution.merge(intervals);
        for (int[] row : ans) {
            System.out.println(Arrays.toString(row));
        }

    }

    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][2];
        }
        Arrays.sort(intervals, (Comparator.comparingInt(o -> o[0])));
        List<int[]> merged = new ArrayList<>();
        for (int[] interval : intervals) {
            int L = interval[0];
            int R = interval[1];
            if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < L) {
                merged.add(new int[]{L, R});
            } else {
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], R);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}
