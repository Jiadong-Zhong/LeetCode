import java.util.Arrays;

/**
 * 908. 最小差值 I
 * https://leetcode-cn.com/problems/smallest-range-i/
 */
public class SmallestRangeI {
    public static void main(String[] args) {
        int[] nums = {1, 3, 6};
        int k = 3;

        int res = smallestRangeI1(nums, k);
        System.out.println(res);
    }

    public static int smallestRangeI1(int[] nums, int k) {
        int min = Arrays.stream(nums).min().getAsInt();
        int max = Arrays.stream(nums).max().getAsInt();
        return max - min > 2 * k ? max - min - 2 * k : 0;
    }
}
