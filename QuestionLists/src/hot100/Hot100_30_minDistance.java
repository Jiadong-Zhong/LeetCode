package hot100;

/**
 * 72. 编辑距离
 * https://leetcode.cn/problems/edit-distance/
 */
public class Hot100_30_minDistance {
    public static void main(String[] args) {
        String word1 = "intention";
        String word2 = "execution";
        Hot100_30_minDistance solution = new Hot100_30_minDistance();
        int ans = solution.minDistance2(word1, word2);
        System.out.println(ans);
    }

    // 递归，会超时
    public int minDistance1(String word1, String word2) {
        if (word1.length() == 0 || word2.length() == 0) {
            return Math.max(word1.length(), word2.length());
        }
        int len1 = word1.length();
        int len2 = word2.length();
        if (word1.charAt(len1 - 1) == word2.charAt(len2 - 1)) {
            return minDistance1(word1.substring(0, len1 - 1), word2.substring(0, len2 - 1));
        }

        int insertCount = minDistance1(word1, word2.substring(0, len2 - 1)); // 插入操作的操作数
        int deleteCount = minDistance1(word1.substring(0, len1 - 1), word2); // 删除操作的操作数
        int replaceCount = minDistance1(word1.substring(0, len1 -1), word2.substring(0, len2 - 1)); // 替换操作的操作数
        return 1 + Math.min(Math.min(insertCount, deleteCount), replaceCount);
    }

    // 动态规划：视频题解
    public int minDistance2(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();

        int[][] op = new int[len1 + 1][len2 + 1];
        for (int i = 0; i < len1 + 1; i++) {
            op[i][0] = i;
        }
        for (int j = 0; j < len2 + 1; j++) {
            op[0][j] = j;
        }

        for (int i = 1; i < len1 + 1; i++) {
            for (int j = 1; j < len2 + 1; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    op[i][j] = op[i - 1][j - 1];
                } else {
                    op[i][j] = 1 + Math.min(Math.min(op[i][j - 1], op[i - 1][j]), op[i - 1][j - 1]);
                }
            }
        }

        return op[len1][len2];
    }

    // 动态规划：文字题解
    public int minDistance3(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();

        // 有一个字符串是空串
        if (len1 * len2 == 0) {
            return len1 + len2;
        }

        int[][] op = new int[len1 + 1][len2 + 1];
        // 初始化边界状态，即一个非空串到一个空串需要的操作数，即非空串的长度
        for (int i = 0; i < len1 + 1; i++) {
            op[i][0] = i;
        }
        for (int j = 0; j < len2 + 1; j++) {
            op[0][j] = j;
        }

        for (int i = 1; i < len1 + 1; i++) {
            for (int j = 1; j < len2 + 1; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    op[i][j] = op[i - 1][j - 1];
                } else {
                    op[i][j] = 1 + Math.min(Math.min(op[i][j - 1], op[i - 1][j]), op[i - 1][j - 1]);
                }
            }
        }

        return op[len1][len2];
    }

}
