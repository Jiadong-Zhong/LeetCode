import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 剑指 Offer 38. 字符串的排列
 * https://leetcode.cn/problems/zi-fu-chuan-de-pai-lie-lcof/
 */
public class Permutation {
    public static void main(String[] args) {
        String s = "abc";

    }

    List<String> list = new ArrayList<>();
    boolean[] isVisited;
    public String[] permutation(String s) {
        int n = s.length();
        isVisited = new boolean[n];
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();

        backtrack(arr, 0, n, sb);
        String[] ans = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }

    public void backtrack(char[] arr, int i, int n, StringBuilder sb) {
        if (i == n) {
            list.add(sb.toString());
            return;
        }
        for (int j = 0; j < n; j++) {
            if (isVisited[j] || (j > 0 && !isVisited[j - 1] && arr[j - 1] == arr[j])) {
                continue;
            }
            isVisited[j] = true;
            sb.append(arr[j]);
            backtrack(arr, i + 1, n , sb);
            sb.deleteCharAt(sb.length() - 1);
            isVisited[j] = false;
        }
    }
}
