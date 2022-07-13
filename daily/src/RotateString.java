/**
 * 796. 旋转字符串
 * https://leetcode-cn.com/problems/rotate-string/
 */
public class RotateString {
    public static void main(String[] args) {
        String s = "abcde";
        String goal = "cdeab";
        System.out.println(rotateString2(s, goal));
    }

    public static boolean rotateString1(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            String head = s.substring(i);
            String rear = s.substring(0, i);
            String temp = head + rear;
            if (temp.toString().equals(goal)) {
                return true;
            }
        }
        return false;
    }

    public static boolean rotateString2(String s, String goal) {
        return s.length() == goal.length() && (s + s).contains(goal);
    }
}
