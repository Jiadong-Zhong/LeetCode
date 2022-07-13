import java.util.Arrays;

/**
 * 953. 验证外星语词典
 * https://leetcode.cn/problems/verifying-an-alien-dictionary/
 */
public class IsAlienSorted {
    public static void main(String[] args) {
        String[] words = {"apple", "app"};
        String order = "hlabcdefgijkmnopqrstuvwxyz";

        boolean res = isAlienSorted1(words, order);
        System.out.println(res);

    }

    public static boolean isAlienSorted1(String[] words, String order) {
        String[] sortedWords = Arrays.copyOf(words, words.length);
        Arrays.sort(sortedWords, (o1, o2) -> {
            int index = 0;
            while (index < o1.length() && index < o2.length()) {
                if (order.indexOf(o1.charAt(index)) > order.indexOf(o2.charAt(index))) {
                    return 1;
                } else if (order.indexOf(o1.charAt(index)) < order.indexOf(o2.charAt(index))) {
                    return -1;
                } else {
                    index++;
                }
            }
            if (index == o1.length()) {
                return -1;
            } else if (index == o2.length()) {
                return 1;
            } else {
                return 0;
            }
        });

        for (int i = 0; i < sortedWords.length; i++) {
            if (!sortedWords[i].equals(words[i])) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAlienSorted2(String[] words, String order) {
        int[] index = new int[26];
        for (int i = 0; i < order.length(); i++) {
            index[order.charAt(i) - 'a'] = i;
        }
        for (int i = 1; i < words.length; i++) {
            boolean valid = false;
            for (int j = 0; j < words[i - 1].length() && j < words[i].length(); j++) {
                int prev = index[words[i - 1].charAt(j) - 'a'];
                int curr = index[words[i].charAt(j) - 'a'];
                if (prev < curr) {
                    valid = true;
                    break;
                } else if (prev > curr) {
                    return false;
                }
            }
            if (!valid) {
                if (words[i - 1].length() > words[i].length()) {
                    return false;
                }
            }
        }
        return true;
    }
}
