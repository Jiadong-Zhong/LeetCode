/**
 * 45. 跳跃游戏 II
 * https://leetcode.cn/problems/jump-game-ii/
 */
public class Jump {
    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        Jump solution = new Jump();
        int ans = solution.jump2(nums);
        System.out.println(ans);
    }

    // 反向查找出发位置
    public int jump1(int[] nums) {
        int position = nums.length - 1;
        int steps = 0;
        while (position > 0) {
            for (int i = 0; i < position; i++) {
                if (i + nums[i] >= position) {
                    position = i;
                    steps++;
                    break;
                }
            }
        }
        return steps;
    }

    // 正向寻找
    public int jump2(int[] nums) {
        int length = nums.length;
        int end = 0; // 上次跳跃可以到达的右边界
        int maxPosition = 0;  // 目前能跳的最远位置
        int steps = 0;
        for (int i = 0; i < length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            // 到达上次跳跃的右边界了
            if (i == end) {
                end = maxPosition; // 目前能到的最远位置是下次起跳的右边界
                steps++; // 进入下次跳跃
            }
        }
        return steps;
    }
}
