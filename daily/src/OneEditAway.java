/**
 * 面试题 01.05. 一次编辑
 * https://leetcode.cn/problems/one-away-lcci/
 */
public class OneEditAway {
    public static void main(String[] args) {
        String first = "pale";
        String second = "ple";
        boolean res = oneEditAway1(first, second);
        System.out.println(res);
    }

    public static boolean oneEditAway1(String first, String second) {
        int m = first.length();
        int n = second.length();

        if (m > n) {
            return oneEditAway1(second, first);
        }

        if (n - m == 1) {
            int p1 = 0;
            int p2 = 0;
            while (p1 < m && p2 < n) {
                if (first.charAt(p1) == second.charAt(p2)) {
                    p1++;
                }
                p2++;
                if (p2 - p1 > 1) {
                    return false;
                }
            }
            return true;
        } else if (m == n) {
            boolean foundDifference = false;
            for (int i = 0; i < n; i++) {
                if (first.charAt(i) != second.charAt(i)) {
                    if (!foundDifference) {
                        foundDifference = true;
                    } else {
                        return false;
                    }
                }
            }
            return true;
        } else {
            return false;
        }
    }
}
