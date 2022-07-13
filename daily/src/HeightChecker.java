import java.util.Arrays;

/**
 * 1051. 高度检查器
 * https://leetcode.cn/problems/height-checker/
 */
public class HeightChecker {
    public static void main(String[] args) {
        int[] heights = {1,1,4,2,1,3};
    }

    // 暴力
    public int heightChecker1(int[] heights) {
        int[] expected = new int[heights.length];
        for (int i = 0; i < heights.length; i++) {
            expected[i] = heights[i];
        }

        Arrays.sort(expected);
        int count = 0;
        for (int i = 0; i < heights.length; i++) {
            if (expected[i] != heights[i]) {
                count++;
            }
        }
        return count;
    }

    // 计数排序
    public int heightChecker2(int[] heights) {
        int m = Arrays.stream(heights).max().getAsInt();
        int[] count = new int[m + 1];
        for(int h : heights) {
            count[h]++;
        }
        int index = 0, ans = 0;
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= count[i]; j++) {
                if (heights[index] != i) {
                    ans++;
                }
                index++;
            }
        }
        return ans;
    }
}
