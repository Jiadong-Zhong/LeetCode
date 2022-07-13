package basics.d9_string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 187. 重复的DNA序列
 * https://leetcode-cn.com/problems/repeated-dna-sequences/
 */
public class FindRepeatedDnaSequences {
    public static void main(String[] args) {
        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        String s1 = "AAAAAAAAAAAAA";
        String s2 = "AAAAAAAAAAA";
        List<String> res = findRepeatedDnaSequences2(s);
        System.out.println(res);
    }

    public static List<String> findRepeatedDnaSequences1(String s) {
        List<String> res = new ArrayList<>();
        int len = s.length();
        if (len <= 10) {
            return res;
        }
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < len - 9; i++) {
            String subString = s.substring(i, i + 10);
            map.put(subString, map.getOrDefault(subString, 0) + 1);
            if (map.get(subString) == 2) {
                res.add(subString);
            }
        }
        return res;
    }

    static final int L = 10;
    static Map<Character, Integer> bin = new HashMap<Character, Integer>() {{
        put('A', 0);
        put('C', 1);
        put('G', 2);
        put('T', 3);
    }};

    public static List<String> findRepeatedDnaSequences2(String s) {
        List<String> ans = new ArrayList<>();
        int n = s.length();
        if (n <= L) {
            return ans;
        }
        int x = 0;
        for (int i = 0; i < L - 1; ++i) {
            x = (x << 2) | bin.get(s.charAt(i));
            System.out.println(bin.get(s.charAt(i)));
            System.out.println(Integer.toBinaryString(x));
            System.out.println();
        }
        System.out.println("--------------------");
        Map<Integer, Integer> cnt = new HashMap<>();
        System.out.println(Integer.toBinaryString((1 << (L * 2)) - 1));
        for (int i = 0; i <= n - L; ++i) {
            x = ((x << 2) | bin.get(s.charAt(i + L - 1))) & ((1 << (L * 2)) - 1);

            System.out.println(bin.get(s.charAt(i + L - 1)));
            System.out.println(Integer.toBinaryString(x));
            System.out.println();

            cnt.put(x, cnt.getOrDefault(x, 0) + 1);
            if (cnt.get(x) == 2) {
                ans.add(s.substring(i, i + L));
            }
        }
        return ans;
    }
}
