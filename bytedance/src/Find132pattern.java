import java.util.Deque;
import java.util.LinkedList;

/**
 * 456. 132 模式
 * https://leetcode.cn/problems/132-pattern/
 */
public class Find132pattern {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        Find132pattern solution = new Find132pattern();
        boolean ans = solution.find132pattern(nums);
        System.out.println(ans);
    }

    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        Deque<Integer> candidateK = new LinkedList<>();
        candidateK.push(nums[n - 1]);
        int maxK = Integer.MIN_VALUE; // 存放真正可以作为2的数字

        for (int i = n - 2; i >= 0; --i) {
            if (nums[i] < maxK) {
                return true;
            }
            while (!candidateK.isEmpty() && nums[i] > candidateK.peek()) {
                maxK = candidateK.pop();
            }
            if (nums[i] > maxK) {
                candidateK.push(nums[i]);
            }
        }

        return false;
    }
}
