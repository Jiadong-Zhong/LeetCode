import java.util.*;

/**
 * 819. 最常见的单词
 * https://leetcode-cn.com/problems/most-common-word/
 */
public class MostCommonWord {
    public static void main(String[] args) {
        String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String paragraph1 = "a, a, a, a, b,b,b,c, c";
        String[] banned = {"hit"};
        String[] banned1 = {"a"};
        String res = mostCommonWord1(paragraph1, banned1);
        System.out.println(res);
    }

    public static String mostCommonWord1(String paragraph, String[] banned) {
        paragraph = paragraph.replaceAll("[!?',;.]", " ").toLowerCase(Locale.ROOT);
        for (String s : banned) {
            paragraph = paragraph.replaceAll(s, "");
        }
        String[] wordArray = paragraph.split(" ");

        Map<String, Integer> hashmap = new HashMap<>();
        for (String s : wordArray) {
            if (!s.equals("")) {
                hashmap.put(s, hashmap.getOrDefault(s, 0) + 1);
            }
        }

        int count = -1;
        String res = "";
        for (Map.Entry<String, Integer> entry : hashmap.entrySet()) {
            if (entry.getValue() > count) {
                count = entry.getValue();
                res = entry.getKey();
            }
        }
        return res;
    }

    public String mostCommonWord2(String paragraph, String[] banned) {
        Set<String> bannedSet = new HashSet<String>();
        for (String word : banned) {
            bannedSet.add(word);
        }
        int maxFrequency = 0;
        Map<String, Integer> frequencies = new HashMap<String, Integer>();
        StringBuffer sb = new StringBuffer();
        int length = paragraph.length();
        for (int i = 0; i <= length; i++) {
            if (i < length && Character.isLetter(paragraph.charAt(i))) {
                sb.append(Character.toLowerCase(paragraph.charAt(i)));
            } else if (sb.length() > 0) {
                String word = sb.toString();
                if (!bannedSet.contains(word)) {
                    int frequency = frequencies.getOrDefault(word, 0) + 1;
                    frequencies.put(word, frequency);
                    maxFrequency = Math.max(maxFrequency, frequency);
                }
                sb.setLength(0);
            }
        }
        String mostCommon = "";
        Set<Map.Entry<String, Integer>> entries = frequencies.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            String word = entry.getKey();
            int frequency = entry.getValue();
            if (frequency == maxFrequency) {
                mostCommon = word;
                break;
            }
        }
        return mostCommon;
    }


}
