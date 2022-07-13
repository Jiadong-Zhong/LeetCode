/**
 * 9. 回文数
 * https://leetcode.cn/problems/palindrome-number/
 */
public class IsPalindrome {
    // 反转一半的数字
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }
        return  x == revertedNumber || x == revertedNumber / 10;
    }
}
