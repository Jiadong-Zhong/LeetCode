import java.util.Arrays;

/**
 * 821. 字符的最短距离
 * https://leetcode-cn.com/problems/shortest-distance-to-a-character/
 */
public class ShortestToChar {
    public static void main(String[] args) {
        String s = "aaba";
        char c = 'b';
        int[] res = shortestToChar2(s, c);
        System.out.println(Arrays.toString(res));
    }

    public static int[] shortestToChar1(String s, char c) {
        if (s.length() == 0) {
            return new int[0];
        }

        int[] res = new int[s.length()];
        int left = -1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                res[i] = 0;
                for (int j = i; j > left; j--) {
                    if (left == -1) {
                        res[j] = Math.abs(j - i);
                    } else {
                        res[j] = Math.min(Math.abs(j - left), Math.abs(j - i));
                    }
                }
                left = i;
            }
        }
        for (int i = left; i < s.length(); i++) {
            res[i] = i - left;
        }
        return res;
    }

    public static int[] shortestToChar2(String s, char c) {
        int n = s.length();
        int[] ans = new int[n];

        for (int i = 0, idx = -n; i < n; ++i) {
            if (s.charAt(i) == c) {
                idx = i;
            }
            ans[i] = i - idx;
        }

        for (int i = n - 1, idx = 2 * n; i >= 0; --i) {
            if (s.charAt(i) == c) {
                idx = i;
            }
            ans[i] = Math.min(ans[i], idx - i);
        }
        return ans;
    }
}
