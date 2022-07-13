import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 1297. 子串的最大出现次数
 * https://leetcode.cn/problems/maximum-number-of-occurrences-of-a-substring/
 */
public class MaxFreq {
    public static void main(String[] args) {
        String s = "aababcaab";
        int maxLetters = 2;
        int maxSize = 4;
        int minSize = 3;
        MaxFreq solution = new MaxFreq();
        int ans = solution.maxFreq(s, maxLetters, minSize, maxSize);
        System.out.println(ans);
    }

    // 如果子串在s中出现了k次，则子串的子串在s中野至少出现k次，因此只需要切割minSize即可
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i <= s.length() - minSize; i++) {
            String str = s.substring(i, i + minSize);
            Set<Character> set = new HashSet<>();
            for (char ch : str.toCharArray()) {
                set.add(ch);
            }
            if (set.size() <= maxLetters) {
                map.put(str, map.getOrDefault(str, 0) + 1);
            }
        }
        int ans = 0;
        for (String st : map.keySet()) {
            ans = Math.max(ans, map.get(st));
        }
        return ans;
    }
}
