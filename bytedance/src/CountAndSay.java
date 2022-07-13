/**
 * 38. 外观数列
 * https://leetcode.cn/problems/count-and-say/
 */
public class CountAndSay {
    public static void main(String[] args) {
        int n = 5;
        CountAndSay solution = new CountAndSay();
        String ans = solution.countAndSay(n);
        System.out.println(ans);
    }

    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String s = countAndSay(n - 1);
        StringBuilder sb = new StringBuilder();
        int index = 0;
        int len = s.length();
        while (index < len) {
            int count = 1;
            char ch = s.charAt(index);
            while (index < len - 1 && ch == s.charAt(index + 1)) {
                count++;
                index++;
            }
            sb.append(count).append(ch);
            index++;
        }
        return sb.toString();
    }
}
