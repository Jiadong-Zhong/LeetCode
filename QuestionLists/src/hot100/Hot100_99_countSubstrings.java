package hot100;

/**
 * 647. 回文子串
 * https://leetcode.cn/problems/palindromic-substrings/
 */
public class Hot100_99_countSubstrings {
    public static void main(String[] args) {
        String s = "ababa";
        Hot100_99_countSubstrings solution = new Hot100_99_countSubstrings();
        int ans = solution.countSubstrings2(s);
        System.out.println(ans);
    }

    // 中心拓展
    public int countSubstrings1(String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            ans += expandFromCenter(s, i, i);
            ans += expandFromCenter(s, i, i + 1);
        }
        return ans;
    }

    int expandFromCenter(String s, int left, int right) {
        int count = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
            count++;
        }
        return count;
    }

    // Manacher算法，有些不懂的地方 f[i]表示以s的第i位为中心，可以扩展出的最大回文半径，f[i] - 1就是以i为中心的最大回文串长度
    public int countSubstrings2(String s) {
        int n = s.length();
        StringBuffer t = new StringBuffer("$#");
        for (int i = 0; i < n; i++) {
            t.append(s.charAt(i));
            t.append("#");
        }
        n = t.length();
        t.append("!");

        int[] f = new int[n];
        int iMax = 0, rMax = 0, ans = 0;
        for (int i = 1; i < n; i++) {
            f[i] = i <= rMax ? Math.min(rMax - i + 1, f[2 * iMax - i]) : 1;
            while (t.charAt(i + f[i]) == t.charAt(i - f[i])) {
                f[i]++;
            }

            if (i + f[i] - 1 > rMax) {
                iMax = i;
                rMax = i + f[i] - 1;
            }

            ans += f[i] / 2;
        }
        return ans;
    }
}
