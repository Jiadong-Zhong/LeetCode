package hot100;

/**
 * 11. 盛最多水的容器
 * https://leetcode.cn/problems/container-with-most-water/
 */
public class Hot100_7_maxArea {
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        Hot100_7_maxArea solution = new Hot100_7_maxArea();
        int res = solution.maxArea(height);
        System.out.println(res);
    }

    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int res = 0;
        while (left < right) {
            int area = Math.min(height[left], height[right]) * (right - left);
            res = Math.max(res, area);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return res;
    }


}
