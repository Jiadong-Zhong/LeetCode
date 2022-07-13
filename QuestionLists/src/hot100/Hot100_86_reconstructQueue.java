package hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 406. 根据身高重建队列
 * https://leetcode.cn/problems/queue-reconstruction-by-height/
 */
public class Hot100_86_reconstructQueue {
    public static void main(String[] args) {
        int[][] people = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        Hot100_86_reconstructQueue solution = new Hot100_86_reconstructQueue();
        int[][] ans = solution.reconstructQueue2(people);
        for (int[] line : ans) {
            System.out.println(Arrays.toString(line));
        }
    }

    // 从低到高
    public int[][] reconstructQueue1(int[][] people) {
        Arrays.sort(people, (person1, person2) -> {
            if (person1[0] != person2[0]) {
                return person1[0] - person2[0];
            } else {
                return person2[1] - person1[1];
            }
        });

        int[][] ans = new int[people.length][2];
        for (int[] person : people) {
            int spaces = person[1] + 1;
            for (int i = 0; i < people.length; i++) {
                if (ans[i] == null) {
                    --spaces;
                    if (spaces == 0) {
                        ans[i] = person;
                        break;
                    }
                }
            }
        }
        return ans;
    }

    // 从高到低
    public int[][] reconstructQueue2(int[][] people) {
        Arrays.sort(people, (person1, person2) -> {
            if (person1[0] != person2[0]) {
                return person2[0] - person1[0];
            } else {
                return person1[1] - person2[1];
            }
        });

        List<int[]> ans = new ArrayList<>();
        for (int[] person : people) {
            ans.add(person[1], person);
        }
        return ans.toArray(new int[ans.size()][]);
    }
}
