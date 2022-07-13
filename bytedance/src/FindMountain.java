/**
 * 寻找峰值
 * https://www.nowcoder.com/practice/1af528f68adc4c20bf5d1456eddb080a?tpId=117
 */
public class FindMountain {
    public static void main(String[] args) {
        int[] nums = {9, 8, 7, 6, 5, 4};
        FindMountain solution = new FindMountain();
        int ans = solution.findMountain(nums);
        System.out.println(ans);
    }

    public int findMountain(int[] nums) {
        int index = nums.length - 1;
        while (index > 0 && nums[index] < nums[index - 1]) {
            index--;
        }
        return index;
    }
}
