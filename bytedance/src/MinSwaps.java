/**
 * 1864. 构成交替字符串需要的最小交换次数
 * https://leetcode.cn/problems/minimum-number-of-swaps-to-make-the-binary-string-alternating/
 */
public class MinSwaps {
    public static void main(String[] args) {
        String s = "111000";

    }

    public int minSwaps(String s) {
        int n = s.length();
        int ans = Integer.MAX_VALUE;

        // 只有两种情况
        // 1在前且1多，1010 或者 10101
        // 0在前且0多，0101 或者 01010
        int n1 = count(s, '1');
        int n0 = count(s, '0');

        // 1在前且1多，这种情况下1都是奇数位，diff1统计位置不对的元素个数
        if (n1 == (n + 1) / 2 && n0 == n / 2) {
            int diff1 = 0;
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) - '0' == i % 2) {
                    diff1++;
                }
            }
            ans = Math.min(ans, diff1 / 2);
        }

        // 0在前且0多，这种情况下0都是奇数位，diff2统计位置不对的元素个数
        if (n0 == (n + 1) / 2 && n1 == n / 2) {
            int diff2 = 0;
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) - '0' != i % 2) {
                    diff2++;
                }
            }
            ans = Math.min(ans, diff2 / 2);
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public int count(String s, char c) {
        char[] chars = s.toCharArray();
        int count = 0;
        for (char ch : chars) {
            if (ch == c) {
                count++;
            }
        }
        return count;
    }
}
