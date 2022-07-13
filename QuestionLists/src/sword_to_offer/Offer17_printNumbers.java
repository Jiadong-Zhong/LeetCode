package sword_to_offer;

/**
 * 剑指 Offer 17. 打印从1到最大的n位数
 * https://leetcode.cn/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof/
 */
public class Offer17_printNumbers {
    public static void main(String[] args) {
        int n = 1;

    }

    // 直接打印
    public int[] printNumbers1(int n) {
        int max = (int) Math.pow(10, n);
        int[] ans = new int[max - 1];
        for (int i = 1 ; i < max; i++) {
            ans[i - 1] = i;
        }
        return ans;
    }

    // 上述方法没有考虑过越界
    // 因此使用全排列，进行递归
    char[] num;
    int[] ans;
    int count = 0;
    int n;
    public int[] printNumbers2(int n) {
        this.n = n;
        num = new char[n];
        ans = new int[(int) (Math.pow(10, n) - 1)];
        dfs(0);
        return ans;
    }

    private void dfs(int n) {
        if (n == this.n) {
            String temp = String.valueOf(num);
            int curNum = Integer.parseInt(temp);
            if (curNum != 0) {
                ans[count++] = curNum;
            }
            return;
        }
        for (char i = '0'; i <= '9'; i++) {
            num[n] = i;
            dfs(n + 1);
        }
    }
}
