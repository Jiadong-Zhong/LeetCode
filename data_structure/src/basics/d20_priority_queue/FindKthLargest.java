package basics.d20_priority_queue;

import java.util.Random;

/**
 * 215. 数组中的第K个最大元素
 * https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
 */
public class FindKthLargest {
    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        int k = 2;
        FindKthLargest solution = new FindKthLargest();
        int res = solution.findKthLargest1(nums, k);
        System.out.println(res);

    }
    Random random = new Random();

    public int findKthLargest1(int[] nums, int k) {
        return quickSelect1(nums, 0, nums.length - 1, k);
    }

    public int quickSelect1(int[] nums, int left, int right, int index) {
        int q = randomPartition(nums, left, right);

        if (q == index - 1) {
            return nums[q];
        } else {
            return q > index - 1 ? quickSelect1(nums, left, q - 1, index) : quickSelect1(nums, q + 1, right, index);
        }
    }

    public int randomPartition(int[] nums, int left, int right) {
        // 在[left, right]之间随机取一个索引
        int i = random.nextInt(right - left + 1) + left;
        // 交换i和right，先把随机索引对应的值放到最右边
        swap(nums, i, right);
        return partition(nums, left, right);
    }

    public int partition(int[] nums, int left, int right) {
        // x就是随机数索引对应的值
        int x = nums[right];
        int i = left;

        for (int j = left; j < right; j++) {
            // 大于x的数都放到当前区间的左边
            if (nums[j] >= x) {
                swap(nums, i, j);
                i++;
            }
        }

        // 大于x的值都在区间左边，将x与nums[i]交换，就将整体分成[left, i]和[i+1, right]区间，左边区间值都比x大，右边都比x小
        swap(nums, i, right);
        return i;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // 堆排序
    public int findKthLargest2(int[] nums, int k) {
        int heapSize = nums.length;
        buildMaxHeap(nums, heapSize);
        for (int i = nums.length - 1; i >= nums.length - k + 1; i--) {
            swap(nums, 0, i);
            heapSize--;
            maxHeapify(nums, 0, heapSize);
        }
        return nums[0];
    }

    public void buildMaxHeap(int[] nums, int heapSize) {
        for (int i = heapSize / 2; i >= 0; i--) {
            maxHeapify(nums, i, heapSize);
        }
    }

    public void maxHeapify(int[] nums, int i, int heapSize) {
        // i 为当前节点，left和right为当前节点的两个子节点
        int left = i * 2 + 1;
        int right = i * 2 + 2;
        int largest = i;
        // 如果左子节点在数组内且比父节点大，则最大值指向左子节点
        if (left < heapSize && nums[left] > nums[largest]) {
            largest = left;
        }
        // 如果右子节点在数组内且比父节点大，则最大值指向右子节点
        if (right < heapSize && nums[right] > nums[largest]) {
            largest = right;
        }

        // 如果最大值不是父节点，交换父节点和最大值
        if (largest != i) {
            swap(nums, i, largest);
            // 交换后再对子树进行调整
            maxHeapify(nums, largest, heapSize);
        }
    }

}
