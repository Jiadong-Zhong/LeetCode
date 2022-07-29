import java.util.HashSet;
import java.util.Set;

/**
 * 593. 有效的正方形
 * https://leetcode.cn/problems/valid-square/
 */
public class ValidSquare {

    // 对角线是边长的两倍，两点之间的距离要么是对角线要么是边长
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        Set<Integer> set = new HashSet<>();
        set.add(distance(p1, p2));
        set.add(distance(p1, p3));
        set.add(distance(p1, p4));
        set.add(distance(p2, p3));
        set.add(distance(p2, p4));
        set.add(distance(p3, p4));

        if (set.size() != 2 || set.contains(0)) {
            return false;
        }

        Integer[] arr = set.toArray(new Integer[2]);
        if (arr[0] > arr[1]) {
            return arr[0] == 2 * arr[1];
        } else {
            return arr[1] == 2 * arr[0];
        }
    }

    public int distance(int[] p1, int[] p2) {
        int edge1 = p1[0] - p2[0];
        int edge2 = p1[1] - p2[1];
        return edge1 * edge1 + edge2 * edge2;
    }
}
