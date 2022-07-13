import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 210. 课程表 II
 * https://leetcode.cn/problems/course-schedule-ii/
 */
public class FindOrder {
    public static void main(String[] args) {
        int numCourses = 4;
        int[][] prerequisites = {{1,0},{2,0},{3,1},{3,2}};
    }

    List<List<Integer>> edges;
    int[] inDegree;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }

        inDegree = new int[numCourses];
        for (int[] info : prerequisites) {
            edges.get(info[1]).add(info[0]);
            inDegree[info[0]]++;
        }

        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        int[] ans = new int[numCourses];
        int index = 0;
        while (!queue.isEmpty()) {
            int u = queue.poll();
            ans[index] = u;
            index++;
            for (int v : edges.get(u)) {
                inDegree[v]--;
                if (inDegree[v] == 0) {
                    queue.offer(v);
                }
            }
        }

        return index == numCourses ? ans : new int[0];
    }
}
