import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 349. 两个数组的交集
 * https://leetcode.cn/problems/intersection-of-two-arrays/
 */
public class Intersection {
    public static void main(String[] args) {
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int len1 = nums1.length, len2 = nums2.length;
        int[] intersection = new int[len1 + len2];
        int index = 0, index1 = 0, index2 = 0;
        while (index1 < len1 && index2 < len2) {
            int num1 = nums1[index1], num2 = nums2[index2];
            if (num1 == num2) {
                if (index == 0 || num1 != intersection[index - 1]) {
                    intersection[index++] = num1;
                }
                index1++;
                index2++;
            } else if (num1 < num2) {
                index1++;
            } else {
                index2++;
            }
        }
        return Arrays.copyOfRange(intersection, 0, index);
    }
}
