import java.util.*;

/**
 * 735. 行星碰撞
 * https://leetcode.cn/problems/asteroid-collision/
 */
public class AsteroidCollision {
    public static void main(String[] args) {
        int[] asteroids = {-10, -2, 5, -5};
        AsteroidCollision solution = new AsteroidCollision();
        int[] ans = solution.asteroidCollision(asteroids);
        System.out.println(Arrays.toString(ans));
    }

    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int aster : asteroids) {
            boolean alive = true;
            while (alive && aster < 0 && !stack.isEmpty() && stack.peek() > 0) {
                alive = stack.peek() < -aster;
                if (stack.peek() <= -aster) {
                    stack.pop();
                }
            }
            if (alive) {
                stack.push(aster);
            }
        }

        int size = stack.size();
        int[] ans = new int[size];
        for (int i = size - 1; i >= 0; i--) {
            ans[i] = stack.pop();
        }
        return ans;
    }
}
