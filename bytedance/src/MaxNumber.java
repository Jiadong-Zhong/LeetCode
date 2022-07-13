import java.util.ArrayList;
import java.util.List;

public class MaxNumber {

    public static void main(String[] args) {
        int n = 2111;
        int[] nums = {2,4,9};
        MaxNumber solution = new MaxNumber();
        int ans = solution.maxNumber3(n, nums);
        System.out.println(ans);
    }


    int ans;
    public int maxNumber(int n, int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        dfs(String.valueOf(n), 0, false, 0, list);
        return ans;
    }

    public boolean dfs(String n, int index, boolean pass, int temp, List<Integer> list) {
        if (index == n.length()) {
            ans = temp;
            return true;
        }

        // pass为ture表示最高位没有数，或者上一位数已经小于对应n中的值，后续只需要选最大即可
        if (pass) {
            return dfs(n, index + 1, true, temp * 10 + list.get(list.size() - 1), list);
        } else {
            int val = n.charAt(index) - '0';
            for (int i = list.size() - 1; i >= 0; i--) {
                if (val == list.get(i)) {
                    if (dfs(n, index + 1, false, temp * 10 + list.get(i), list)) {
                        return true;
                    }
                } else if (val > list.get(i)) {
                    if (dfs(n, index + 1, true, temp * 10 + list.get(i), list)) {
                        return true;
                    }
                }
            }
        }

        // 如果这一位都放不了，并且index不为0
        if (index != 0) {
            return false;
        }
        return dfs(n, index + 1, true, temp, list);
    }

    int num = 0;
    public int maxNumber2(int n, int[] nums) {
        backtrack(n, nums);
        return ans;
    }

    public void backtrack(int n, int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            num = num * 10 + nums[i];
            if (num > n) {
                num = (num - nums[i]) / 10;
                continue;
            }
            ans = Math.max(ans, num);
            backtrack(n, nums);
            num = (num - nums[i]) / 10;
        }
    }

    public int maxNumber3(int n, int[] nums) {
        int targetTime = 0;
        int temp = n;
        while (temp != 0) {
            temp /= 10;
            targetTime++;
        }
        dfs(nums, 0, n, targetTime, 0);
        return ans;
    }

    public void dfs(int[] nums, int res, int n, int targetTime, int currTime) {
        if (currTime >= targetTime) {
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            res = res * 10 + nums[i];
            currTime++;
            if (res > n) {
                return;
            } else {
                ans = Math.max(ans, res);
            }
            dfs(nums, res, n, targetTime, currTime);
            res /= 10;
            currTime--;
        }
    }
}
