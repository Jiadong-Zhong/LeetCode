import java.util.HashSet;
import java.util.Set;

/**
 * 41. 缺失的第一个正数
 * https://leetcode.cn/problems/first-missing-positive/
 */
public class FirstMissingPositive {
    public static void main(String[] args) {
        int[] nums = {3,4,-1,1};
        FirstMissingPositive solution = new FirstMissingPositive();
        int ans = solution.firstMissingPositive3(nums);
        System.out.println(ans);
    }

    // 哈希表，空间超
    public int firstMissingPositive1(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        for (int i = 1; i <= nums.length; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return -1;
    }

    // 负数标记代替哈希表
    public int firstMissingPositive2(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0) {
                nums[i] = n + 1;
            }
        }
        for (int i = 0; i < n; i++) {
            int num = Math.abs(nums[i]);
            if (num <= n) {
                nums[num - 1] = -Math.abs(nums[num - 1]);
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return n + 1;
    }

    // 置换
    public int firstMissingPositive3(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return n + 1;
    }
}
