package basics.d21_priority_queue;

import java.util.*;

/**
 * 451. 根据字符出现频率排序
 * https://leetcode-cn.com/problems/sort-characters-by-frequency/
 */
public class FrequencySort {
    public static void main(String[] args) {
        String s = "treee";
        String res = frequencySort2(s);
        System.out.println(res);
    }

    public static String frequencySort1(String s) {
        HashMap<Character, Integer> counts = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            counts.put(s.charAt(i), counts.getOrDefault(s.charAt(i), 0) + 1);
        }

        List<Character> list = new ArrayList<>(counts.keySet());
        list.sort(((o1, o2) -> counts.get(o2) - counts.get(o1)));
        StringBuilder res = new StringBuilder();
        for (char c : list) {
            for (int j = 0; j < counts.get(c); j++) {
                res.append(c);
            }
        }
        return res.toString();
    }

    public static String frequencySort2(String s) {
        HashMap<Character, Integer> counts = new HashMap<>();
        int maxFreq = 0;
        for (int i = 0; i < s.length(); i++) {
            int frequency = counts.getOrDefault(s.charAt(i), 0) + 1;
            counts.put(s.charAt(i), frequency);
            maxFreq = Math.max(maxFreq, frequency);
        }

        StringBuilder[] buckets = new StringBuilder[maxFreq + 1];
        for (int i = 0; i <= maxFreq; i++) {
            buckets[i] = new StringBuilder();
        }
        for (Map.Entry<Character, Integer> entry : counts.entrySet()) {
            char c = entry.getKey();
            int freq = entry.getValue();
            buckets[freq].append(c);
        }
        System.out.println(Arrays.toString(buckets));
        StringBuilder res = new StringBuilder();
        for (int i = maxFreq; i > 0; i--) {
            StringBuilder bucket = buckets[i];
            int size = bucket.length();
            for (int j = 0; j < size; j++) {
                for (int k = 0; k < i; k++) {
                    res.append(bucket.charAt(j));
                }
            }
        }
        return res.toString();
    }
}
