package hot100;

/**
 * 55. 跳跃游戏
 * https://leetcode.cn/problems/jump-game/
 */
public class Hot100_25_canJump {
    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        Hot100_25_canJump solution = new Hot100_25_canJump();
        boolean ans = solution.canJump(nums);
        System.out.println(ans);
    }

    public boolean canJump(int[] nums) {
        int n = nums.length;
        int rightMost = 0;
        for (int i = 0; i < n; i++) {
            if (i <= rightMost) {
                rightMost = Math.max(rightMost, i + nums[i]);
                if (rightMost >= n - 1) {
                    return true;
                }
            }
        }
        return false;
    }
}
