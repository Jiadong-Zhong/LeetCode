/**
 * 134. 加油站
 * https://leetcode.cn/problems/gas-station/
 */
public class CanCompleteCircuit {
    public static void main(String[] args) {
        int[] gas = {4,0,1};
        int[] cost = {3,2,1};
        CanCompleteCircuit solution = new CanCompleteCircuit();
        int ans = solution.canCompleteCircuit2(gas, cost);
        System.out.println(ans);
    }

    // 自己写的
    public int canCompleteCircuit1(int[] gas, int[] cost) {
        for (int i = 0; i < gas.length; i++) {
            if (check(gas, cost, i)) {
                return i;
            }
        }
        return -1;
    }

    public boolean check(int[] gas, int[] cost, int begin) {
        int count = gas[begin];
        int pos = begin;
        int way = gas.length;
        while (count > 0) {
            if (pos == begin + way) {
                return true;
            }

            int index = pos % way;
            if (count >= cost[index]) {
                count -= cost[index];
                int next = (index + 1) % way;
                count += gas[next];
                pos++;
            } else {
                return false;
            }
        }
        return false;
    }

    // 题解
    public int canCompleteCircuit2(int[] gas, int[] cost) {
        int n = gas.length;
        int i = 0;
        while (i < n) {
            int sumOfGas = 0, sumOfCost = 0;
            int count = 0;
            while (count < n) {
                int j = (i + count) % n;
                sumOfGas += gas[j];
                sumOfCost += cost[j];
                if (sumOfCost > sumOfGas) {
                    break;
                }
                count++;
            }
            if (count == n) {
                return i;
            } else {
                i = i + count + 1;
            }
        }
        return -1;
    }
}
