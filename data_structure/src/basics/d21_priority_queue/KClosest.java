package basics.d21_priority_queue;

import java.util.*;

/**
 * 973. 最接近原点的 K 个点
 * https://leetcode-cn.com/problems/k-closest-points-to-origin/
 */
public class KClosest {
    public static void main(String[] args) {
        int[][] points = {{3,3}, {5,-1}, {-2,4}};
        int k = 2;
        int[][] res = kClosest1(points, k);
        for (int[] point : res) {
            System.out.println(Arrays.toString(point));
        }

    }

    public static int[][] kClosest1(int[][] points, int k) {
        Map<int[], Double> distances = new HashMap<>();
        List<int[]> list = new ArrayList<>();
        for (int[] point : points) {
            Double dist = Math.sqrt(Math.pow(point[0], 2) + Math.pow(point[1], 2));
            distances.put(point, dist);
            list.add(point);
        }

        list.sort(Comparator.comparing(distances::get));

        int[][] res = new int[k][2];
        for (int i = 0; i < k; i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public int[][] kClosest2(int[][] points, int k) {
        Arrays.sort(points, new Comparator<int[]>() {
            public int compare(int[] point1, int[] point2) {
                return (point1[0] * point1[0] + point1[1] * point1[1]) - (point2[0] * point2[0] + point2[1] * point2[1]);
            }
        });
        return Arrays.copyOfRange(points, 0, k);
    }

    public int[][] kClosest3(int[][] points, int k) {
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] - o1[0];
            }
        });
        for (int i = 0; i < k; i++) {
            priorityQueue.offer(new int[] {points[i][0] * points[i][0] + points[i][1] * points[i][1], i});
        }
        int n = points.length;
        for (int i = k; i < n; i++) {
            int dist = points[i][0] * points[i][0] + points[i][1] * points[i][1];
            if (dist < priorityQueue.peek()[0]) {
                priorityQueue.poll();
                priorityQueue.offer(new int[] {dist, i});
            }
        }
        int[][] ans = new int[k][2];
        for (int i = 0; i < k; i++) {
            ans[i] = points[priorityQueue.poll()[1]];
        }
        return ans;
    }

    Random random = new Random();
    public int[][] kClosest4(int[][] points, int k) {
        int n = points.length;
        random_select(points, 0, n - 1, k);
        return Arrays.copyOfRange(points, 0, k);
    }

    public void random_select(int[][] points, int left, int right, int k) {
        int pivotId = random.nextInt(right - left + 1) + left;
        int pivot = points[pivotId][0] * points[pivotId][0] + points[pivotId][1] * points[pivotId][1];
        swap(points, right, pivotId);
        int i = left - 1;
        for (int j = left; j < right; j++) {
            int dist = points[j][0] * points[j][0] + points[j][1] * points[j][1];
            if (dist <= pivot) {
                i++;
                swap(points, j, i);
            }
        }
        i++;
        swap(points, i, right);

        if (k < i - left + 1) {
            random_select(points, left, i - 1, k);
        } else if (k > i - left + 1) {
            random_select(points, i + 1, right, k - (i - left + 1));
        }
    }

    public void swap(int[][] points, int index1, int index2) {
        int[] temp = points[index1];
        points[index1] = points[index2];
        points[index2] = temp;
    }
}
