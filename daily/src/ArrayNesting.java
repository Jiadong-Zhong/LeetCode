import java.util.HashSet;
import java.util.Set;

/**
 * 565. 数组嵌套
 * https://leetcode.cn/problems/array-nesting/
 */
public class ArrayNesting {
    public static void main(String[] args) {
        int[] nums = {5,4,0,3,1,6,2};
        ArrayNesting solution = new ArrayNesting();
        int ans = solution.arrayNesting2(nums);
        System.out.println(ans);
    }

    // 暴力，超时
    public int arrayNesting(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int maxLen = 0;
        for (int i = 0; i < nums.length; i++) {
            set.clear();
            int nextIndex = i;
            while (set.add(nums[nextIndex])) {
                nextIndex = nums[nextIndex];
            }
            maxLen = Math.max(maxLen, set.size());
        }
        return maxLen;
    }

    // 图，寻找最大环
    public int arrayNesting2(int[] nums) {
        int ans = 0, n = nums.length;
        boolean[] isVisited = new boolean[n];
        for (int i = 0; i < n; i++) {
            int count = 0;
            while (!isVisited[i]) {
                isVisited[i] = true;
                i = nums[i];
                count++;
            }
            ans = Math.max(ans, count);
        }
        return ans;
    }

    // 原地标记，将isVisited数组省略，标记该位数字为n
    public int arrayNesting3(int[] nums) {
        int ans = 0, n = nums.length;
        for (int i = 0; i < n; i++) {
            int count = 0;
            while (nums[i] < n) {
                int num = nums[i];
                nums[i] = n;
                i = num;
                count++;
            }
            ans = Math.max(ans, count);
        }
        return ans;
    }
}
