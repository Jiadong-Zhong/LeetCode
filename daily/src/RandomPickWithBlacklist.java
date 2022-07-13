import java.util.*;

/**
 * 710. 黑名单中的随机数
 * https://leetcode.cn/problems/random-pick-with-blacklist/
 */
public class RandomPickWithBlacklist {
    public static void main(String[] args) {
        int n = 7;
        int[] blacklist = {2,3,5};
        Solution solution = new Solution(n, blacklist);
        int param1 = solution.pick();

    }

    static class Solution {

        Map<Integer, Integer> map;
        Random r;
        int size;

        public Solution(int n, int[] blacklist) {
            map = new HashMap<>();
            r = new Random();
            int len = blacklist.length;
            size = n - len;
            Set<Integer> black = new HashSet<>();
            for (int value : blacklist) {
                if (value >= size) {
                    black.add(value);
                }
            }

            int k = size;
            for (int value : blacklist) {
                if (value < size) {
                    while (black.contains(k)) {
                        k++;
                    }
                    map.put(value, k);
                    k++;
                }
            }
        }

        public int pick() {
            int x = r.nextInt(size);
            return map.getOrDefault(x, x);
        }
    }
}


