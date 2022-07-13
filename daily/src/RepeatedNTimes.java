import java.util.*;

/**
 * 961. 在长度 2N 的数组中找出重复 N 次的元素
 * https://leetcode.cn/problems/n-repeated-element-in-size-2n-array/
 */
public class RepeatedNTimes {
    public static void main(String[] args) {
        int[] nums = {5,1,5,2,5,3,5,4};

    }

    public int repeatedNTimes1(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        int n = nums.length;

        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
            if (count.get(num) == n / 2) {
                return num;
            }
        }
        return -1;
    }

    // 数组中有n+1个不同元素，其他元素都只出现一次
    public int repeatedNTimes2(int[] nums) {
        Set<Integer> found = new HashSet<>();
        for (int num : nums) {
            if (!found.add(num)) {
                return num;
            }
        }
        return -1;
    }

    // 间隔最多2个位置
    public int repeatedNTimes3(int[] nums) {
        int n = nums.length;
        for (int gap = 1; gap <= 3; gap++) {
            for (int i = 0; i + gap < n; i++) {
                if (nums[i] == nums[i + gap]) {
                    return nums[i];
                }
            }
        }
        return -1;
    }

    // 随机选择
    public int repeatedNTimes4(int[] nums) {
        int n = nums.length;
        Random random = new Random();

        while (true) {
            int x = random.nextInt(n);
            int y = random.nextInt(n);
            if (x != y && nums[x] == nums[y]) {
                return nums[x];
            }
        }
    }
}
