import java.util.Arrays;

/**
 * 473. 火柴拼正方形
 * https://leetcode.cn/problems/matchsticks-to-square/
 */
public class Makesquare {
    public static void main(String[] args) {
        int[] matchsticks = {1,1,2,2,2};
        Makesquare solution = new Makesquare();
        boolean ans = solution.makesquare2(matchsticks);
        System.out.println(ans);
    }

    public boolean makesquare1(int[] matchsticks) {
        int totalLen = Arrays.stream(matchsticks).sum();
        if (totalLen % 4 != 0) {
            return false;
        }
        // 从大到小排列
        Arrays.sort(matchsticks);
        for (int i = 0, j = matchsticks.length - 1; i < j; i++, j--) {
            int temp = matchsticks[i];
            matchsticks[i] = matchsticks[j];
            matchsticks[j] = temp;
        }

        int[] edges = new int[4];
        return dfs(0, matchsticks, edges, totalLen / 4);
    }

    public boolean dfs(int index, int[] matchsticks, int[] edges, int len) {
        if (index == matchsticks.length) {
            return true;
        }
        for (int i = 0; i < edges.length; i++) {
            edges[i] += matchsticks[index];
            if (edges[i] <= len && dfs(index + 1, matchsticks, edges, len)) {
                return true;
            }
            edges[i] -= matchsticks[index];
        }
        return false;
    }

    public boolean makesquare2(int[] matchsticks) {
        int totalLen = Arrays.stream(matchsticks).sum();
        if (totalLen % 4 != 0) {
            return false;
        }
        int len = totalLen / 4;
        int n = matchsticks.length;
        int[] dp = new int[1 << n];
        Arrays.fill(dp, -1);
        dp[0] = 0;

        // 用状态 s 记录哪些火柴已经被放入（s 的第 k 位为 1 表示第 k 根火柴已经被放入），dp[s] 表示正方形未放满的边的当前长度
        // s为5位二进制数，例如 00000表示初始状态没有一根火柴放入
        // 注意这里二进制数虽然连续，但是不代表他们的状态是连续的，例如00001和00010是无关的两个状态
        // 相邻的状态应该是汉明距离为1的状态
        // 00001表示第一根火柴已经放入
        // 当遍历到00110时表示第2、3根火柴已经放入，下一状态是00111
        // 在00111时需要放入第一根火柴，这根火柴加上上一状态即00110状态下如果小等于len，则能放入，更新这一状态的dp，如果不能，就看下一个状态01110或是10110
        // 遍历到11111表示所有火柴都放入，如果此时得到的dp[11111]是0，则表示长度刚好，没有多出来的
        for (int s = 1; s < (1 << n); s++) {
             for (int k = 0; k < n; k++) {
                if ((s & (1 << k)) == 0) {
                    // 表示第k根火柴已经被放入，即s的第k位为1
                    // 跳过之前的没放的火柴
                    continue;
                }
                int s1 = s & ~(1 << k);
                if (dp[s1] >= 0 && dp[s1] + matchsticks[k] <= len) {
                    dp[s] = (dp[s1] + matchsticks[k]) % len;
                    break;
                }
            }
        }
        return dp[(1 << n) - 1] == 0;
    }
}
