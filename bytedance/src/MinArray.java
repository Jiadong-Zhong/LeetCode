/**
 * 剑指 Offer 11. 旋转数组的最小数字
 * https://leetcode.cn/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/
 */
public class MinArray {
    public static void main(String[] args) {
        int[] nums = {3,5,1};
        MinArray solution = new MinArray();
        int ans = solution.minArray1(nums);
        System.out.println(ans);
    }

    public int minArray1(int[] numbers) {
        int low = 0;
        int high = numbers.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (numbers[mid] < numbers[high]) {
                high = mid;
            } else if (numbers[mid] > numbers[high]) {
                low = mid + 1;
            } else {
                high -= 1;
            }
        }
        return numbers[low];
    }
}
