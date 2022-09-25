/**
 * 1417. 重新格式化字符串
 * https://leetcode.cn/problems/reformat-the-string/
 */
public class Reformat {
    public static void main(String[] args) {
        String s = "a0b1c2";
    }

    public String reformat(String s) {
        int countDigit = 0;
        for (int i = 0; i < s.length();i ++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                countDigit++;
            }
        }

        int countLetter = s.length() - countDigit;
        if (Math.abs(countLetter - countDigit) > 1) {
            return "";
        }

        boolean flag = countDigit > countLetter;

        char[] arr = s.toCharArray();

        for (int i = 0, j = 1; i < s.length(); i += 2) {
            // 当arr[i]为个数较少的字符时
            if (Character.isDigit(arr[i]) != flag) {
                // 向右移动j找到第一个arr[j]是个数多的字符
                while (Character.isDigit(arr[j]) != flag) {
                    j += 2;
                }
                swap(arr, i, j);
            }
        }
        return new String(arr);
    }

    public void swap(char[] arr, int i, int j) {
        char c = arr[i];
        arr[i] = arr[j];
        arr[j] = c;
    }
}
