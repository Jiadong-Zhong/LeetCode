import java.util.Arrays;

/**
 * 806. 写字符串需要的行数
 * https://leetcode-cn.com/problems/number-of-lines-to-write-string/
 */
public class NumberOfLines {
    public static void main(String[] args) {
        int[] widths = {4,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10};
        String s = "bbbcccdddaaa";
        int[] res = numberOfLines1(widths, s);
        System.out.println(Arrays.toString(res));
    }

    public static int[] numberOfLines1(int[] widths, String s) {
        int[] res = new int[2];
        char[] chars = s.toCharArray();
        int curLine = 0;
        for (int i = 0; i < chars.length; i++) {
            curLine += widths[chars[i] - 'a'];
            if (curLine == 100 && i != chars.length - 1) {
                curLine = 0;
                res[0]++;
            } else if (curLine > 100) {
                curLine = widths[chars[i] - 'a'];
                res[0]++;
            }
        }
        res[0]++;
        res[1] = curLine;
        return res;
    }

    public static int[] numberOfLines2(int[] widths, String s) {
        int[] res = new int[2];
        res[0] = 1;
        char[] chars = s.toCharArray();
        int curLine = 0;
        for (char c : chars) {
            curLine += widths[c - 'a'];
            if (curLine > 100) {
                curLine = widths[c - 'a'];
                res[0]++;
            }
        }
        res[1] = curLine;
        return res;
    }
}
