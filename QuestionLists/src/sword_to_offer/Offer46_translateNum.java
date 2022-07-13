package sword_to_offer;

/**
 * 剑指 Offer 46. 把数字翻译成字符串
 * https://leetcode.cn/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof/
 */
public class Offer46_translateNum {
    public static void main(String[] args) {
        int num = 12258;
        Offer46_translateNum solution = new Offer46_translateNum();
        int ans = solution.translateNum2(num);
        System.out.println(ans);
    }

    // 动态规划
    public int translateNum1(int num) {
        String src = String.valueOf(num);
        int[] dp = new int[src.length()];
        dp[0] = 1;
        for (int i = 1; i < src.length(); i++) {
            dp[i] = dp[i - 1];
            String pre = src.substring(i - 1, i + 1);
            if (pre.compareTo("25") <= 0 && pre.compareTo("10") >= 0) {
                if (i == 1) {
                    dp[i] += 1;
                } else {
                    dp[i] += dp[i - 2];
                }
            }
        }
        return dp[src.length() - 1];
    }

    // 动态规划优化空间
    public int translateNum2(int num) {
        String src = String.valueOf(num);
        int left = 0, right = 0, ans = 1;
        for (int i = 0; i < src.length(); i++) {
            left = right;
            right = ans;
            ans = 0;
            ans += right;
            if (left == 0) {
                continue;
            }
            String pre = src.substring(i - 1, i + 1);
            if (pre.compareTo("25") <= 0 && pre.compareTo("10") >= 0) {
                ans += left;
            }
        }
        return ans;
    }
}
