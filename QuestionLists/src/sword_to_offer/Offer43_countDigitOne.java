package sword_to_offer;

/**
 * 剑指 Offer 43. 1～n 整数中 1 出现的次数
 * https://leetcode.cn/problems/1nzheng-shu-zhong-1chu-xian-de-ci-shu-lcof/
 */
public class Offer43_countDigitOne {
    public static void main(String[] args) {
        int n = 12;
    }

    public int countDigitOne(int n) {
        long mulK = 1;
        long ans = 0;
        while (n >= mulK) {
            ans += (n / (mulK * 10)) * mulK + Math.min(Math.max(n % (mulK * 10) - mulK + 1, 0), mulK);
            mulK *= 10;
        }
        return (int) ans;
    }
}
