import java.util.*;

/**
 * 剑指 Offer II 114. 外星文字典
 * https://leetcode.cn/problems/Jf1JuT/
 * 关键词：拓扑排序
 */
public class AlienOrder {
    public static void main(String[] args) {
        String[] words = {"wrt","wrf","er","ett","rftt"};
        AlienOrder solution = new AlienOrder();
        solution.alienOrder1(words);
    }

    public String alienOrder1(String[] words) {
        Map<Character, Set<Character>> graph = new HashMap<>();
        Map<Character, Integer> inDegrees = new HashMap<>();
        for (String word : words) {
            for (char ch : word.toCharArray()) {
                graph.putIfAbsent(ch, new HashSet<>());
                inDegrees.putIfAbsent(ch, 0);
            }
        }

        for (int i = 1; i < words.length; i++) {
            String w1 = words[i - 1];
            String w2 = words[i];
            if (w1.startsWith(w2) && !w1.equals(w2)) {
                return "";
            }
            for (int j = 0; j < w1.length() && j < w2.length(); j++) {
                char ch1 = w1.charAt(j);
                char ch2 = w2.charAt(j);
                if (ch1 != ch2) {
                    if (!graph.get(ch1).contains(ch2)) {
                        graph.get(ch1).add(ch2);
                        inDegrees.put(ch2, inDegrees.get(ch2) + 1);
                    }
                    break;
                }
            }
        }

        Queue<Character> queue = new ArrayDeque<>();
        for (char ch : inDegrees.keySet()) {
            if (inDegrees.get(ch) == 0) {
                queue.add(ch);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            char ch = queue.remove();
            sb.append(ch);
            for (char next : graph.get(ch)) {
                inDegrees.put(next, inDegrees.get(next) - 1);
                if (inDegrees.get(next) == 0) {
                    queue.add(next);
                }
            }
        }

        return sb.length() == graph.size() ? sb.toString() : "";
    }
}
