import java.util.HashSet;
import java.util.Set;

/**
 * 804. 唯一摩尔斯密码词
 * https://leetcode-cn.com/problems/unique-morse-code-words/
 */
public class UniqueMorseRepresentations {
    public static final String[] morseCode = {
            ".-","-...","-.-.","-..",".","..-.","--.","....","..",
            ".---","-.-",".-..","--","-.","---",".--.","--.-",".-."
            ,"...","-","..-","...-",".--","-..-","-.--","--.."};

    public static void main(String[] args) {
        String[] words = {"gin", "zen", "gig", "msg"};
        int res = uniqueMorseRepresentations1(words);
        System.out.println(res);
    }

    public static int uniqueMorseRepresentations1(String[] words) {
        // HashMap<String, Integer> hashMap = new HashMap<>();
        Set<String> seen = new HashSet<>();
        for (String word : words) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                sb.append(morseCode[word.charAt(i) - 'a']);
            }
            // hashMap.put(sb.toString(), hashMap.getOrDefault(sb.toString(), 0) + 1);
            seen.add(sb.toString());
        }
        // return hashMap.size();
        return seen.size();
    }
}
