import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 442. 数组中重复的数据
 * https://leetcode-cn.com/problems/find-all-duplicates-in-an-array/
 */
public class FindDuplicates {
    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        List<Integer> ans = findDuplicates3(nums);
        System.out.println(ans);
    }

    public static List<Integer> findDuplicates1(int[] nums) {
        List<Integer> res = new ArrayList<>();
        Set<Integer> count = new HashSet<>();
        for (int num : nums) {
            if (count.contains(num)) {
                res.add(num);
            } else {
                count.add(num);
            }
        }
        return res;
    }

    public static List<Integer> findDuplicates2(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            while (nums[i] != nums[nums[i] - 1]) {
                int temp = nums[i];
                nums[i] = nums[nums[i] - 1];
                nums[nums[i] - 1] = temp;
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] - 1 != i) {
                ans.add(nums[i]);
            }
        }
        return ans;
    }

    public static List<Integer> findDuplicates3(int[] nums) {
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int x = Math.abs(nums[i]);
            if (nums[x - 1] > 0) {
                nums[x - 1] = - nums[x - 1];
            } else {
                ans.add(x);
            }
        }
        return ans;
    }

    public static List<Integer> findDuplicates4(int[] nums) {
        int n = nums.length;
        boolean[] isVisited = new boolean[n];
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (isVisited[nums[i] - 1]) {
                res.add(nums[i]);
            } else {
                isVisited[nums[i] - 1] = true;
            }
        }
        return res;
    }
}
