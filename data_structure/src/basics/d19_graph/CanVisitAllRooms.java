package basics.d19_graph;

import java.util.*;

public class CanVisitAllRooms {
    public static void main(String[] args) {
        Integer[][] roomsVal = {{1}, {}, {0,3}, {1}};
        List<List<Integer>> rooms = new ArrayList<>();

        for (Integer[] edge : roomsVal) {
            rooms.add(new ArrayList<>(Arrays.asList(edge)));
        }

        boolean res = canVisitAllRooms1(rooms);
        System.out.println(res);
    }

    static boolean[] isVisited;
    static int num;
    public static boolean canVisitAllRooms1(List<List<Integer>> rooms) {
        int n = rooms.size();
        num = 0;
        isVisited = new boolean[n];
        dfs(rooms, 0);
        return num == n;
    }

    private static void dfs(List<List<Integer>> rooms, int x) {
        isVisited[x] = true;
        num++;
        for (int next : rooms.get(x)) {
            if (!isVisited[next]) {
                dfs(rooms, next);
            }
        }
    }

    public static boolean canVisitAllRooms2(List<List<Integer>> rooms) {
        int n = rooms.size();
        int num = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] isVisited = new boolean[n];
        isVisited[0] = true;
        queue.offer(0);
        while (!queue.isEmpty()) {
            int x = queue.poll();
            num++;
            for (int next : rooms.get(x)) {
                if (!isVisited[next]) {
                    isVisited[next] = true;
                    queue.offer(next);
                }
            }
        }
        return num == n;
    }
}
