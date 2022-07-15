package SwordToOffer2;

import java.util.*;

/**
 * 剑指 Offer II 005. 单词长度的最大乘积
 * https://leetcode.cn/problems/aseY1I/
 */
public class Offer2_5_maxProduct {
    public static void main(String[] args) {
        String[] words = {"eae","ea","aaf","bda","fcf","dc","ac","ce","cefde","dabae"};
        Offer2_5_maxProduct solution = new Offer2_5_maxProduct();
        int ans = solution.maxProduct(words);
        System.out.println(ans);
    }

    // 自己写的，暴力解法
    public int maxProduct(String[] words) {
        int ans = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (!hasCommonLetter(words[i], words[j])) {
                    ans = Math.max(ans, words[i].length() * words[j].length());
                }
            }
        }
        return ans;
    }

    public boolean hasCommonLetter(String word1, String word2) {
        Set<Character> set = new HashSet<>();
        for (char c : word1.toCharArray()) {
            set.add(c);
        }

        for (char c : word2.toCharArray()) {
            if (set.contains(c)) {
                return true;
            }
        }
        return false;
    }

    // 位运算
    public int maxProduct1(String[] words) {
        int len = words.length;
        int[] masks = new int[len];
        for (int i = 0; i < len; i++) {
            String word = words[i];
            int wordLen = word.length();
            for (int j = 0; j < wordLen; j++) {
                masks[i] |= 1 << (word.charAt(j) - 'a');
            }
        }

        int maxProd = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if ((masks[i] & masks[j]) == 0) {
                    maxProd = Math.max(maxProd, words[i].length() * words[j].length());
                }
            }
        }
        return maxProd;
    }

    // 位运算优化
    // 如果有多个单词的位掩码相同，则只需要记录该位掩码对应的最大单词长度即可
    public int maxProduct2(String[] words) {
        Map<Integer, Integer> map = new HashMap<>();
        int len = words.length;
        for (int i = 0; i < len; i++) {
            int mask = 0;
            String word = words[i];
            int wordLen = word.length();
            for (int j = 0; j < wordLen; j++) {
                mask |= 1 << (word.charAt(j) - 'a');
            }
            if (wordLen > map.getOrDefault(mask, 0)) {
                map.put(mask, wordLen);
            }
        }

        int maxProd = 0;
        Set<Integer> maskSet = map.keySet();
        for (int mask1 : maskSet) {
            int wordLen1 = map.get(mask1);
            for (int mask2 : maskSet) {
                if ((mask1 & mask2) == 0) {
                    int wordLen2 = map.get(mask2);
                    maxProd = Math.max(maxProd, wordLen1 * wordLen2);
                }
            }
        }
        return maxProd;
    }
}
