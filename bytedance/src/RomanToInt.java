import java.security.PublicKey;
import java.util.HashMap;
import java.util.Map;

/**
 * 13. 罗马数字转整数
 * https://leetcode.cn/problems/roman-to-integer/
 */
public class RomanToInt {
    public static void main(String[] args) {
        String s = "LVIII";

    }

    Map<Character, Integer> map = new HashMap<>() {{
        put('I', 1);
        put('V', 5);
        put('X', 10);
        put('L', 50);
        put('C', 100);
        put('D', 500);
        put('M', 1000);
    }};

    // 正向
    public int romanToInt1(String s) {
        int ans = 0;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            int val = map.get(s.charAt(i));
            if (i < len - 1 && val < map.get(s.charAt(i + 1))) {
                ans -= val;
            } else {
                ans += val;
            }
        }
        return ans;
    }

    // 反向
    public int randomToInt2(String s) {
        int ans = 0;
        int len = s.length();
        int highest = 1;
        for (int i = len - 1; i >= 0; i--) {
            int val = map.get(s.charAt(i));
            if (val >= highest) {
                ans += val;
                highest = val;
            } else {
                ans -= val;
            }
        }
        return ans;
    }
}
