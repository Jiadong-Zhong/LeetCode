/**
 * 887. 鸡蛋掉落
 * https://leetcode.cn/problems/super-egg-drop/
 */
public class SuperEggDrop {
    public static void main(String[] args) {
        int k = 1;
        int n = 2;
    }

    // 逆向思维
    public int superEggDrop(int k, int n) {
        if (n == 1) {
            return 1;
        }

        // f[t][k]表示可以做t次操作，有k个鸡蛋，能找到最高的n是多少
        int[][] f = new int[n + 1][k + 1];

        // 如果t = 1表示只能做1次操作，不论有多少个鸡蛋，都只能找到1层楼
        for (int j = 1; j <= k; j++) {
            f[1][j] = 1;
        }

        int ans = -1;

        // 操作数的上限不超过楼层数，因为当一层一层尝试时，也最多操作n次
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                // 如果鸡蛋碎了，那么对应的就是f[t -1][k -1]即操作数和鸡蛋数都减1，说明这一层的下方有f[t - 1][k - 1]层
                // 如果鸡蛋没碎，那么对应f[t - 1][k]即操作数减1
                f[i][j] = 1 + f[i - 1][j - 1] + f[i - 1][j];
            }

            // 如果当前能确定的楼层比n大，就更新最小操作数，即i
            // 因为是从小到大遍历操作数的，因此第一次更新i时就得到的是最小的操作数
            if (f[i][k] >= n) {
                ans = i;
                break;
            }
        }
        return ans;
    }

}
