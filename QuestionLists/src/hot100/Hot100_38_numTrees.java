package hot100;

/**
 * 96. 不同的二叉搜索树
 * https://leetcode.cn/problems/unique-binary-search-trees/
 */
public class Hot100_38_numTrees {
    public static void main(String[] args) {
        int n = 3;
        Hot100_38_numTrees solution = new Hot100_38_numTrees();
        int ans = solution.numTrees2(4);
        System.out.println(ans);
    }

    // 递归
    public int numTrees1(int n) {
        if (n == 1 || n == 0) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int count = 0;
        for (int i = 1; i <= n; i++) {
            int leftChildNum = i - 1;
            int rightChildNum = n - i;
            count += numTrees1(leftChildNum) * numTrees1(rightChildNum);
        }
        return count;
    }

    // 动态规划
    public int numTrees2(int n) {
        int[] G = new int[n + 1];
        G[0] = 1;
        G[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                G[i] += G[j - 1] * G[i - j];
            }
        }
        return G[n];
    }

    // 数学，设计到卡塔兰数，参考资料https://baike.baidu.com/item/catalan/7605685?fr=aladdin
    public int numTrees3(int n) {
        // 提示：我们在这里需要用 long 类型防止计算过程中的溢出
        long C = 1;
        for (int i = 0; i < n; ++i) {
            C = C * 2 * (2 * i + 1) / (i + 2);
        }
        return (int) C;
    }
}
