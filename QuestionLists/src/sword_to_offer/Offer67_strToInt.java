package sword_to_offer;

/**
 * 剑指 Offer 67. 把字符串转换成整数
 * https://leetcode.cn/problems/ba-zi-fu-chuan-zhuan-huan-cheng-zheng-shu-lcof/
 */
public class Offer67_strToInt {
    public static void main(String[] args) {
        String str = "42";
    }

    public int strToInt(String str) {
        int ans = 0;
        int i = 0, sign = 1, n = str.length();
        if (n == 0) {
            return 0;
        }
        while (str.charAt(i) == ' ') {
            i++;
            if (i == n) {
                return 0;
            }
        }
        if (str.charAt(i) == '-') {
            sign = -1;
        }
        if (str.charAt(i) == '-' || str.charAt(i) == '+') {
            i++;
        }
        for (int j = i; j < n; j++) {
            if (!Character.isDigit(str.charAt(j))) {
                break;
            }
            if ((ans > Integer.MAX_VALUE / 10) || (ans == Integer.MAX_VALUE / 10) && str.charAt(j) > '7') {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            ans = ans * 10 + (str.charAt(j) - '0');
        }
        return sign * ans;
    }
}
