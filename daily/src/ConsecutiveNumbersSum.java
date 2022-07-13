/**
 * 829. 连续整数求和
 * https://leetcode.cn/problems/consecutive-numbers-sum/
 */
public class ConsecutiveNumbersSum {
    public static void main(String[] args) {
        int n = 15;
        ConsecutiveNumbersSum solution = new ConsecutiveNumbersSum();
        int ans = solution.consecutiveNumbersSum1(n);
        System.out.println(ans);
    }

    // 数学
    public int consecutiveNumbersSum1(int n) {
        int ans = 0;
        int bound = 2 * n;
        for (int k = 1; k * (k + 1) <= bound; k++) {
            if (isKConsecutive(n, k)) {
                ans++;
            }
        }
        return ans;
    }

    public boolean isKConsecutive(int n, int k) {
        if (k % 2 == 1) {
            return n % k == 0;
        } else {
            return n % k != 0 && 2 * n % k == 0;
        }
    }
}
