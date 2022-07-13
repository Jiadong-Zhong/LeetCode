import java.util.*;

/**
 * 433. 最小基因变化
 * https://leetcode-cn.com/problems/minimum-genetic-mutation/
 */
public class MinMutation {
    public static void main(String[] args) {
        String start = "AAAAACCC";
        String end = "AACCCCCC";
        String[] bank = {"AAAACCCC", "AAACCCCC", "AACCCCCC"};
        int res = minMutation1(start, end, bank);
        System.out.println(res);
    }

    public static int minMutation1(String start, String end, String[] bank) {
        Set<String> visited = new HashSet<>();
        Set<String> count = new HashSet<>(Arrays.asList(bank));
        char[] keys = {'A', 'C', 'G', 'T'};
        if (start.equals(end)) {
            return 0;
        }
        if (!count.contains(end)) {
            return -1;
        }

        Queue<String> queue = new ArrayDeque<>();
        queue.offer(start);
        visited.add(start);
        int step = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                for (int j = 0; j < 8; j++) {
                    for (int k = 0; k < 4; k++) {
                        if (keys[k] != cur.charAt(j)) {
                            StringBuilder sb = new StringBuilder(cur);
                            sb.setCharAt(j, keys[k]);
                            String next = sb.toString();
                            if (!visited.contains(next) && count.contains(next)) {
                                if (next.equals(end)) {
                                    return step;
                                }
                                queue.offer(next);
                                visited.add(next);
                            }
                        }
                    }
                }
            }
            step++;
        }
        return -1;
    }

    public static int minMutation2(String start, String end, String[] bank) {
        int m = start.length();
        int n = bank.length;
        List<Integer>[] adj = new List[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        int endIndex = -1;
        for (int i = 0; i < n; i++) {
            if (end.equals(bank[i])) {
                endIndex = i;
            }
            for (int j = i + 1; j < n; j++) {
                int mutations = 0;
                for (int k = 0; k < m; k++) {
                    if (bank[i].charAt(k) != bank[j].charAt(k)) {
                        mutations++;
                    }
                    if (mutations > 1) {
                        break;
                    }
                }
                if (mutations == 1) {
                    adj[i].add(j);
                    adj[j].add(i);
                }

            }
        }
        if (endIndex == -1) {
            return -1;
        }

        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[n];
        int step = 1;
        for (int i = 0; i < n; i++) {
            int mutations = 0;
            for (int j = 0; j < m; j++) {
                if (start.charAt(j) != bank[i].charAt(j)) {
                    mutations++;
                }
                if (mutations > 1) {
                    break;
                }
            }
            if (mutations == 1) {
                queue.offer(i);
                visited[i] = true;
            }
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                if (cur == endIndex) {
                    return step;
                }
                for (int next : adj[cur]) {
                    if (visited[next]) {
                        continue;
                    }
                    visited[next] = true;
                    queue.offer(next);
                }
            }
            step++;
        }
        return -1;
    }
}
