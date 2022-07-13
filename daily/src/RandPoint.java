import java.util.Arrays;
import java.util.Random;

/**
 * 478. 在圆内随机生成点
 * https://leetcode.cn/problems/generate-random-point-in-a-circle/
 */
public class RandPoint {
    public static void main(String[] args) {
        Solution1 solution = new Solution1(1.0, 0.0, 0.0);
        double[] param_1 = solution.randPoint();
        double[] param_2 = solution.randPoint();
        double[] param_3 = solution.randPoint();
        System.out.println(Arrays.toString(param_1));
        System.out.println(Arrays.toString(param_2));
        System.out.println(Arrays.toString(param_3));
    }
}

// 自己写的
class Solution1 {
    Random r;
    double radius;
    double x_center;
    double y_center;

    public Solution1(double radius, double x_center, double y_center) {
        this.radius = radius;
        this.x_center = x_center;
        this.y_center = y_center;
        r = new Random();
    }

    public double[] randPoint() {
        double[] ans = new double[2];
        ans[0] = x_center + (r.nextDouble() * 2 * radius - radius);
        ans[1] = y_center + (r.nextDouble() * 2 * radius - radius);
        if (isValid(ans)) {
            return ans;
        } else {
            return randPoint();
        }
    }

    public boolean isValid(double[] point) {
        double distance = (x_center - point[0]) * (x_center - point[0]) + (y_center - point[1]) * (y_center - point[1]);
        return distance <= (radius * radius);
    }
}

// 题解中拒绝采样与自己写的思路一致，但是在生成随机数时有优化
class Solution2 {
    Random random;
    double xc, yc, r;

    public Solution2(double radius, double x_center, double y_center) {
        random = new Random();
        xc = x_center;
        yc = y_center;
        r = radius;
    }

    public double[] randPoint() {
        while (true) {
            double x = random.nextDouble() * (2 * r) - r;
            double y = random.nextDouble() * (2 * r) - r;
            if (x * x + y * y <= r * r) {
                return new double[]{xc + x, yc + y};
            }
        }
    }
}

// 极坐标，生成随机长度和随机角度，为什么随机长度是在[0, sqrt(u))的原因查看题解，根据累积分布函数计算得到
// 因为圆的面积是正比于r的平方，所以必须从[0, r*r]内采样才能保证在圆中是均匀分布
// 所以也可以先在r*r内随机取样后再开方，这里先生成0-1的随机数再开方最终乘以半径达到的效果是一致的
class Solution {
    Random random;
    double xc, yc, r;

    public Solution(double radius, double x_center, double y_center) {
        random = new Random();
        xc = x_center;
        yc = y_center;
        r = radius;
    }

    public double[] randPoint() {
        double u = random.nextDouble();
        double theta = random.nextDouble() * 2 * Math.PI;
        double r = Math.sqrt(u);
        return new double[]{xc + r * Math.cos(theta) * this.r, yc + r * Math.sin(theta) * this.r};
    }
}