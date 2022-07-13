import java.util.HashSet;
import java.util.Set;

/**
 * 剑指 Offer 03. 数组中重复的数字
 * https://leetcode.cn/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/
 */
public class FindRepeatNumber {
    public static void main(String[] args) {
        int[] nums = {2,3,1,0,2,5,3};
        FindRepeatNumber solution = new FindRepeatNumber();
        int ans = solution.findRepeatNumber2(nums);
        System.out.println(ans);
    }

    // 时空都O(n)
    public int findRepeatNumber1(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                return num;
            }
        }
        return -1;
    }

    // 空间O(1) 时间O(n)
    public int findRepeatNumber2(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }

                int temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;
            }
        }
        return -1;
    }
}
