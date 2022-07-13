/**
 * 面试题 10.01. 合并排序的数组
 * https://leetcode.cn/problems/sorted-merge-lcci/
 */
public class Merge {
    public static void main(String[] args) {
        int[] A = {1,2,3,0,0,0};
        int m = 3;
        int[] B = {2,5,6};
        int n = 3;
    }

    public void merge(int[] A, int m, int[] B, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int index = m + n - 1;
        while (index >= 0) {
            if (p1 == -1) {
                A[index--] = B[p2--];
            } else if (p2 == -1) {
                A[index--] = A[p1--];
            } else if (A[p1] > B[p2]) {
                A[index--] = A[p1--];
            } else {
                A[index--] = B[p2--];
            }
        }
    }
}
