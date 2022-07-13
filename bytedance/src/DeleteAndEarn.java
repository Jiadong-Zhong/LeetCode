import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 740. 删除并获得点数
 * https://leetcode.cn/problems/delete-and-earn/
 */
public class DeleteAndEarn {
    public static void main(String[] args) {
        int[] nums = {2,2,3,3,3,4};
        DeleteAndEarn solution = new DeleteAndEarn();
        int ans = solution.deleteAndEarn(nums);
        System.out.println(ans);
    }

    public int deleteAndEarn(int[] nums) {
        int n = nums.length;
        int ans = 0;
        Arrays.sort(nums);
        List<Integer> sum = new ArrayList<>();
        sum.add(nums[0]);
        int size = 1;
        for (int i = 1; i < n ; i++) {
            int val = nums[i];
            if (val == nums[i - 1]) {
                sum.set(size - 1, sum.get(size - 1) + val);
            } else if (val == nums[i - 1] + 1) {
                sum.add(val);
                size++;
            } else {
                ans += rob(sum);
                sum.clear();
                sum.add(val);
                size = 1;
            }
        }
        ans += rob(sum);
        return ans;
    }

    public int rob(List<Integer> sum) {
        int size = sum.size();
        if (size == 1) {
            return sum.get(0);
        }
        int first = sum.get(0), second = Math.max(sum.get(0), sum.get(1));
        for (int i = 2; i < size; i++) {
            int temp = second;
            second = Math.max(first + sum.get(i), second);
            first = temp;
        }
        return second;
    }
}
