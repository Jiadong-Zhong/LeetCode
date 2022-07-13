package SwordToOffer2;

/**
 * 剑指 Offer II 001. 整数除法
 * https://leetcode.cn/problems/xoh6Oh/
 */
public class Offer2_1_divide {
    public static void main(String[] args) {
        int a = 15;
        int b = 2;
        Offer2_1_divide solution = new Offer2_1_divide();
        solution.divide(a, b);
    }


    // 减法模拟
    public int divide2(int a, int b) {
        if (a == Integer.MIN_VALUE && b == -1) {
            return Integer.MAX_VALUE;
        }

        int sign = (a > 0) ^ (b > 0) ? -1 : 1;
        if (a > 0) {
            a = -a;
        }
        if (b > 0) {
            b = -b;
        }

        int res = 0;
        while (a <= b) {
            a -= b;
            res++;
        }
        return sign == 1 ? res : -res;
    }

    // 二分
    public int divide(int a, int b) {
        // 被除数为最小值的情况
        if (a == Integer.MIN_VALUE) {
            if (b == 1) {
                return Integer.MIN_VALUE;
            }
            if (b == -1) {
                return Integer.MAX_VALUE;
            }
        }

        // 除数为最小值的情况
        if (b == Integer.MIN_VALUE) {
            return a == Integer.MIN_VALUE ? 1 : 0;
        }

        // 被除数为0的情况
        if (a == 0) {
            return 0;
        }

        // 一般情况
        boolean rev = false;
        if (a > 0) {
            a = -a;
            rev = !rev;
        }
        if (b > 0) {
            b = -b;
            rev = !rev;
        }

        int left = 1, right = Integer.MAX_VALUE, ans = 0;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            boolean check = quickAdd(b, mid, a);
            if (check) {
                ans = mid;
                if (mid == Integer.MAX_VALUE) {
                    break;
                }
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return rev ? -ans : ans;
    }

    // 快速乘
    public boolean quickAdd(int y, int z, int x) {
        // x 和 y 是负数， z是正数
        // 需要判断 z * y >= x 是否成立
        int result = 0, add = y;
        while (z != 0) {
            if ((z & 1) != 0) {
                // 需要保证 result + add >= x
                if (result < x - add) {
                    return false;
                }
                result += add;
            }
            if (z != 1) {
                // 需要保证 add + add >= x
                if (add < x - add) {
                    return false;
                }
                add += add;
            }

            z >>= 1;
        }
        return true;
    }
}
