package hot100;

import java.util.HashMap;
import java.util.Map;

/**
 * 76. 最小覆盖子串
 * https://leetcode.cn/problems/minimum-window-substring/
 */
public class Hot100_32_minWindow {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";

        Hot100_32_minWindow solution = new Hot100_32_minWindow();
        String ans = solution.minWindow1(s, t);
        System.out.println(ans);
    }

    public String minWindow1(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        if (sLen == 0 || tLen == 0 || sLen < tLen) {
            return "";
        }

        char[] charArrayS = s.toCharArray();
        char[] charArrayT = t.toCharArray();

        int[] winFreq = new int[128];
        int[] tFreq = new int[128];

        // 目标字符串指定字符的出现次数记录
        for (char c : charArrayT) {
            tFreq[c]++;
        }

        // 滑动窗口内部包含了多少T中的字符，对应字符频数超过不重复计算
        int distance = 0;
        int minLen = sLen + 1;
        int begin = 0;

        // [left, right) 左闭右开
        int left = 0;
        int right = 0;
        while (right < sLen) {
            char charRight = charArrayS[right];

            /*
             说明该字符不被目标字符串需要，此时由两种情况
             1.循环刚开始，那么直接移动右指针即可，不需要多判断
             2.循环已经开始一段时间，又有两种情况
                2.1 上一次条件不满足，已有字符串指定字符出现次数不满足目标字符串指定字符出现次数
                    那么此时如果该字符还不被目标字符串需要，右指针移动
                2.2 左指针已经移动完毕，那么就相当于循环刚开始，同理移动右指针
             */
            if (tFreq[charRight] == 0) {
                right++;
                continue;
            }

            /*
             当且仅当已有字符串目标字符出现的次数小于目标字符串字符的出现字符时，count才+1
             是为了后续能直接判断已有字符串是否已经包含了目标字符串的所有字符，不需要逐个比对字符出现的次数
             */
            if (winFreq[charRight] < tFreq[charRight]) {
                distance++;
            }
            // 已有字符串目标字符出现次数+1
            winFreq[charRight]++;
            // 移动右指针
            right++;


            // 当且仅当已有字符串已经覆盖了所有目标字符串的字符，且出现频次一定大于或等于指定频次
            while (distance == tLen) {
                // 当窗口的长度比已有的最小值小时，更新最小值
                if (right - left < minLen) {
                    minLen = right - left;
                    begin = left;
                }

                char charLeft = charArrayS[left];
                // 如果左边即将要丢掉的字符不被目标字符串需要，那么可以直接移动左指针
                if (tFreq[charLeft] == 0) {
                    left++;
                    continue;
                }

                /*
                 如果即将去掉的字符被目标字符串需要，且出现频次刚好等于指定频次，那么如果去掉这个字符
                 那么就不满足覆盖子串的条件，此时要破坏循环条件跳出循环，即目标字符串指定字符的出现总频次distance - 1
                 */
                if (winFreq[charLeft] == tFreq[charLeft]) {
                    distance--;
                }
                // 已有字符串目标字符出现次数-1
                winFreq[charLeft]--;
                // 移动左指针
                left++;
            }

        }

        if (minLen == sLen + 1) {
            return "";
        } else {
            return s.substring(begin, begin + minLen);
        }
    }

    public String minWindow2(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        if (sLen == 0 || tLen == 0 || sLen < tLen) {
            return "";
        }

        char[] charArrayS = s.toCharArray();
        char[] charArrayT = t.toCharArray();

        // 窗口内部覆盖T还需要的各个字符的个数
        int[] tFreq = new int[128];

        for (char c : charArrayT) {
            tFreq[c]++;
        }

        // 滑动窗口内部还差多少T中的字符，对应字符频数超过不重复计算
        int distance = tLen;
        int minLen = sLen + 1;
        int begin = 0;

        // [left, right) 左闭右开
        int left = 0;
        int right = 0;
        while (right < sLen) {
            char charRight = charArrayS[right];

            if (tFreq[charRight] > 0) {
                distance--;
            }

            tFreq[charRight]--;
            right++;

            while (distance == 0) {

                if (right - left < minLen) {
                    minLen = right - left;
                    begin = left;
                }

                char charLeft = charArrayS[left];

                if (tFreq[charLeft] == 0) {
                    distance++;
                }
                tFreq[charLeft]++;
                left++;
            }

        }

        if (minLen == sLen + 1) {
            return "";
        } else {
            return s.substring(begin, begin + minLen);
        }
    }

    // 官方文字题解
    Map<Character, Integer> ori = new HashMap<>();
    Map<Character, Integer> cnt = new HashMap<>();
    public String minWindow3(String s, String t) {
        int tLen = t.length();
        for (int i = 0; i < tLen; i++) {
            char c = t.charAt(i);
            ori.put(c, ori.getOrDefault(c, 0) + 1);
        }
        int left = 0, right = -1;
        int len = s.length() + 1, ansL = -1, ansR = -1;
        int sLen = s.length();
        while (right < sLen) {
            right++;
            if (right < sLen && ori.containsKey(s.charAt(right))) {
                cnt.put(s.charAt(right), cnt.getOrDefault(s.charAt(right), 0) + 1);
            }
            while (check() && left <= right) {
                if (right - left + 1 < len) {
                    len = right - left + 1;
                    ansL = left;
                    ansR = left + len;
                }
                if (ori.containsKey(s.charAt(left))) {
                    cnt.put(s.charAt(left), cnt.getOrDefault(s.charAt(left), 0) - 1);
                }
                left++;
            }
        }
        return ansL == -1 ? "" : s.substring(ansL, ansR);
    }

    // 检查窗口内字符是否全部覆盖目标字符
    public boolean check() {
        for (Map.Entry<Character, Integer> entry : ori.entrySet()) {
            Character key = entry.getKey();
            Integer val = entry.getValue();
            if (cnt.getOrDefault(key, 0) < val) {
                return false;
            }
        }
        return true;
    }
}
