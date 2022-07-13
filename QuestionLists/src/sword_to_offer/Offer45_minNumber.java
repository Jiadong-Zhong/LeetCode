package sword_to_offer;

import java.util.Arrays;

/**
 * 剑指 Offer 45. 把数组排成最小的数
 * https://leetcode.cn/problems/ba-shu-zu-pai-cheng-zui-xiao-de-shu-lcof/
 */
public class Offer45_minNumber {
    public static void main(String[] args) {
        int[] nums = {3,30,34,5,9};
        Offer45_minNumber solution = new Offer45_minNumber();
        String s = solution.minNumber(nums);
        System.out.println(s);
    }

    public String minNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }

        // compareTo函数：如果两个字符串完全一样，返回0
        // 如果每个字符不完全一样，返回出现不一样字符的ASCII差
        // x + y -> 330  y + x -> 303
        // 第一个出现不同的字符是第二位，比较的是使用这个方法的字符减去括号内的字符
        // 因此下面是(x + y) - (y + x)
        // 按照x + y 从小到大排序
        Arrays.sort(strs, (x, y) -> (x + y).compareTo(y + x));

        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s);
        }
        return sb.toString();
    }
}
