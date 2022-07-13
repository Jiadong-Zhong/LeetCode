package hot100;

/**
 * 136. 只出现一次的数字
 * https://leetcode.cn/problems/single-number/
 * 关键词：位运算
 */
public class Hot100_48_singleNumber {
    public static void main(String[] args) {
        int[] nums = {4,1,2,1,2};
        Hot100_48_singleNumber solution = new Hot100_48_singleNumber();
        int ans = solution.singleNumber(nums);
        System.out.println(ans);
    }

    public int singleNumber(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }
}
