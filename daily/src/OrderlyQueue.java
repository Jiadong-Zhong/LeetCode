import java.util.Arrays;

/**
 * 899. 有序队列
 * https://leetcode.cn/problems/orderly-queue/
 */
public class OrderlyQueue {
    public static void main(String[] args) {
        String s = "cba";
        int k = 1;
    }

    // k为1时可以产生n个不同的字符串，选择最小的即可
    // k >= 2时，一定可以将字符串转换为升序字符串，直接返回排序后的即可
    public String orderlyQueue(String s, int k) {
        if (k == 1) {
            String smallest = s;
            StringBuilder sb = new StringBuilder(s);
            int n = s.length();
            for (int i = 1; i < n; i++) {
                char c = sb.charAt(0);
                sb.deleteCharAt(0);
                sb.append(c);
                if (sb.toString().compareTo(smallest) < 0) {
                    smallest = sb.toString();
                }
            }
            return smallest;
        } else {
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            return new String(arr);
        }
    }
}
