package sword_to_offer;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 剑指 Offer 56 - I. 数组中数字出现的次数
 * https://leetcode.cn/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-lcof/
 */
public class Offer56_singleNumbers {
    public static void main(String[] args) {
        int[] nums = {4, 1, 4, 6};
        Offer56_singleNumbers solution = new Offer56_singleNumbers();
        int[] ans = solution.singleNumbers(nums);
        System.out.println(Arrays.toString(ans));
    }

    public int[] singleNumbers(int[] nums) {

        // 先求数组内所有元素的异或和，结果就等于两个不重复数字的异或和
        int ans = 0;
        for (int num : nums) {
            ans ^= num;
        }

        // 根据这俩个不重复数字的异或和求mask以使得这俩位数字分开
        // 只需要求异或和二进制位数为1的即可，即表明这俩个数字在这一位不同，以此区分
        int div = 4;
        while ((div & ans) == 0) {
            div <<= 1;
        }

        // 根据上述的mask来求这俩个数字，一个和mask与之后结果为0，另一个为1
        // 此时不用考虑其他数字，因为其他数字一定是成对出现的，异或和一定为0
        int a = 0, b = 0;
        for (int num : nums) {
            if ((div & num) != 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }
        return new int[]{a, b};
    }
}
