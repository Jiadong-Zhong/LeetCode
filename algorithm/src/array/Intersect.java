package array;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 两个数组的交集 II
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2y0c2/
 */
public class Intersect {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};

        int[] ans = intersect2(nums1, nums2);
        System.out.println(Arrays.toString(ans));

    }

    public static int[] intersect1 (int[] nums1, int[] nums2) {
        int p1 = 0;
        int p2 = 0;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        // List<Integer> l = new ArrayList<>();
        int[] ans = new int[Math.min(nums1.length, nums2.length)];
        int index = 0;
        while (p1 < nums1.length && p2 < nums2.length) {
            if (nums1[p1] == nums2[p2]) {
                ans[index] = nums1[p1];
                index++;
                p1++;
                p2++;
            } else if (nums1[p1] < nums2[p2]) {
                p1++;
            } else {
                p2++;
            }
        }
        return Arrays.copyOf(ans, index);
    }

    public static int[] intersect2 (int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int[] ans = new int[Math.min(nums1.length, nums2.length)];
        int index = 0;
        for (int num : nums2) {
            if (map.getOrDefault(num, 0) > 0) {
                ans[index] = num;
                index++;
                map.put(num, map.get(num) - 1);
            }
        }
        return Arrays.copyOf(ans, index);
    }
}
