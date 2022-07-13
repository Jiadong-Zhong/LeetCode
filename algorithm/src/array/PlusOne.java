package array;

import java.util.Arrays;

/**
 * 加一
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2cv1c/
 */
public class PlusOne {
    public static void main(String[] args) {
        int[] digits = {1, 2, 3};
        int[] ans = plusOne1(digits);
        System.out.println(Arrays.toString(ans));
    }

    public static int[] plusOne1(int[] digits) {
        int len = digits.length;
        for (int i = len - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                digits[i]++;
                return digits;
            } else {
                digits[i] = 0;
            }
        }
        int[] temp = new int[len + 1];
        temp[0] = 1;
        return temp;
    }
}
