import java.util.*;

/**
 * 497. 非重叠矩形中的随机点
 * https://leetcode.cn/problems/random-point-in-non-overlapping-rectangles/
 */
public class RandomPointInNonOverLappingRectangles {
    public static void main(String[] args) {
        int[][] rects = {{-2, -2, 1, 1}, {2, 2, 4, 6}};
        Solution497 solution = new Solution497(rects);
        int[] param_1 = solution.pick();
        int[] param_2 = solution.pick();
        int[] param_3 = solution.pick();
        int[] param_4 = solution.pick();
        int[] param_5 = solution.pick();
        System.out.println(Arrays.toString(param_1));
        System.out.println(Arrays.toString(param_2));
        System.out.println(Arrays.toString(param_3));
        System.out.println(Arrays.toString(param_4));
        System.out.println(Arrays.toString(param_5));
    }


}

class Solution497 {
    int[][] rects;
    List<Integer> arr;
    Random random;

    public Solution497(int[][] rects) {
        random = new Random();
        arr = new ArrayList<>();
        arr.add(0);
        this.rects = rects;
        for (int[] rect : rects) {
            int a = rect[0], b = rect[1], x = rect[2], y = rect[3];
            arr.add(arr.get(arr.size() - 1) + (x - a + 1) * (y - b + 1));
        }
    }

    public int[] pick() {
        int k = random.nextInt(arr.get(arr.size() - 1));
        int rectIndex = binarySearch(arr, k + 1) - 1;
        k -= arr.get(rectIndex);
        int[] rect = rects[rectIndex];
        int a = rect[0], b = rect[1], y = rect[3];
        int col = y - b + 1;
        int da = k / col;
        int db = k - col * da;
        return new int[] {a + da, b + db};
    }

    private int binarySearch(List<Integer> arr, int target) {
        int low = 0, high = arr.size() - 1;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            int num = arr.get(mid);
            if (num == target) {
                return mid;
            } else if (num > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
