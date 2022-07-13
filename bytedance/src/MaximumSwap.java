/**
 * 670. 最大交换
 * https://leetcode.cn/problems/maximum-swap/
 */
public class MaximumSwap {
    public static void main(String[] args) {
        int num = 7236;
        MaximumSwap solution = new MaximumSwap();
        int ans = solution.maximumSwap(num);
        System.out.println(ans);
    }

    public int maximumSwap(int num) {
        char[] chars = String.valueOf(num).toCharArray();
        int n = chars.length;

        // 记录每个数字最后一次出现的下标
        int[] last = new int[10];
        for (int i = 0; i < n; i++) {
            last[chars[i] - '0'] = i;
        }

        // 找当前位置右边最大的数字进行交换
        for (int i = 0; i < n - 1; i++) {
            // 找最大，所以倒序查找
            for (int d = 9; d > chars[i] - '0'; d--) {
                if (last[d] > i) {
                    swap(chars, i, last[d]);
                    return Integer.parseInt(new String(chars));
                }
            }
        }
        return num;
    }

    public void swap(char[] chars, int i, int j ) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}
