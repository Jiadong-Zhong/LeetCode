import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindSubstring {
    public static void main(String[] args) {
        String s = "barfoothefoobarman";
        String[] words = {"foo", "bar"};
        FindSubstring solution = new FindSubstring();
        List<Integer> ans = solution.findSubstring(s, words);
        System.out.println(ans);
    }

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return ans;
        }
        int wordNum = words.length, oneWord = words[0].length(), totalLen = oneWord * wordNum;
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        for (int i = 0 ; i < oneWord; i++) {
            int left = i, right = i, count = 0;
            Map<String, Integer> temp = new HashMap<>();
            while (right + oneWord <= s.length()) {
                String w = s.substring(right, right + oneWord);
                right += oneWord;
                if (!map.containsKey(w)) {
                    count = 0;
                    left = right;
                    temp.clear();
                } else {
                    temp.put(w, temp.getOrDefault(w, 0) + 1);
                    count++;
                    while (temp.getOrDefault(w, 0) > map.getOrDefault(w, 0)) {
                        String tempWord = s.substring(left, left + oneWord);
                        count--;
                        temp.put(tempWord, temp.getOrDefault(tempWord, 0) - 1);
                        left += oneWord;
                    }
                    if (count == wordNum) {
                        ans.add(left);
                    }
                }
            }
        }
        return ans;
    }
}
