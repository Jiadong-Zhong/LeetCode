package sword_to_offer;

/**
 * 剑指 Offer 19. 正则表达式匹配
 * https://leetcode.cn/problems/zheng-ze-biao-da-shi-pi-pei-lcof/
 */
public class Offer19_isMatch {
    public static void main(String[] args) {
        String s = "mississippi";
        String p = "mis*is*p*";
        Offer19_isMatch solution = new Offer19_isMatch();
        boolean ans = solution.isMatch(s, p);
        System.out.println(ans);
    }

    // 动态规划
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }

        int m = s.length();
        int n = p.length();

        boolean[][] f = new boolean[m + 1][n + 1];
        f[0][0] = true;
        for (int i = 0; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) == '*') {
                    f[i][j] = f[i][j - 2]; // 当前'x*'组合不匹配任何一个字符
                    if (matches(s, p, i, j - 1)) { // 如果p中*之前的字符和当前s中的字符匹配
                        f[i][j] = f[i][j] || f[i - 1][j]; // 看s去掉当前字符和p是否匹配
                    }
                } else {
                    if (matches(s, p, i, j)) { // 如果两个串当前字符匹配
                        f[i][j] = f[i - 1][j - 1]; // 看两个字符串去掉当前字符是否匹配
                    }
                }
            }
        }
        return f[m][n];
    }

    // 下面都-1是因为上面动态规划时候多计算了空字符串
    public boolean matches(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }
        if (p.charAt(j - 1) == '.') {
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }
}
