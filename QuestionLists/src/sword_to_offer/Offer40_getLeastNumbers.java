package sword_to_offer;

import java.util.Arrays;
import java.util.Random;

/**
 * 剑指 Offer 40. 最小的k个数
 * https://leetcode.cn/problems/zui-xiao-de-kge-shu-lcof/
 */
public class Offer40_getLeastNumbers {
    public static void main(String[] args) {
        int[] arr = {0,0,2,3,2,1,1,2,0,4};
        int k = 10;
        Offer40_getLeastNumbers solution = new Offer40_getLeastNumbers();
        int[] ans = solution.getLeastNumbers(arr, k);
        System.out.println(Arrays.toString(ans));
    }

    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0) {
            return new int[0];
        }
        int index = quickSelect(arr, k, 0, arr.length - 1);
        return Arrays.copyOf(arr, index + 1);
    }

    private int quickSelect(int[] arr, int k, int left, int right) {
        if (left >= right) {
            return left;
        }
        int q = randomPartition(arr, left, right);
        if (q == k - 1) {
            return q;
        } else {
            return q > k - 1 ? quickSelect(arr, k, left, q - 1) : quickSelect(arr, k, q + 1, right);
        }
    }

    private int randomPartition(int[] arr, int left, int right) {
        int k = new Random().nextInt(right - left + 1) + left;
        swap(arr, right, k);
        int pivot = arr[right];
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, j, i);
            }
        }
        swap(arr, i + 1, right);
        return i + 1;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
