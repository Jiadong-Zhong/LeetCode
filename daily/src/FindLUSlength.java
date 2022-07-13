/**
 * 522. 最长特殊序列 II
 * https://leetcode.cn/problems/longest-uncommon-subsequence-ii/
 */
public class FindLUSlength {
    public static void main(String[] args) {
        String[] strs = {"aba","cdc","eae"};
    }

    public int findLUSlength(String[] strs) {
        int n = strs.length;
        int ans = -1;
        for (int i = 0; i < n; i++) {
            boolean check = true;
            for (int j = 0; j < n; j++) {
                if (i != j && isSubseq(strs[i], strs[j])) {
                    check = false;
                    break;
                }
            }

            if (check) {
                ans = Math.max(ans, strs[i].length());
            }
        }
        return ans;
    }

    public boolean isSubseq(String s, String t) {
        int ptrS = 0, ptrT = 0;
        while (ptrS < s.length() && ptrT < t.length()) {
            if (s.charAt(ptrS) == t.charAt(ptrT)) {
                ptrS++;
            }
            ptrT++;
        }
        return ptrS == s.length();
    }
}
