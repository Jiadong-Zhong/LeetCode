import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 761. 特殊的二进制序列
 * https://leetcode.cn/problems/special-binary-string/
 */
public class MakeLargestSpecial {
    public static void main(String[] args) {
        String s = "11011000";
    }

    public String makeLargestSpecial(String s) {
        if (s.length() <= 2) {
            return s;
        }

        int count = 0, left = 0;
        List<String> subs = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                count++;
            } else {
                count--;
                if (count == 0) {
                    subs.add("1" + makeLargestSpecial(s.substring(left + 1, i)) + "0");
                    left = i + 1;
                }
            }
        }

        Collections.sort(subs, (Comparator.reverseOrder()));
        StringBuilder ans = new StringBuilder();
        for (String sub : subs) {
            ans.append(sub);
        }
        return ans.toString();
    }
}
