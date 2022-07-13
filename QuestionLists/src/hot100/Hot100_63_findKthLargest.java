package hot100;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 215. 数组中的第K个最大元素
 * https://leetcode.cn/problems/kth-largest-element-in-an-array/
 */
public class Hot100_63_findKthLargest {
    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        int k = 2;
        Hot100_63_findKthLargest solution = new Hot100_63_findKthLargest();
        int ans = solution.findKthLargest3(nums, k);
        System.out.println(ans);
    }

    // 排序
    public int findKthLargest1(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k + 1];
    }

    // 基于快速排序的快速选择
    Random r = new Random();
    public int findKthLargest2(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, k);
    }

    public int quickSelect(int[] nums, int left, int right, int index) {
        int q = randomPartition(nums, left, right);
        if (q == index - 1) {
            return nums[q];
        } else {
            return q > index - 1 ? quickSelect(nums, left, q - 1, index) : quickSelect(nums, q + 1, right, index);
        }
    }

    public int randomPartition(int[] nums, int left, int right) {
        int i = r.nextInt(right - left + 1) + left;
        swap(nums, i, right);
        return partition(nums, left, right);
    }

    public int partition(int[] nums, int left, int right) {
        int x = nums[right];
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (nums[j] > x) {
                i++;
                swap(nums, i, j);
            }
        }
        swap(nums, i + 1, right);
        return i + 1;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // 基于堆排序的快速选择
    public int findKthLargest3(int[] nums, int k) {
        int heapSize = nums.length;
        buildMaxHeap(nums, heapSize);
        // 建堆完毕后，堆顶也就是nums[0]为最大元素，逐个删除堆顶元素，知道删除k-1个
        for (int i = nums.length - 1; i >= nums.length - k + 1; i--) {
            // 先将堆顶和最后一个元素交换，堆的性质被破坏，需要进行调整操作
            swap(nums, 0 , i);
            heapSize--;
            maxHeapify(nums, 0, heapSize);
        }
        return nums[0];
    }

    public void buildMaxHeap(int[] nums, int heapSize) {
        // 从最后一个父节点自下向上开始调整树
        for (int i = heapSize / 2; i >= 0; i--) {
            maxHeapify(nums, i, heapSize);
        }
    }

    public void maxHeapify(int[] nums, int i, int heapSize) {
        // left和right表示当前父节点i的两个左右子节点
        int left = i * 2 + 1, right = i * 2 + 2, largest = i;
        // 分别验证左右子节点是否在数组内，如果在数组内且比当前父节点大，则将最大值的指针指向对应的子节点
        if (left < heapSize && nums[left] > nums[largest]) {
            largest = left;
        }
        if (right < heapSize && nums[right] > nums[largest]) {
            largest = right;
        }
        // 如果最大值的指针不是父节点，则交换父节点和当前最大值指针指向的子节点
        if (largest != i) {
            swap(nums, i, largest);
            // 交换后可能破坏子树，因此对子节点的子树进行调整
            // 注意这个largest指针指向的是原来被交换走的父节点，因为存放的是索引，而不是对应的值
            maxHeapify(nums, largest, heapSize);
        }
    }
}
