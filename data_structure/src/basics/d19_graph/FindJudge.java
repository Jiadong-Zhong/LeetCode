package basics.d19_graph;

/**
 * 997. 找到小镇的法官
 * https://leetcode-cn.com/problems/find-the-town-judge/
 */
public class FindJudge {
    public static void main(String[] args) {
        int n = 3;
        int[][] trust = {{1,3},{2,3},{3,1}};
        int res = findJudge1(n, trust);
        System.out.println(res);
    }

    public static int findJudge1(int n, int[][] trust) {
        int[] inDegrees = new int[n + 1];
        int[] outDegrees = new int[n + 1];
        for (int[] edge : trust) {
            inDegrees[edge[1]]++;
            outDegrees[edge[0]]++;
        }
        for (int i = 1; i <= n; i++) {
            if (inDegrees[i] == n - 1 && outDegrees[i] == 0) {
                return i;
            }
        }
        return -1;
    }
}
