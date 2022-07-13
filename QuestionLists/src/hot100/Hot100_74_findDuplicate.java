package hot100;

import java.util.HashSet;
import java.util.Set;

/**
 * 287. 寻找重复数
 * https://leetcode.cn/problems/find-the-duplicate-number/
 */
public class Hot100_74_findDuplicate {
    public static void main(String[] args) {
        int[] nums = {1,3,4,2,2};
        Hot100_74_findDuplicate solution = new Hot100_74_findDuplicate();
        int ans = solution.findDuplicate4(nums);
        System.out.println(ans);
    }

    // 暴力
    public int findDuplicate1(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return nums[i];
                }
            }
        }
        return -1;
    }

    // 哈希表
    public int findDuplicate2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                return num;
            }
        }
        return -1;
    }

    // 二分查找
    public int findDuplicate3(int[] nums) {
        int n = nums.length;
        int left = 1, right = n - 1, ans = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int count = 0;
            for (int num : nums) {
                if (num <= mid) {
                    count++;
                }
            }
            if (count <= mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
                ans = mid;
            }
        }
        return ans;
    }

    // 快慢指针
    public int findDuplicate4(int[] nums) {
        int slow = 0, fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
