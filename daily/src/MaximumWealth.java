/**
 * 1672. 最富有客户的资产总量
 * https://leetcode-cn.com/problems/richest-customer-wealth/
 */
public class MaximumWealth {
    public static void main(String[] args) {
        int[][] accounts = {{1,2,3},{3,2,1}};
        int res = maximumWealth1(accounts);
        System.out.println(res);
    }

    public static int maximumWealth1(int[][] accounts) {
        int res = 0;
        int sum = 0;
        for (int i = 0; i < accounts.length; i++) {
            for (int nums : accounts[i]) {
                sum += nums;
            }
            if (sum > res) {
                res = sum;
            }
            sum = 0;
        }
        return res;
    }
}
