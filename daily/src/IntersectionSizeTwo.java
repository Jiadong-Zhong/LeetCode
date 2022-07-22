import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 757. 设置交集大小至少为2
 * https://leetcode.cn/problems/set-intersection-size-at-least-two/
 */
public class IntersectionSizeTwo {
    public static void main(String[] args) {
        int[][] intervals = {{1,3},{1,4},{2,5},{3,5}};
        IntersectionSizeTwo solution = new IntersectionSizeTwo();
        int ans = solution.intersectionSizeTwo(intervals);
        System.out.println(ans);
    }

    public int intersectionSizeTwo(int[][] intervals) {
        int n = intervals.length;
        int ans = 0;
        int m = 2;

        // 这样排序可以保证在左区间相同的情况下，让区间范围最小的在最右边
        // 在倒序遍历时，就能够保证满足条件
        // 例如区间为{{5,10},{5,8}}，只要满足了{5,8}，那么一定满足{5,10}
        Arrays.sort(intervals, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o2[1] - o1[1];
            }
            return o1[0] - o2[0];
        });

        List<Integer>[] temp = new List[n];
        for (int i = 0; i < n; i++) {
            temp[i] = new ArrayList<>();
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = intervals[i][0], k = temp[i].size(); k < m; j++, k++) {
                ans++;
                help(intervals, temp, i - 1, j);
            }
        }
        return ans;
    }

    public void help(int[][] intervals, List<Integer>[] temp, int pos, int num) {
        for (int i = pos; i >= 0; i--) {
            if (intervals[i][1] < num) {
                break;
            }
            temp[i].add(num);
        }
    }
}
