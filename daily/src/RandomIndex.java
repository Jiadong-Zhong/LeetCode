import java.util.*;

/**
 * 398. 随机数索引
 * https://leetcode-cn.com/problems/random-pick-index/
 */
public class RandomIndex {
    Map<Integer, List<Integer>> pos;
    Random random;
    int[] nums;

    public static void main(String[] args) {
        int[] nums = new int[] {1, 2, 3, 3, 3};
    }

    public RandomIndex(int[] nums) {
        // 方法一构造器
        pos = new HashMap<>();
        random = new Random();
        for (int i = 0; i < nums.length; i++) {
            pos.putIfAbsent(nums[i], new ArrayList<>());
            pos.get(nums[i]).add(i);
        }

        // 方法二构造器
        this.nums = nums;
        random = new Random();
    }

    public int pick1(int target) {
        List<Integer> indices = pos.get(target);
        return indices.get(random.nextInt(indices.size()));
    }

    public int pick2(int target) {
        int ans = 0;
        for (int i = 0, count = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                count++;
                if (random.nextInt(count) == 0) {
                    ans = i;
                }
            }
        }
        return ans;
    }
}
