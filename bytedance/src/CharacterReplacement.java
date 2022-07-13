/**
 * 424. 替换后的最长重复字符
 * https://leetcode.cn/problems/longest-repeating-character-replacement/
 */
public class CharacterReplacement {
    public static void main(String[] args) {
        String s = "AABABBA";
        int k = 2;
        CharacterReplacement solution = new CharacterReplacement();
        int ans = solution.characterReplacement(s, k);
        System.out.println(ans);

    }

    public int characterReplacement(String s, int k) {
        int[] num = new int[26];
        int n = s.length();
        int maxN = 0;
        int left = 0, right = 0;
        while (right < n) {
            num[s.charAt(right) - 'A']++;
            maxN = Math.max(maxN, num[s.charAt(right) - 'A']);
            if (right - left + 1 - maxN > k) {
                num[s.charAt(left) - 'A']--;
                left++;
            }
            right++;
        }
        return right - left;
    }
}
