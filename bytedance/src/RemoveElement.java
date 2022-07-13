/**
 * 27. 移除元素
 * https://leetcode.cn/problems/remove-element/
 */
public class RemoveElement {
    public static void main(String[] args) {
        int[] nums = {3,2,2,3};
        int val = 3;

        RemoveElement solution = new RemoveElement();
        int ans = solution.removeElement2(nums, val);
        System.out.println(ans);
    }

    public int removeElement1(int[] nums, int val) {
        int left = 0, right = 0;
        int n = nums.length;
        while(right < n) {
            if (nums[right] != val) {
                swap(nums, left, right);
                left++;
            }
            right++;
        }
        return left;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public int removeElement2(int[] nums, int val) {
        int left = 0, right = nums.length;
        while (left < right) {
            if (nums[left] == val) {
                nums[left] = nums[right - 1];
                right--;
            } else {
                left++;
            }
        }
        return left;
    }
}
