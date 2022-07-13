import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 面试题 17.11. 单词距离
 * https://leetcode.cn/problems/find-closest-lcci/
 */
public class FindClosest {
    public static void main(String[] args) {
        String[] words = {"I","am","a","student","from","a","university","in","a","city"};
        String word1 = "a";
        String word2 = "student";
        FindClosest solution = new FindClosest();
        int ans = solution.findClosest1(words, word1, word2);
        System.out.println(ans);

    }

    // 自己写的暴力解法
    public int findClosest1(String[] words, String word1, String word2) {
        Map<String, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            List<Integer> list = map.getOrDefault(words[i], new ArrayList<>());
            list.add(i);
            map.put(words[i], list);
        }
        if (map.containsKey(word1) && map.containsKey(word2)) {
            List<Integer> index1 = map.get(word1);
            List<Integer> index2 = map.get(word2);
            int minDistance = Integer.MAX_VALUE;
            for (Integer i1 : index1) {
                for (Integer i2 : index2) {
                    minDistance = Math.min(minDistance, Math.abs(i1 - i2));
                }
            }
            return minDistance;
        }
        return -1;
    }

    public int findClosest2(String[] words, String word1, String word2) {
        int len = words.length;
        int ans = len;
        int index1 = -1, index2 = -1;
        for (int i = 0; i < len; i++) {
            String word = words[i];
            if (word.equals(word1)) {
                index1 = i;
            } else if (word.equals(word2)) {
                index2 = i;
            }
            if (index1 >= 0 && index2 >= 0) {
                ans = Math.min(ans, Math.abs(index1 - index2));
            }
        }
        return ans;
    }
}
