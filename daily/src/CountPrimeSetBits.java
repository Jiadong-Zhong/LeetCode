/**
 * 762. 二进制表示中质数个计算置位
 * https://leetcode-cn.com/problems/prime-number-of-set-bits-in-binary-representation/
 */
public class CountPrimeSetBits {
    public static void main(String[] args) {
        int res = countPrimeSetBits2(6, 10);

    }

    public static int countPrimeSetBits1(int left, int right) {
        int res = 0;
        for (int i = left; i <= right; i++) {
            String binary = Integer.toBinaryString(i);
            int count = 0;
            for (int j = 0; j < binary.length(); j++) {
                if (binary.charAt(j) == '1') {
                    count++;
                }
            }

            if (isPrime(count)) {
                res++;
            }
        }
        return res;
    }

    public static boolean isPrime(int count) {
        if (count == 1) {
            return false;
        }
        if (count == 2) {
            return true;
        }

        for (int i = 2; i < count; i++) {
            if (count % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static int countPrimeSetBits2(int left, int right) {
        int ans = 0;
        for (int x = left; x <= right; ++x) {
            if (((1 << Integer.bitCount(x)) & 665772) != 0) {
                ++ans;
            }
        }
        return ans;
    }
}
