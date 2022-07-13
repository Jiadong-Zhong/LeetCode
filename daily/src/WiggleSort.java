import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

/**
 * 324. 摆动排序 II
 * https://leetcode.cn/problems/wiggle-sort-ii/
 */
public class WiggleSort {
    public static void main(String[] args) {
        int[] nums = {1,5,1,1,6,4};
        WiggleSort solution = new WiggleSort();
        solution.wiggleSort2(nums);
        System.out.println(Arrays.toString(nums));
    }
 
    // 排序
    public void wiggleSort1(int[] nums) {
        int[] arr = nums.clone();
        Arrays.sort(arr);
        int n = nums.length;
        int x = (n + 1) / 2;
        for (int i = 0, j = x - 1, k = n - 1; i < n; i += 2, j--, k--) {
            nums[i] = arr[j];
            if (i + 1 < n) {
                nums[i + 1] = arr[k];
            }
        }
    }

    // 快速选择，并划分
    public void wiggleSort2(int[] nums) {
        int n = nums.length;
        int mid = (n - 1) / 2;
        getKth(nums, mid); // 把数组分为[0, mid] 和 [mid + 1, n]

        int[] res = new int[n];
        int offset = n / 2;
        int index = 0;
        for (int i = mid; i >= 0; i--) {
            res[index++] = nums[i];
            if (index < n) {
                res[index++] = nums[i + offset];
            }
        }
        System.arraycopy(res, 0, nums, 0,  n);
    }

    private void getKth(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int[] pivot = partition(nums, left, right);
            if (pivot[0] <= target && target <= pivot[1]) {
                return;
            }
            if (target < pivot[0]) {
                right = pivot[0] - 1;
            } else {
                left = pivot[1] + 1;
            }
        }
    }

    private int[] partition(int[] nums, int left, int right) {
        int randIndex = new Random().nextInt(right - left + 1) + left;
        int pivot = nums[randIndex];
        swap(nums, randIndex, left);
        // 切分为 [left, leftIndex - 1] [leftIndex, rightIndex] [rightIndex + 1, right]
        int leftIndex = left;
        int rightIndex = right;
        int i = left + 1;
        while (i <= rightIndex) {
            if (nums[i] < pivot) {
                swap(nums, i, leftIndex);
                leftIndex++;
                i++;
            } else if (nums[i] > pivot) {
                swap(nums, i, rightIndex);
                rightIndex--;
            } else {
                i++;
            }
        }
        return new int[] {leftIndex, rightIndex};
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
