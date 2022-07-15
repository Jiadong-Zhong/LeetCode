package SwordToOffer2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Offer2_7_threeSum {
    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for (int first = 0; first < nums.length; first++) {
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            int third = nums.length - 1;
            for (int second = first + 1; second < nums.length; second++) {
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }

                while (second < third && nums[second] + nums[third] > -nums[first]) {
                    third--;
                }

                if (second == third) {
                    break;
                }

                if (nums[second] + nums[third] == -nums[first]) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);
                }
            }
        }
        return ans;
    }
}
