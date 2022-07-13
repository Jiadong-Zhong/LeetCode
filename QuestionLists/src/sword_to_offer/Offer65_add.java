package sword_to_offer;

/**
 * 剑指 Offer 65. 不用加减乘除做加法
 * https://leetcode.cn/problems/bu-yong-jia-jian-cheng-chu-zuo-jia-fa-lcof/
 */
public class Offer65_add {
    public static void main(String[] args) {
        int a = 1;
        int b = 1;
    }

    // 位运算
    public int add(int a, int b) {
        while (b != 0) {
            int c = (a & b) << 1;
            a ^= b;
            b = c;
        }
        return a;
    }
}
