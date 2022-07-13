import java.util.ArrayList;
import java.util.List;

/**
 * 315. 计算右侧小于当前元素的个数
 * https://leetcode.cn/problems/count-of-smaller-numbers-after-self/
 */
public class CountSmaller {
    public static void main(String[] args) {
        int[] nums = {5,2,6,1};
        CountSmaller solution = new CountSmaller();
        List<Integer> ans = solution.countSmaller(nums);
        System.out.println(ans);
    }

    // 不对
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        int[] ansArr = new int[n];
        for (int i = n - 2; i >= 0; i--) {
            int p = i + 1;
            while (p < n && nums[i] <= nums[p]) {
                p++;
            }
            if (p == n) {
                ansArr[i] = 0;
            } else {
                ansArr[i] = ansArr[p] + 1;
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int num : ansArr) {
            ans.add(num);
        }
        return ans;
    }
}
