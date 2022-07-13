package string;

/**
 * 整数反转
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnx13t/
 */
public class ReverseInt {
    public static void main(String[] args) {
        int x = 123;
        int ans = reverse1(x);
        System.out.println(ans);
    }

    public static int reverse1(int x) {
        int res = 0;
        while(x != 0) {
            int t = x % 10;
            int newRes = res * 10 + t;
            if ((newRes - t) / 10 != res) {
                return 0;
            }
            res = newRes;
            x /= 10;
        }
        return res;
    }

    public static int reverse2(int x) {
        long res = 0;
        while (x != 0) {
            res = res * 10 + x % 10;
            x /= 10;
        }
        return (int) res == res ? (int) res : 0;
    }

    public static int reverse3(int x) {
        int rev = 0;
        while (x != 0) {
            if (rev < Integer.MIN_VALUE / 10 || rev > Integer.MAX_VALUE / 10) {
                return 0;
            }
            int digit = x % 10;
            x /= 10;
            rev = rev * 10 + digit;
        }
        return rev;
    }
}
