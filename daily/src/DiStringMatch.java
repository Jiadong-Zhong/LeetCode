import java.util.Arrays;

/**
 * 942. 增减字符串匹配
 * https://leetcode.cn/problems/di-string-match/
 */
public class DiStringMatch {
    public static void main(String[] args) {
        String s = "IDID";
        int[] res = diStringMatch1(s);
        System.out.println(Arrays.toString(res));
    }

    public static int[] diStringMatch1(String s) {
        int[] res = new int[s.length() + 1];
        int index = 0;
        int min = 0;
        int max = res.length - 1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'D') {
                res[index] = max;
                index++;
                max--;
            } else if (s.charAt(i) == 'I') {
                res[index] = min;
                index++;
                min++;
            }
        }
        res[res.length - 1] = min;
        return res;
    }

    public int[] diStringMatch2(String s) {
        int n = s.length();
        int low = 0;
        int high = n;
        int[] perm = new int[n + 1];
        for (int i = 0; i < n; i++) {
            perm[i] = s.charAt(i) == 'I' ? low++ : high--;
        }
        perm[n] = low;
        return perm;
    }
}
