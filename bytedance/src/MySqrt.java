/**
 * 69. x 的平方根
 * https://leetcode.cn/problems/sqrtx/
 */
public class MySqrt {
    public static void main(String[] args) {
        int x = 8;
        MySqrt solution = new MySqrt();
        int ans = solution.mySqrt2(x);
        System.out.println(ans);
    }

    // 代换
    public int mySqrt1(int x) {
        if (x == 0) {
            return 0;
        }
        int ans = (int) Math.exp(0.5 * Math.log(x));
        return (long) (ans + 1) * (ans + 1) <= x ? ans + 1 : ans;
    }

    // 二分
    public int mySqrt2(int x) {
        int left = 0, right = x, ans = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if ((long) mid * mid <= x) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }


}
