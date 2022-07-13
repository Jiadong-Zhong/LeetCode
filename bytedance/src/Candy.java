/**
 * 135. 分发糖果
 * https://leetcode.cn/problems/candy/
 */
public class Candy {
    public static void main(String[] args) {
        int[] ratings = {1,3,5,3,2,1};
        Candy solution = new Candy();
        int ans = solution.candy1(ratings);
        System.out.println(ans);
    }

    // 两次遍历
    public int candy1(int[] ratings) {
        int n = ratings.length;
        int[] left = new int[n];
        for (int i = 0; i < n; i++) {
            if (i > 0 && ratings[i] > ratings[i - 1]) {
                left[i] = left[i - 1] + 1;
            } else {
                left[i] = 1;
            }
        }
        int right = 0, res = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (i < n - 1 && ratings[i] > ratings[i + 1]) {
                right++;
            } else {
                right = 1;
            }
            res += Math.max(left[i], right);
        }
        return res;
    }

    // 常数空间遍历
    public int candy2(int[] ratings) {
        int n = ratings.length;
        int res = 1;
        int inc = 1, dec = 0, pre = 1;
        for (int i = 1; i < n; i++) {
            if (ratings[i] >= ratings[i - 1]) {
                dec = 0;
                pre = ratings[i] == ratings[i - 1] ? 1 : pre + 1;
                res += pre;
                inc = pre;
            } else {
                dec++;
                if (dec == inc) {
                    dec++;
                }
                res += dec;
                pre = 1;
            }
        }
        return res;
    }
}
