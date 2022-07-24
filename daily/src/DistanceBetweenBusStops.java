/**
 * 1184. 公交站间的距离
 * https://leetcode.cn/problems/distance-between-bus-stops/
 */
public class DistanceBetweenBusStops {
    public static void main(String[] args) {
        int[] distance = {1,2,3,4};
        int start = 0;
        int destination = 3;

        DistanceBetweenBusStops solution = new DistanceBetweenBusStops();
        int ans = solution.distanceBetweenBusStops(distance, start, destination);
        System.out.println(ans);

    }

    // 自己写的
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int pos = 0, neg = 0;
        int n = distance.length;
        int i = start;
        while (i % n != destination) {
            pos += distance[i % n];
            i++;
        }

        int j = start;
        while (j % n != destination) {
            j--;
            if (j == -1) {
                j = n - 1;
            }
            neg += distance[j % n];
        }
        return Math.min(pos, neg);
    }

    // 题解，一次遍历
    public int distanceBetweenBusStops2(int[] distance, int start, int destination) {
        if (start > destination) {
            int temp = start;
            start = destination;
            destination = temp;
        }
        int sum1 = 0, sum2 = 0;
        for (int i = 0; i < distance.length; i++) {
            if (i >= start && i < destination) {
                sum1 += distance[i];
            } else {
                sum2 += distance[i];
            }
        }
        return Math.min(sum1, sum2);
    }
}
