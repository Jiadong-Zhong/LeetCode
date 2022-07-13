import java.util.*;

/**
 * 1383. 最大的团队表现值
 * https://leetcode.cn/problems/maximum-performance-of-a-team/
 */
public class MaxPerformance {
    public static void main(String[] args) {
        int n =6;
        int[] speed = {2,10,3,1,5,8};
        int[] efficiency = {5,4,3,9,7,2};
        int k = 2;
        MaxPerformance solution = new MaxPerformance();
        int ans = solution.maxPerformance(n, speed, efficiency, k);
        System.out.println(ans);
    }


    // 将效率从大到小开始枚举emin，选择效率大于emin的速度最快的k-1个(因为第k个是emin)
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        final int MOD = 1000000007;
        List<Staff> list = new ArrayList<>();
        PriorityQueue<Staff> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.s));
        for (int i = 0; i < n; i++) {
            list.add(new Staff(speed[i], efficiency[i]));
        }

        list.sort(Comparator.comparingInt(o -> -o.e));

        long ans = 0, sum = 0;
        for (int i = 0; i < n; i++) {
            Staff staff = list.get(i);
            long minE = staff.e;
            long sumS = sum + staff.s;
            ans = Math.max(ans, sumS * minE);
            queue.offer(staff);
            sum += staff.s;
            if (queue.size() == k) {
                sum -= queue.poll().s;
            }
        }
        return (int) (ans % MOD);
    }

    class Staff {
        int s, e;

        public Staff(int s, int e) {
            this.s = s;
            this.e = e;
        }
    }
}
