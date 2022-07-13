package sword_to_offer;

/**
 * 剑指 Offer 44. 数字序列中某一位的数字
 * https://leetcode.cn/problems/shu-zi-xu-lie-zhong-mou-yi-wei-de-shu-zi-lcof/
 */
public class Offer44_findNthDigit {
    public static void main(String[] args) {
        int n = 3;
    }

    // 看题解，总结规律
    public int findNthDigit(int n) {
        int digit = 1;
        long start = 1;
        long count = 9;
        while (n > count) { // 确定所求数位的所在数字的位数
            n -= count;
            digit += 1;
            start *= 10;
            count = digit * start * 9;
        }
        long num = start + (n - 1) / digit; // 确定所求数位所在的数字
        return Long.toString(num).charAt((n - 1) % digit) - '0';
    }
}
