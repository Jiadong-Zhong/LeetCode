import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1331. 数组序号转换
 * https://leetcode.cn/problems/rank-transform-of-an-array/
 */
public class ArrayRankTransform {
    public static void main(String[] args) {
        int[] arr = {37,12,28,9,100,56,80,5,12};
        ArrayRankTransform solution = new ArrayRankTransform();
        int[] ans = solution.arrayRankTransform(arr);
        System.out.println(Arrays.toString(ans));
    }

    public int[] arrayRankTransform(int[] arr) {
        int[] sortedArr = Arrays.copyOf(arr, arr.length);
        Arrays.sort(sortedArr);
        Map<Integer, Integer> ranks = new HashMap<>();
        for (int num : sortedArr) {
            if (!ranks.containsKey(num)) {
                ranks.put(num, ranks.size() + 1);
            }
        }
        int[] ans = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            ans[i] = ranks.get(arr[i]);
        }
        return ans;
    }
}
