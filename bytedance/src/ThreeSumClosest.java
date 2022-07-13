import java.util.*;

/**
 * 16. 最接近的三数之和
 * https://leetcode.cn/problems/3sum-closest/
 */
public class ThreeSumClosest {
    public static void main(String[] args) {
        int[] nums = {1,1,-1};
        int target = 0;

        ThreeSumClosest solution = new ThreeSumClosest();
        int ans = solution.threeSumClosest(nums, target);
        System.out.println(ans);
    }

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int best = 10000000;

        for (int first = 0; first < n; first++) {
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }

            int second = first + 1, third = n - 1;
            while (second < third) {
                int sum = nums[first] + nums[second] + nums[third];
                if (sum == target) {
                    return target;
                }

                if (Math.abs(sum - target) < Math.abs(best - target)) {
                    best = sum;
                }

                if (sum > target) {
                    int tempThird = third - 1;
                    while (second < tempThird && nums[tempThird] == nums[third]) {
                        tempThird--;
                    }
                    third = tempThird;
                } else {
                    int tempSecond = second + 1;
                    while (tempSecond < third && nums[tempSecond] == nums[second]) {
                        tempSecond++;
                    }
                    second = tempSecond;
                }
            }
        }
        return best;
    }
}
