package hot100;

/**
 * 4. 寻找两个正序数组的中位数
 * https://leetcode.cn/problems/median-of-two-sorted-arrays/
 */
public class Hot100_4_findMedianSortedArrays {
    public static void main(String[] args) {
        int[] nums1 = {1,3};
        int[] nums2 = {1,2,3,4,5,6,7,8,9};
        double res = findMedianSortedArrays3(nums1, nums2);
        System.out.println(res);
    }

    public static double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int len = m + n;
        int p1 = 0;
        int p2 = 0;
        int index = 0;
        int[] merge = new int[len];
        while (p1 < m && p2 < n){
            if (nums1[p1] <= nums2[p2]) {
                merge[index++] = nums1[p1++];
            } else {
                merge[index++] = nums2[p2++];
            }
        }
        while (p1 < m) {
            merge[index++] = nums1[p1++];
        }
        while (p2 < n) {
            merge[index++] = nums2[p2++];
        }

        double res;
        if (len % 2 == 1) {
            res = merge[len / 2];
        } else {
            res = ((double) merge[len / 2] + (double) merge[len / 2 - 1]) / 2;
        }
        return res;
    }

    public static double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int len = m + n;
        if (len % 2 == 1) {
            int midIndex = len / 2;
            return getKthElement(nums1, nums2, midIndex + 1);
        } else {
            int midIndex1 = len / 2;
            int midIndex2 = len / 2 - 1;
            return (getKthElement(nums1, nums2, midIndex1 + 1) + getKthElement(nums1, nums2, midIndex2 + 1)) / 2.0;
        }
    }

    private static int getKthElement(int[] nums1, int[] nums2, int k) {
        int m = nums1.length;
        int n = nums2.length;
        int p1 = 0;
        int p2 = 0;

        while (true) {
            if (p1 == m) {
                return nums2[p2 + k - 1];
            }
            if (p2 == n) {
                return nums1[p1 + k - 1];
            }
            if (k == 1) {
                return Math.min(nums1[p1], nums2[p2]);
            }

            /*
                比较A[k/2 - 1] 和 B[k/2 - 1]
                如果前者小，则排除A中从0到k/2-1个数，排除后指针需要偏移为当前值+1
                如果后者小，则排除B中从0到k/2-1个数，排除后指针需要偏移为当前值+1
             */
            int half = k / 2;
            int newP1 = Math.min(p1 + half, m) - 1;  // 防止数组越界
            int newP2 = Math.min(p2 + half, n) - 1;
            int pivot1 = nums1[newP1];
            int pivot2 = nums2[newP2];
            if (pivot1 <= pivot2) {
                k -= (newP1 - p1 + 1);
                p1 = newP1 + 1;
            } else {
                k -= (newP2 - p2 + 1);
                p2 = newP2 + 1;
            }
        }
    }

    public static double findMedianSortedArrays3(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays3(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;
        int left = 0, right = m;
        // median1：前一部分的最大值
        // median2：后一部分的最小值
        int median1 = 0, median2 = 0;

        while (left <= right) {
            // 前一部分包含 nums1[0 .. i-1] 和 nums2[0 .. j-1]
            // 后一部分包含 nums1[i .. m-1] 和 nums2[j .. n-1]
            int i = (left + right) / 2;
            int j = (m + n + 1) / 2 - i;

            // nums_im1, nums_i, nums_jm1, nums_j 分别表示 nums1[i-1], nums1[i], nums2[j-1], nums2[j]
            int nums_im1 = (i == 0 ? Integer.MIN_VALUE : nums1[i - 1]);
            int nums_i = (i == m ? Integer.MAX_VALUE : nums1[i]);
            int nums_jm1 = (j == 0 ? Integer.MIN_VALUE : nums2[j - 1]);
            int nums_j = (j == n ? Integer.MAX_VALUE : nums2[j]);

            if (nums_im1 <= nums_j) {
                median1 = Math.max(nums_im1, nums_jm1);
                median2 = Math.min(nums_i, nums_j);
                left = i + 1;
            } else {
                right = i - 1;
            }
        }

        return (m + n) % 2 == 0 ? (median1 + median2) / 2.0 : median1;
    }
}
