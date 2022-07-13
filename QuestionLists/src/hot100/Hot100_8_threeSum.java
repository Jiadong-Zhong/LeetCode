package hot100;

import java.util.*;

/**
 * 15. 三数之和
 * https://leetcode.cn/problems/3sum/
 */
public class Hot100_8_threeSum {
    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        Hot100_8_threeSum solution = new Hot100_8_threeSum();
        List<List<Integer>> res = solution.threeSum(nums);
        System.out.println(res);
    }

    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 3) {
            return res;
        }

        Arrays.sort(nums);
        for (int first = 0; first < n; first++) {
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }

            int third = n - 1;
            int target = -nums[first];

            for (int second = first + 1; second < n; second ++) {
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }

                while (second < third && nums[second] + nums[third] > target) {
                    third--;
                }

                if (third == second) {
                    break;
                }

                if (nums[second] + nums[third] == target) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    res.add(list);
                }
            }
        }
        return res;
    }
}
