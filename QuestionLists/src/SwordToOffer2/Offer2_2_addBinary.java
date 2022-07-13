package SwordToOffer2;

/**
 * 剑指 Offer II 002. 二进制加法
 * https://leetcode.cn/problems/JFETK5/
 */
public class Offer2_2_addBinary {
    public static void main(String[] args) {
        String a = "1010";
        String b = "1011";
        Offer2_2_addBinary solution = new Offer2_2_addBinary();
        String ans = solution.addBinary(a, b);
        System.out.println(ans);
    }

    public String addBinary(String a, String b) {
        int p1 = a.length() - 1;
        int p2 = b.length() - 1;
        int add = 0;
        StringBuilder ans = new StringBuilder();
        while (p1 >= 0 || p2 >= 0 || add != 0) {
            int val1 = p1 >= 0 ? a.charAt(p1) - '0' : 0;
            int val2 = p2 >= 0 ? b.charAt(p2) - '0' : 0;
            int curr = val1 + val2 + add;

            ans.append(curr % 2);
            add = curr / 2;
            p1--;
            p2--;
        }
        return ans.reverse().toString();
    }
}
