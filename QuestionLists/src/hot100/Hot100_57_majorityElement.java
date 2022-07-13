package hot100;

/**
 * 169. 多数元素
 * https://leetcode.cn/problems/majority-element/
 */
public class Hot100_57_majorityElement {
    public static void main(String[] args) {
        int[] nums = {7,7,5,7,5,1,5,7,5,5,7,7,7,7,7,7};
        Hot100_57_majorityElement solution = new Hot100_57_majorityElement();
        int ans = solution.majorityElement(nums);
        System.out.println(ans);
    }

    public int majorityElement(int[] nums) {
        int count = 0;
        Integer candidate = null;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
            System.out.println(count);
        }
        return candidate;
    }
}
