/**
 * 788. 旋转数字
 * https://leetcode.cn/problems/rotated-digits/
 */
public class RotateDigits {
    public static void main(String[] args) {
        int n = 10;
        RotateDigits solution = new RotateDigits();
        int ans = solution.rotatedDigits(n);
        System.out.println(ans);
    }

    // 枚举每一个数
    static int[] check = {0, 0, 1, -1, -1, 1, 1, -1, 0, 1};
    public int rotatedDigits(int n) {
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            String num = String.valueOf(i);
            boolean valid = true, diff = false;
            for (int j = 0; j < num.length(); j++) {
                char ch = num.charAt(j);
                if (check[ch - '0'] == -1) {
                    valid = false;
                } else if (check[ch - '0'] == 1) {
                    diff = true;
                }
            }
            if (valid && diff) {
                ans++;
            }
        }
        return ans;
    }
}
