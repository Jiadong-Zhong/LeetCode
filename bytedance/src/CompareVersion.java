/**
 * 165. 比较版本号
 * https://leetcode.cn/problems/compare-version-numbers/
 */
public class CompareVersion {
    public static void main(String[] args) {
        String version1 = "0.1";
        String version2 = "1.1";
        CompareVersion solution = new CompareVersion();
        int ans = solution.compareVersion2(version1, version2);
        System.out.println(ans);
    }

    // 自己写的
    public int compareVersion1(String version1, String version2) {
        String[] str1 = version1.split("\\.");
        String[] str2 = version2.split("\\.");
        int p1 = 0, p2 = 0;
        int len1 = str1.length, len2 = str2.length;
        while (p1 < len1 && p2 < len2) {
            int val1 = Integer.parseInt(str1[p1]);
            int val2 = Integer.parseInt(str2[p2]);
            if (val1 < val2) {
                return -1;
            } else if (val1 > val2) {
                return 1;
            } else {
                p1++;
                p2++;
            }
        }

        if (p1 == len1 && p2 == len2) {
            return 0;
        } else if (p1 == len1) {
            while (p2 < len2) {
                if (Integer.parseInt(str2[p2]) == 0) {
                    p2++;
                } else {
                    return -1;
                }
            }
            return 0;
        } else {
            while (p1 < len1) {
                if (Integer.parseInt(str1[p1]) == 0) {
                    p1++;
                } else {
                    return 1;
                }
            }
            return 0;
        }
    }

    // 双指针
    public int compareVersion2(String version1, String version2) {
        int n = version1.length(), m = version2.length();
        int i = 0, j = 0;
        while (i < n || j < m) {
            int x = 0;
            for (; i < n && version1.charAt(i) != '.'; i++) {
                x = x * 10 + version1.charAt(i) - '0';
            }
            i++;
            int y = 0;
            for (; j < m && version2.charAt(j) != '.'; j++) {
                y = y * 10 + version2.charAt(j) - '0';
            }
            j++;
            if (x != y) {
                return x > y ? 1 : -1;
            }
        }
        return 0;
    }
}
