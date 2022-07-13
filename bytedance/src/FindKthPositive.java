/**
 * 1539. 第 k 个缺失的正整数
 * https://leetcode.cn/problems/kth-missing-positive-number/
 */
public class FindKthPositive {
    public static void main(String[] args) {
        int[] arr = {2,3,4,7,11};
        int k = 5;
    }

    public int findKthPositive1(int[] arr, int k) {
        if (arr[0] > k) {
            return k;
        }

        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int lost = arr[mid] - mid - 1;
            if (lost < k) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left + k;
    }

    public int findKthPositive2(int[] arr, int k) {
        int n = arr.length;
        for (int j : arr) {
            if (j <= k) {
                k++;
            }
        }
        return k;
    }
}
