/**
 * 668. 乘法表中第k小的数
 * https://leetcode.cn/problems/kth-smallest-number-in-multiplication-table/
 */
public class FindKthNumber {
    public static void main(String[] args) {
        int m = 4;
        int n = 4;
        int k = 8;
        int res = findKthNumber1(m, n, k);

    }

    public static int findKthNumber1(int m, int n, int k) {
        /*
            count == k 时继续查找，就能返回满足count == k时最小的x值，那么x一定在乘法表中
         */
        int left = 1;
        int right = m * n;
        while (left < right) {
            int x = left + (right - left) / 2;
            // x/n得到的是行数，这些行的所有数都小于x，通过乘以每行的个数得到有几个数字
            int count = x / n * n; // 统计所有值都小于x的行一共有几个数字
            // [x/n + 1, m]是剩下的行，这些行部分数小于x
            for (int i = x / n + 1; i <= m; i++) { // 计算其他每行小于x的值由几个
                count += x / i;
            }
            if (count >= k) {  // 相等时候要继续查找，因为x可能不在乘法表中
                right = x;
            } else {
                left = x + 1;
            }
        }
        return left;
    }
}
