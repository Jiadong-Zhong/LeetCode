import java.util.Arrays;

/**
 * 875. 爱吃香蕉的珂珂
 * https://leetcode.cn/problems/koko-eating-bananas/
 */
public class MinEatingSpeed {
    public static void main(String[] args) {
        int[] piles = {30,11,23,4,20};
        int h = 6;
        MinEatingSpeed solution = new MinEatingSpeed();
        int ans = solution.minEatingSpeed1(piles, h);
        System.out.println(ans);
    }

    // 二分
    public int minEatingSpeed1(int[] piles, int h) {
        int low = 1;
        int high = 0;
        for (int pile : piles) {
            high = Math.max(high, pile);
        }
        int k = high;
        while (low < high) {
            int speed = (high - low) / 2 + low;
            long time = getTime(piles, speed);
            if (time <= h) {
                k = speed;
                high = speed;
            } else {
                low = speed + 1;
            }
        }
        return k;
    }

    public long getTime(int[] piles, int speed) {
        long time = 0;
        for (int pile : piles) {
            int curTime = (pile + speed  - 1) / speed;
            time += curTime;
        }
        return time;
    }
}
