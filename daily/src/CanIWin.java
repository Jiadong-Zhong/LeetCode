import java.util.HashMap;
import java.util.Map;

/**
 * 464. 我能赢吗
 * https://leetcode.cn/problems/can-i-win/
 *
 * 位运算和状态压缩DP这种类型的题还是不是很懂
 */
public class CanIWin {
    public static void main(String[] args) {
        int maxChoosableInteger = 10;
        int desiredTotal = 40;
        CanIWin solution = new CanIWin();
        boolean ans = solution.canIWin1(maxChoosableInteger, desiredTotal);
        System.out.println(ans);
    }

    Map<Integer, Boolean> memory = new HashMap<>();

    public boolean canIWin1(int maxChoosableInteger, int desiredTotal) {
        if ((1 + maxChoosableInteger) * maxChoosableInteger / 2 < desiredTotal) {
            return false;
        }
        return dfs(maxChoosableInteger, 0, desiredTotal, 0);
    }

    public boolean dfs(int maxChoosableInteger, int usedNumbers, int desiredTotal, int currentTotal) {
        if (!memory.containsKey(usedNumbers)) {
            boolean res = false;
            for (int i = 0; i < maxChoosableInteger; i++) {
                if (((usedNumbers >> i) & 1) == 0) {
                    if (i + 1 + currentTotal >= desiredTotal) {
                        res = true;
                        break;
                    }
                    boolean flag = dfs(maxChoosableInteger, usedNumbers | (1 << i), desiredTotal, currentTotal + i + 1);
                    if (!flag) {
                        res = true;
                        break;
                    }
                }
            }
            memory.put(usedNumbers, res);
        }
        return memory.get(usedNumbers);
    }
}
