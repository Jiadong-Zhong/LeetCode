import java.util.*;

/**
 * 749. 隔离病毒
 * https://leetcode.cn/problems/contain-virus/
 */
public class ContainVirus {
    public static void main(String[] args) {
        int[][] isInfected = {{0,1,0,0,0,0,0,1},{0,1,0,0,0,0,0,1},{0,0,0,0,0,0,0,1},{0,0,0,0,0,0,0,0}};
        ContainVirus solution = new ContainVirus();
        int ans = solution.containVirus(isInfected);
        System.out.println(ans);
    }

    int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
    public int containVirus(int[][] isInfected) {
        int m = isInfected.length, n = isInfected[0].length;
        int ans = 0;
        while (true) {
            List<Set<Integer>> neighbors = new ArrayList<>();
            List<Integer> firewalls = new ArrayList<>();
            // 遍历查找
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (isInfected[i][j] == 1) {
                        Deque<int[]> queue = new ArrayDeque<>();
                        queue.offer(new int[] {i, j});
                        Set<Integer> neighbor = new HashSet<>();
                        int firewall = 0, idx = neighbors.size() + 1;
                        isInfected[i][j] = -idx;

                        while (!queue.isEmpty()) {
                            int[] arr = queue.poll();
                            int x = arr[0], y = arr[1];
                            for (int d = 0; d < 4; d++) {
                                int nx = x + dirs[d][0], ny = y + dirs[d][1];
                                if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                                    if (isInfected[nx][ny] == 1) {
                                        // 如果为1表示相邻的病毒区域
                                        queue.offer(new int[] {nx, ny});
                                        isInfected[nx][ny] = -idx;
                                    } else if (isInfected[nx][ny] == 0) {
                                        // 如果为0表示病毒可以扩散的区域
                                        firewall++;
                                        neighbor.add(getHash(nx, ny));
                                    }
                                }
                            }
                        }
                        neighbors.add(neighbor);
                        firewalls.add(firewall);
                    }
                }
            }
            // 如果已经处理完了所有区域，则退出循环
            if (neighbors.isEmpty()) {
                break;
            }

            // 查找可扩散区域最大的一块病毒区域
            int idx = 0;
            for (int i = 1; i < neighbors.size(); i++) {
                if (neighbors.get(i).size() > neighbors.get(idx).size()) {
                    idx = i;
                }
            }
            // 放置防火墙
            ans += firewalls.get(idx);

            // 建立下一次循环的状态
            // 遍历将没有放置防火墙的相邻区域设置为1表示病毒区域，将放置防火墙的相邻区域设置为2表示已经设置了防火墙不会扩散
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (isInfected[i][j] < 0) {
                        if (isInfected[i][j] != -idx - 1) {
                            isInfected[i][j] = 1;
                        } else {
                            isInfected[i][j] = 2;
                        }
                    }
                }
            }

            // 病毒扩散，将当前neighbor中的位置全部置1
            for (int i = 0; i < neighbors.size(); i++) {
                if (i != idx) {
                    for (int val : neighbors.get(i)) {
                        int x = val >> 16, y = val & ((1 << 16) - 1);
                        isInfected[x][y] = 1;
                    }
                }
            }
            if (neighbors.size() == 1) {
                break;
            }
        }
        return ans;
    }

    public int getHash(int x, int y) {
        return (x << 16) ^ y;
    }
}
