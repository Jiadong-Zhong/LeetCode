package sword_to_offer;

/**
 * 剑指 Offer 64. 求1+2+…+n
 * https://leetcode.cn/problems/qiu-12n-lcof/
 */
public class Offer64_sumNums {
    public static void main(String[] args) {
        int n = 3;
    }

    public int sumNums(int n) {
        boolean flag = n > 0 && (n += sumNums(n - 1)) > 0;
        return n;
    }
}
