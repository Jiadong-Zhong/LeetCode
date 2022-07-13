package basics.d14_stack_queue;

/**
 * 1823. 找出游戏的获胜者
 *
 */
public class FindTheWinner {
    public static void main(String[] args) {
        int n = 5;
        int k = 2;

    }

    public static int findTheWinner1(int n, int k) {
        if (n == 1) {
            return 1;
        }
        int ans = findTheWinner1(n - 1, k) + k;
        return ans % n == 0 ? n : (ans % n);
    }
}
