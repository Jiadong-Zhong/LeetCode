import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 剑指 Offer II 041. 滑动窗口的平均值
 * https://leetcode.cn/problems/qIsx9U/
 */
public class MovingAverage {
    public static void main(String[] args) {
        MovingAverage movingAverage = new MovingAverage(3);
        double param1 = movingAverage.next(1);
        double param2 = movingAverage.next(10);
        double param3 = movingAverage.next(3);
        double param4 = movingAverage.next(5);
        System.out.println(param1);
        System.out.println(param2);
        System.out.println(param3);
        System.out.println(param4);
    }


    Deque<Integer> nums;
    int size;
    int sum;

    public MovingAverage(int size) {
        this.size = size;
        nums = new ArrayDeque<>();
        sum = 0;
    }

    public double next(int val) {
        nums.addLast(val);
        sum += val;
        if (nums.size() > size) {
            sum -= nums.removeFirst();
        }
        return sum * 1.0 / nums.size();
    }
}
