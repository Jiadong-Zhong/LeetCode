package introduction.d1_array;

import java.util.HashSet;
import java.util.Set;

/**
 * 217. 存在重复元素
 * https://leetcode-cn.com/problems/contains-duplicate/
 */
public class ContainsDuplicate {
    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        System.out.println(containsDuplicate1(nums));
    }

    public static boolean containsDuplicate1(int[] nums) {
        Set<Integer> s = new HashSet<Integer>();
        for (int num : nums) {
            s.add(num);
        }
        return nums.length > s.size();
    }
}
