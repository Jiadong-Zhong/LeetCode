/**
 * 868. 二进制间距
 * https://leetcode-cn.com/problems/binary-gap/
 */
public class BinaryGap {
    public static void main(String[] args) {
        int n = 8;
        int res = binaryGap1(n);
        System.out.println(res);
    }

    public static int binaryGap1(int n) {
        String s = Integer.toBinaryString(n);
        int res = 0;

        int start = -1;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                if (start != -1) {
                    count = i - start;
                    res = Math.max(count, res);
                }
                start = i;
            }
        }
        return res;
    }

    public static int binaryGap2(int n) {
        int last = -1;
        int ans = 0;
        for (int i = 0; n != 0; i++) {
            if ((n & 1) == 1) {
                if (last != -1) {
                    ans = Math.max(ans, i - last);
                }
                last = i;
            }
            n >>= 1;
        }
        return ans;
    }
}
