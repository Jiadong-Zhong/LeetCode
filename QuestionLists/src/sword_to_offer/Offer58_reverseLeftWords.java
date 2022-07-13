package sword_to_offer;

/**
 * 剑指 Offer 58 - II. 左旋转字符串
 * https://leetcode.cn/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof/
 */
public class Offer58_reverseLeftWords {
    public static void main(String[] args) {
        String s = "abcdefg";
        int k = 2;

    }

    // api
    public String reverseLeftWords1(String s, int n) {
        return s.substring(n) + s.substring(0, n - 1);
    }


    // 遍历拼接
    public String reverseLeftWords2(String s, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = n; i < s.length(); i++) {
            sb.append(s.charAt(i));
        }
        for (int i = 0; i < n; i++) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    public String reverseLeftWords3(String s, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = n; i < s.length() + n; i++) {
            sb.append(s.charAt(i % s.length()));
        }
        return sb.toString();
    }
}
