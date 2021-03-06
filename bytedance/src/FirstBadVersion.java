/**
 * 278. 第一个错误的版本
 * https://leetcode.cn/problems/first-bad-version/
 */
public class FirstBadVersion {

    public int firstBadVersion(int n) {
        int left = 1, right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public boolean isBadVersion(int n) {
        return n > 3;
    }
}
