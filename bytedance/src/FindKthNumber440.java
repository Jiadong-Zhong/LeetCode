/**
 * 440. 字典序的第K小数字
 * https://leetcode.cn/problems/k-th-smallest-in-lexicographical-order/
 */
public class FindKthNumber440 {
    public static void main(String[] args) {
        int n = 113;
        int k = 23;
        FindKthNumber440 solution = new FindKthNumber440();
        int ans = solution.findKthNumber1(n, k);
        System.out.println(ans);
    }

    // 字典树思想
    public int findKthNumber1(int n, int k) {
        int curr = 1; // 从1开始，1是字典序中最小的
        k--; // 如果k = 1则不进入循环，直接返回1，否则说明1不是目标，找第k-1个小的数
        while (k > 0) {
            int steps = getSteps(curr, n); // steps = 当前节点curr下右多少比n小的节点(包括n)
            if (steps <= k) { // 如果不够，则要去相邻节点去找
                k -= steps;
                curr++; // 表示到达相邻节点
            } else { // 否则，就在当前curr下
                curr *= 10; // 从最左侧开始搜寻
                k--; // 减去当前节点
            }
        }
        return curr;
    }

    private int getSteps(int curr, long n) {
        int steps = 0;
        long first = curr;
        long last = curr;
        while (first <= n) {
            steps += Math.min(last, n) - first + 1;
            first *= 10;
            last = last * 10 + 9;
        }
        return steps;
    }
}
