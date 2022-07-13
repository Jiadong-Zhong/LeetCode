/**
 * 162. 寻找峰值
 * https://leetcode.cn/problems/find-peak-element/
 */
public class FindPeakElement {
    public static void main(String[] args) {
        int[] nums = {1,2,1,3,5,6,4};
        FindPeakElement solution = new FindPeakElement();
        int ans = solution.findPeakElement(nums);
        System.out.println(ans);
    }

    public int findPeakElement(int[] nums) {
        int n = nums.length;
        int left = 0, right = n - 1, ans = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (compare(nums, mid - 1, mid) < 0 && compare(nums, mid, mid + 1) > 0) {
                ans = mid;
                break;
            }

            if (compare(nums, mid, mid + 1) < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    // 如果是边界，返回值[0]则为0，如果不是边界返回值[0]则为1
    public int[] get(int[] nums, int index) {
        if (index == -1 || index == nums.length) {
            return new int[] {0,0};
        }
        return new int[] {1, nums[index]};
    }

    public int compare(int[] nums, int index1, int index2) {
        int[] num1 = get(nums, index1);
        int[] num2 = get(nums, index2);
        if (num1[0] != num2[0]) {
            return num1[0] > num2[0] ? 1 : -1;
        }
        if (num1[1] == num2[1]) {
            return 0;
        }
        return num1[1] > num2[1] ? 1 : -1;
    }
}
