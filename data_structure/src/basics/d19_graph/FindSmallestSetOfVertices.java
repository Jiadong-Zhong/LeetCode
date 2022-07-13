package basics.d19_graph;

import java.util.*;

/**
 * 1557. 可以到达所有点的最少点数目
 * https://leetcode-cn.com/problems/minimum-number-of-vertices-to-reach-all-nodes/
 */
public class FindSmallestSetOfVertices {
    public static void main(String[] args) {
        int n = 6;
        Integer[][] edgesVal = {{0,1}, {0,2}, {2,5}, {3,4}, {4,2}};
        List<List<Integer>> edges = new ArrayList<>();

        for (Integer[] edge : edgesVal) {
            edges.add(new ArrayList<>(Arrays.asList(edge)));
        }
        System.out.println(edges);
    }

    public static List<Integer> findSmallestSetOfVertices1(int n, List<List<Integer>> edges) {
        List<Integer> res = new ArrayList<>();
        Set<Integer> endSet = new HashSet<>();
        for (List<Integer> edge : edges) {
            endSet.add(edge.get(1));
        }
        for (int i = 0; i < n; i++) {
            if (!endSet.contains(i)) {
                res.add(i);
            }
        }
        return res;
    }
}
