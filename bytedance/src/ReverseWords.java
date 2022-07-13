/**
 * 557. 反转字符串中的单词 III
 * https://leetcode.cn/problems/reverse-words-in-a-string-iii/
 */
public class ReverseWords {
    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        ReverseWords solution = new ReverseWords();
        String ans = solution.reverseWords1(s);
        System.out.println(ans);
    }

    public String reverseWords1(String s) {
        int left = 0, right = 0;
        char[] charArr = s.toCharArray();
        while (right < s.length()) {
            while (right < s.length() && s.charAt(right) != ' ') {
                right++;
            }
            reverseRange(charArr, left, right - 1);
            right++;
            left = right;
        }
        return new String(charArr);
    }

    public void reverseRange(char[] charArr, int left, int right) {
        while (left < right) {
            swap(charArr, left, right);
            left++;
            right--;
        }
    }

    public void swap(char[] charArr, int i, int j) {
        char temp = charArr[i];
        charArr[i] = charArr[j];
        charArr[j] = temp;
    }
}
