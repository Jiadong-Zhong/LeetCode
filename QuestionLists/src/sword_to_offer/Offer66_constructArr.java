package sword_to_offer;

import java.util.Arrays;

/**
 * 剑指 Offer 66. 构建乘积数组
 * https://leetcode.cn/problems/gou-jian-cheng-ji-shu-zu-lcof/
 */
public class Offer66_constructArr {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        Offer66_constructArr solution = new Offer66_constructArr();
        int[] ans = solution.constructArr2(a);
        System.out.println(Arrays.toString(ans));
    }

    // 左右乘积列表
    public int[] constructArr1(int[] a) {
        int n = a.length;
        if (n == 0) {
            return new int[0];
        }
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = 1;
        for (int i = 1; i < n; i++) {
            left[i] = left[i - 1] * a[i - 1];
        }
        right[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            right[i] = right[i + 1] * a[i + 1];
        }
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = left[i] * right[i];
        }
        return ans;
    }

    // 优化空间
    public int[] constructArr2(int[] a) {
        int length = a.length;
        if (length == 0) {
            return new int[0];
        }
        int[] ans = new int[length];

        ans[0] = 1;
        for (int i = 1; i < length; i++) {
            ans[i] = a[i - 1] * ans[i - 1];
        }

        int R = 1;
        for (int i = length - 1; i >= 0; i--) {
            ans[i] = R * ans[i];
            R *= a[i];
        }
        return ans;
    }
}
