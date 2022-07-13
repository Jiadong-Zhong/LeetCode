package introduction.d6_string;

/**
 * 383. 赎金信
 * https://leetcode-cn.com/problems/ransom-note/
 */
public class CanConstruct {
    public static void main(String[] args) {
        String ransomNote = "a";
        String magazine = "b";

        boolean res = canConstruct1(ransomNote, magazine);
        System.out.println(res);
    }

    public static boolean canConstruct1(String ransomNote, String magazine) {
        if (magazine.length() < ransomNote.length()) {
            return false;
        }
        int[] count = new int[26];
        for (char c : magazine.toCharArray()) {
            count[c - 'a']++;
        }

        for (char c : ransomNote.toCharArray()) {
            count[c - 'a']--;
            if (count[c - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
