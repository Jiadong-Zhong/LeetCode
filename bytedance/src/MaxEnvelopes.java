import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 354. 俄罗斯套娃信封问题
 * https://leetcode.cn/problems/russian-doll-envelopes/
 */
public class MaxEnvelopes {
    public static void main(String[] args) {
        int[][] envelops = {{5,4},{6,4},{6,7},{2,3}};
        MaxEnvelopes solution = new MaxEnvelopes();
        int ans = solution.maxEnvelopes2(envelops);
        System.out.println(ans);
    }

    // 动态规划
    // 把第一维度按照升序排列，第二维度按照降序排列
    // 就可以先不考虑第一维度，寻找第二维度的最长递增子序列
    public int maxEnvelopes1(int[][] envelopes) {
        if (envelopes.length == 0) {
            return 0;
        }

        int n = envelopes.length;
        Arrays.sort(envelopes, ((o1, o2) -> {
            if (o1[0] != o2[0]) {
                return o1[0] - o2[0];
            } else {
                return o2[1] - o1[1];
            }
        }));

        int[] f = new int[n];
        Arrays.fill(f, 1);
        int ans = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (envelopes[j][1] < envelopes[i][1]) {
                    f[i] = Math.max(f[i], f[j] + 1);
                }
            }
            ans = Math.max(ans, f[i]);
        }
        return ans;
    }

    public int maxEnvelopes2(int[][] envelopes) {
        if (envelopes.length == 0) {
            return 0;
        }

        int n = envelopes.length;
        Arrays.sort(envelopes, (o1, o2) -> {
            if (o1[0] != o2[0]) {
                return o1[0] - o2[0];
            } else {
                return o2[1] - o1[1];
            }
        });

        List<Integer> f = new ArrayList<>();
        f.add(envelopes[0][1]);
        for (int i = 1;i < n; i++) {
            int num = envelopes[i][1];
            if (num > f.get(f.size() - 1)) {
                f.add(num);
            } else {
                int index = binarySearch(f, num);
                f.set(index, num);
            }
        }
        return f.size();
    }

    public int binarySearch(List<Integer> f, int target) {
        int left = 0, right = f.size() - 1;
        while (left < right) {
            int mid = left + (right - left) /2;
            if (f.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
