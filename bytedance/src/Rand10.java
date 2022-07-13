import java.util.Random;

/**
 * 470. 用 Rand7() 实现 Rand10()
 * https://leetcode.cn/problems/implement-rand10-using-rand7/
 */
public class Rand10 {

    // (randX() - 1)*Y + randY() 可以等概率的生成[1, X * Y]范围的随机数
    public int rand10() {
        while (true) {
            int num = (rand7() - 1) * 7 + rand7();

            // 40以内直接返回
            if (num <= 40) {
                return 1 + num % 10;
            }

            // 在41-49之间，再操作一遍
            // num - 40 相当于生成 1-9的随机数
            num = (num - 40 - 1) * 7 + rand7();
            if (num <= 60) {
                return 1 + num % 10;
            }

            // 生成的在61-63之间，再操作一遍
            // num - 60 相当于生成 1 - 3的随机数
            num = (num - 60 - 1) * 7 + rand7();
            if (num <= 20) {
                return 1 + num % 10;
            }
        }
    }

    public int rand7() {
        return new Random().nextInt(7) + 1;
    }
}
