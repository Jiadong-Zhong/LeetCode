/**
 * 592. 分数加减运算
 * https://leetcode.cn/problems/fraction-addition-and-subtraction/
 */
public class FractionAddition {
    public static void main(String[] args) {
        String expression = "-1/2+1/2+1/3";
        FractionAddition solution = new FractionAddition();
        String ans = solution.fractionAddition(expression);
        System.out.println(ans);
    }

    public String fractionAddition(String expression) {
        long denominator = 0, numerator = 1;
        int index = 0, n = expression.length();
        while (index < n) {
            long denominator1 = 0, sign = 1;

            if (expression.charAt(index) == '-' || expression.charAt(index) == '+') {
                sign = expression.charAt(index) == '-' ? -1 : 1;
                index++;
            }
            while (index < n && Character.isDigit(expression.charAt(index))) {
                denominator1 = denominator1 * 10 + expression.charAt(index) - '0';
                index++;
            }
            denominator1 *= sign;
            index++;

            long numerator1 = 0;
            while (index < n && Character.isDigit(expression.charAt(index))) {
                numerator1 = numerator1 * 10 + expression.charAt(index) - '0';
                index++;
            }

            denominator = denominator * numerator1 + denominator1 * numerator;
            numerator *= numerator1;
        }
        if (denominator == 0) {
            return "0/1";
        }
        long g = gcd(Math.abs(denominator), numerator);
        return denominator / g + "/" + numerator / g;
    }

    public long gcd(long a, long b) {
        long remainder = a % b;
        while (remainder != 0) {
            a = b;
            b = remainder;
            remainder = a % b;
        }
        return b;
    }
}
