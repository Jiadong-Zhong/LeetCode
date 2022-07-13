import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeSet;

/**
 * 1488. 避免洪水泛滥
 * https://leetcode.cn/problems/avoid-flood-in-the-city/
 */
public class AvoidFlood {
    public static void main(String[] args) {

    }

    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        int[] ans = new int[n];
        Arrays.fill(ans, 1);

        HashMap<Integer, Integer> water = new HashMap<>();
        TreeSet<Integer> tree = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            int r = rains[i];
            if (r == 0) { // 晴天，寸下表
                tree.add(i);
                continue;
            }

            if (water.containsKey(r)) {
                // 下雨天
                // 找到之前一次下雨的的下一个晴天的下标
                Integer t = tree.higher(water.get(r));
                if (t == null) {
                    return new int[0];
                }
                ans[t] = r;
                tree.remove(t); // 移除已经使用过的晴天
            }
            water.put(r, i); // 存放下雨的湖泊
            ans[i] = -1;
        }
        return ans;
    }
}
