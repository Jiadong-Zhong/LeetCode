import java.util.ArrayList;
import java.util.List;

/**
 * 933. 最近的请求次数
 * https://leetcode-cn.com/problems/number-of-recent-calls/
 */
public class RecentCounter {
    public static void main(String[] args) {
        RecentCounter recentCounter = new RecentCounter();
        int param_1 = recentCounter.ping(1);
        int param_2 = recentCounter.ping(100);
        int param_3 = recentCounter.ping(3001);
        int param_4 = recentCounter.ping(3002);
        System.out.println(param_1);
        System.out.println(param_2);
        System.out.println(param_3);
        System.out.println(param_4);

    }

    private final List<Integer> historyCall;
    public RecentCounter() {
        historyCall = new ArrayList<>();
    }

    public int ping(int t) {
        historyCall.add(t);
        while (historyCall.get(0) < t - 3000) {
            historyCall.remove(0);
        }
        return historyCall.size();
    }
}
