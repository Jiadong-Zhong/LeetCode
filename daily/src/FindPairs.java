import java.util.*;

/**
 * 532. 数组中的 k-diff 数对
 * https://leetcode.cn/problems/k-diff-pairs-in-an-array/
 */
public class FindPairs {
    public static void main(String[] args) {
        int[] nums = {3,1,4,1,5};
        int k = 2;
        FindPairs solution = new FindPairs();
        int ans = solution.findPairs1(nums, k);
        System.out.println(ans);
    }

    // 哈希表
    public int findPairs1(int[] nums, int k) {
        Set<Integer> visited = new HashSet<>();
        Set<Integer> res = new HashSet<>();
        for (int num : nums) {
            if (visited.contains(num - k)) {
                res.add(num - k);
            }
            if (visited.contains(num + k)) {
                res.add(num);
            }
            visited.add(num);
        }
        return res.size();
    }

    // 排序 + 双指针
    public int findPairs2(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int y = 0, res = 0;
        for (int x = 0; x < n; x++) {
            if (x == 0 || nums[x] != nums[x - 1]) {
                while (y < n && (nums[y] < nums[x] + k || y <= x)) {
                    y++;
                }
                if (y < n && nums[y] == nums[x] + k) {
                    res++;
                }
            }
        }
        return res;
    }
}
