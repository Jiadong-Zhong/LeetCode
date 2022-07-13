package hot100;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 207. 课程表
 * https://leetcode.cn/problems/course-schedule/
 */
public class Hot100_61_canFinish {
    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = {{1,0}};
    }

    // 深度优先搜索
    List<List<Integer>> edges;
    int[] visited; // 值为0表示未搜索，为1表示搜索中，为2表示已完成
    boolean valid = true;
    public boolean canFinish1(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }
        visited = new int[numCourses];
        for (int[] info : prerequisites) {
            edges.get(info[1]).add(info[0]);
        }

        for (int i = 0; i < numCourses && valid; i++) {
            if (visited[i] == 0) {
                dfs(i);
            }
        }
        return valid;
    }

    public void dfs(int u) {
        visited[u] = 1;
        for (int v : edges.get(u)) {
            if (visited[v] == 0) {
                dfs(v);
                if (!valid) {
                    return;
                }
            } else if (visited[v] == 1) {
                valid = false;
                return;
            }
        }
        visited[u] = 2;
    }

    // 广度优先搜索
    // 用于存储边上面dfs方法已经创建过
    int[] inDegree;
    public boolean canFinish2(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<>();
        for (int i = 0; i< numCourses; i++) {
            edges.add(new ArrayList<>());
        }
        inDegree = new int[numCourses];
        for (int[] info : prerequisites) {
            edges.get(info[1]).add(info[0]);
            inDegree[info[0]]++;
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        int visited = 0;
        while (!queue.isEmpty()) {
            visited++;
            int u = queue.poll();
            for (int v : edges.get(u)) {
                inDegree[v]--;
                if (inDegree[v] == 0) {
                    queue.offer(v);
                }
            }
        }
        return visited == numCourses;
    }
}
