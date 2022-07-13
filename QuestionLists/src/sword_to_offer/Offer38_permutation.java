package sword_to_offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 剑指 Offer 38. 字符串的排列
 * https://leetcode.cn/problems/zi-fu-chuan-de-pai-lie-lcof/
 */
public class Offer38_permutation {
    public static void main(String[] args) {
        String s = "abc";
    }

    // 递归回溯
    List<String> ans = new ArrayList<>();
    boolean[] isVisited;
    public String[] permutation1(String s) {
        int n = s.length();
        isVisited = new boolean[n];
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();

        backtrack(arr, 0, n, sb);

        String[] res = new String[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            res[i] = ans.get(i);
        }
        return res;
    }

    public void backtrack(char[] arr, int count, int n, StringBuilder sb) {
        if (count == n) {
            ans.add(sb.toString());
            return;
        }
        for (int i = 0; i < n; i++) {
            if (isVisited[i] || (i > 0 && !isVisited[i - 1] && arr[i] == arr[i - 1])) {
                continue;
            }
            isVisited[i] = true;
            sb.append(arr[i]);
            backtrack(arr, count + 1, n, sb);
            sb.deleteCharAt(sb.length() - 1);
            isVisited[i] = false;
        }
    }

    // 下一个排列
    public String[] permutation(String s) {
        List<String> ans = new ArrayList<>();
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        ans.add(new String(arr));
        while (nextPermutation(arr)) {
            ans.add(new String(arr));
        }

        String[] res = new String[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            res[i] = ans.get(i);
        }
        return res;
    }

    public boolean nextPermutation(char[] arr) {
        int i = arr.length - 2;
        while (i >= 0 && arr[i] >= arr[i + 1]) {
            i--;
        }
        if (i < 0) {
            return false;
        }
        int j = arr.length - 1;
        while (j >= 0 && arr[j] <= arr[i]) {
            j--;
        }
        swap(arr, i, j);
        reverse(arr, i + 1);
        return true;
    }

    public void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void reverse(char[] arr, int start) {
        int left = start;
        int right = arr.length - 1;
        while (left < right) {
            swap(arr, left, right);
            left++;
            right--;
        }
    }
}
