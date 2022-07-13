/**
 * 面试题 01.01. 判定字符是否唯一
 * https://leetcode.cn/problems/is-unique-lcci/
 */
public class IsUnique {
    public static void main(String[] args) {
        String s = "leetcode";
        IsUnique solution = new IsUnique();
        boolean ans = solution.isUnique(s);
        System.out.println(ans);
    }

    public boolean isUnique(String astr) {
        int mask = 0;
        for (int i = 0; i < astr.length(); i++) {
            int moveBit = astr.charAt(i) - 'a';
            if ((mask & (1 << moveBit)) != 0) {
                return false;
            } else {
                mask |= (1 << moveBit);
            }
        }
        return true;
    }
}
