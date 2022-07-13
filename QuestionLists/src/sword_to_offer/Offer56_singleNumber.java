package sword_to_offer;

/**
 * 剑指 Offer 56 - II. 数组中数字出现的次数 II
 * https://leetcode.cn/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-ii-lcof/
 */
public class Offer56_singleNumber {
    public static void main(String[] args) {
        int[] nums = {9,1,7,9,7,9,7};
        Offer56_singleNumber solution = new Offer56_singleNumber();
        int ans = solution.singleNumber(nums);
        System.out.println(ans);
    }

    public int singleNumber(int[] nums) {
        int[] counts = new int[32];
        for (int num : nums) {
            for (int j = 0; j < 32; j ++) {
                counts[j] += num & 1;
                num >>>= 1;
            }
        }

        int ans = 0, m = 3;
        for (int i = 0 ; i < 32; i++) {
            ans <<= 1;
            ans |= counts[31 - i] % m;
        }
        return ans;
    }
}
