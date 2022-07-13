/**
 * 944. 删列造序
 * https://leetcode.cn/problems/delete-columns-to-make-sorted/
 */
public class MinDeletionSize {
    public static void main(String[] args) {
        String[] strs = {"abc", "bce", "cae"};
        int res = minDeletionSize1(strs);
        System.out.println(res);
    }

    public static int minDeletionSize1(String[] strs) {
        int count = 0;
        for (int i = 0; i < strs[0].length(); i++) {
            for (int j = 0; j < strs.length - 1; j++) {
                if (strs[j].charAt(i) > strs[j + 1].charAt(i)) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}
