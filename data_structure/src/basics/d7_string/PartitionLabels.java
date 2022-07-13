package basics.d7_string;

import java.util.ArrayList;
import java.util.List;

/**
 * 763. 划分字母区间
 * https://leetcode-cn.com/problems/partition-labels/
 */
public class PartitionLabels {
    public static void main(String[] args) {
        String s = "ababcbacadefegdehijhklij";
        List<Integer> res = partitionLabels1(s);
        System.out.println(res);
    }

    public static List<Integer> partitionLabels1(String s) {
        int n = s.length();
        int[] last = new int[26];
        for (int i = 0; i < n; i++) {
            last[s.charAt(i) - 'a'] = i;
        }

        List<Integer> partition = new ArrayList<>();
        int start = 0;
        int end = 0;
        for (int i = 0; i < n; i++) {
            end = Math.max(end, last[s.charAt(i) - 'a']);
            if (i == end) {
                partition.add(end - start + 1);
                start = end + 1;
            }
        }
        return partition;
    }
}
