import java.util.Arrays;

/**
 * 67. 二进制求和
 * https://leetcode.cn/problems/add-binary/
 */
public class AddBinary {
    public static void main(String[] args) {
        String a = "0";
        String b = "0";
        AddBinary solution = new AddBinary();
        String ans = solution.addBinary2(a, b);
        System.out.println(ans);
    }

    public String addBinary1(String a, String b) {
        int p1 = a.length() - 1;
        int p2 = b.length() - 1;
        char[] ans = new char[Math.max(a.length(), b.length()) + 1];
        int index = ans.length - 1;
        int add = 0;
        while (p1 >= 0 || p2 >= 0 || add != 0) {
            int val1 = p1 < 0 ? 0 : a.charAt(p1) - '0';
            int val2 = p2 < 0 ? 0 : b.charAt(p2) - '0';
            int currSum = val1 + val2 + add;
            ans[index] = currSum % 2 == 0 ? '0' : '1';
            add = currSum / 2;
            index--;
            p1--;
            p2--;
        }
        if (index != -1) {
            return new String(Arrays.copyOfRange(ans, 1, ans.length));
        } else {
            return new String(ans);
        }
    }

    public String addBinary2(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int p1 = a.length() - 1, p2 = b.length() - 1;
        int add = 0;
        while (p1 >= 0 || p2 >= 0 || add != 0) {
            int val1 = p1 < 0 ? 0 : a.charAt(p1) - '0';
            int val2 = p2 < 0 ? 0 : b.charAt(p2) - '0';
            int currSum = val1 + val2 + add;
            add = currSum / 2;
            p1--;
            p2--;
            sb.append(currSum % 2);
        }
        return sb.reverse().toString();
    }
}
