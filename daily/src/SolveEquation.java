/**
 * 640. 求解方程
 * https://leetcode.cn/problems/solve-the-equation/
 */
public class SolveEquation {
    public static void main(String[] args) {
        String equation = "x+5-3+x=6+x-2";
    }

    public String solveEquation(String equation) {
        int factor = 0, val = 0;
        int index = 0, n = equation.length(), sign1 = 1;
        while (index < n) {
            if (equation.charAt(index) == '=') {
                sign1 = -1;
                index++;
                continue;
            }

            int sign2 = sign1, number = 0;
            boolean valid = false;
            if (equation.charAt(index) == '-' || equation.charAt(index) == '+') {
                sign2 = (equation.charAt(index) == '-') ? -sign1 : sign1;
                index++;
            }
            while (index < n && Character.isDigit(equation.charAt(index))) {
                number = number * 10 + equation.charAt(index) - '0';
                index++;
                valid = true;
            }

            if (index < n && equation.charAt(index) == 'x') {
                factor += valid ? sign2 * number : sign2;
                index++;
            } else {
                val += sign2 * number;
            }
        }

        if (factor == 0) {
            return val == 0 ? "Infinite solutions" : "No solution";
        }
        if (val % factor != 0) {
            return "No solution";
        }
        return "x=" + (-val / factor);
    }
}
