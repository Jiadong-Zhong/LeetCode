import java.util.Arrays;

/**
 * 179. 最大数
 * https://leetcode.cn/problems/largest-number/
 */
public class LargestNumber {
    public static void main(String[] args) {
        int[] nums = {3,30,34,5,9};
        LargestNumber solution = new LargestNumber();
        String ans = solution.largestNumbers2(nums);
        System.out.println(ans);
    }

    // 排序、拼接
    public String largestNumbers1(int[] nums) {
        int n = nums.length;
        Integer[] numsArr = new Integer[n];
        for (int i = 0; i < n; i++) {
            numsArr[i] = nums[i];
        }
        Arrays.sort(numsArr, (o1, o2) -> {
            String str1 = o1 + "";
            String str2 = o2 + "";
            return (int) (Long.parseLong(str2 + str1) - Long.parseLong(str1 + str2));
        });

        if (numsArr[0] == 0) {
            return "0";
        }

        StringBuilder ans = new StringBuilder();
        for (int num : numsArr) {
            ans.append(num);
        }
        return ans.toString();
    }

    public String largestNumbers2(int[] nums) {
        int n = nums.length;
        String[] numsArr = new String[n];
        for (int i = 0; i < n; i++) {
            numsArr[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(numsArr, ((o1, o2) -> (o2 + o1).compareTo(o1 + o2)));

        if ("0".equals(numsArr[0])) {
            return "0";
        }

        StringBuilder ans = new StringBuilder();
        for (String num : numsArr) {
            ans.append(num);
        }
        return ans.toString();
    }
}
