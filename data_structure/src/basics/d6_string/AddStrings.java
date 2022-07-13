package basics.d6_string;

/**
 * 415. 字符串相加
 * https://leetcode-cn.com/problems/add-strings/
 */
public class AddStrings {
    public static void main(String[] args) {
        String num1 = "11";
        String num2 = "123";
        String res = addStrings1(num1, num2);
        System.out.println(res);
    }

    public static String addStrings1(String num1, String num2) {
        int n1 = num1.length();
        int n2 = num2.length();
        StringBuilder sb = new StringBuilder();
        int add = 0;
        int thisSum = 0;
        int p1 = n1 - 1;
        int p2 = n2 - 1;
        while (p1 >= 0 || p2 >= 0 || add != 0) {
            int x = p1 >= 0 ? num1.charAt(p1) - '0' : 0;
            int y = p2 >= 0 ? num2.charAt(p2) - '0' : 0;
            thisSum = x + y + add;
            sb.append(thisSum % 10);
            add = thisSum / 10;
            p1--;
            p2--;
        }
        sb.reverse();
        return sb.toString();
    }
}
