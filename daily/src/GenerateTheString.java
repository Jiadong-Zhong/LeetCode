/**
 * 1374. 生成每种字符都是奇数个的字符串
 * https://leetcode.cn/problems/generate-a-string-with-characters-that-have-odd-counts/
 */
public class GenerateTheString {
    public String generateTheString(int n) {
        StringBuilder sb = new StringBuilder();
        if (n % 2 == 0) {
            for (int i = 0; i < n - 1; i++) {
                sb.append('a');
            }
            sb.append('b');
        } else {
            for (int i = 0; i < n; i++) {
                sb.append('a');
            }
        }
        return sb.toString();
    }
}
