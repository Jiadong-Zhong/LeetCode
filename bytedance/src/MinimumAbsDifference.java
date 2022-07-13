import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumAbsDifference {
    public static void main(String[] args) {
        int[] arr = {4,2,1,3};
    }

    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> ans = new ArrayList<>();
        int minDistance = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length - 1; i++) {
            int distance = arr[i + 1] - arr[i];
            if (distance < minDistance) {
                minDistance = distance;
                ans.clear();
            } else if (distance > minDistance) {
                continue;
            }
            List<Integer> list = new ArrayList<>();
            list.add(arr[i]);
            list.add(arr[i + 1]);
            ans.add(list);
        }
        return ans;
    }
}
