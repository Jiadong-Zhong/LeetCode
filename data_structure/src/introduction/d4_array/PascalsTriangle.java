package introduction.d4_array;

import java.util.ArrayList;
import java.util.List;

/**
 * 118. 杨辉三角
 * https://leetcode-cn.com/problems/pascals-triangle/
 */
public class PascalsTriangle {
    public static void main(String[] args) {
        int numRows = 5;
        List<List<Integer>> ans = generate1(numRows);
        System.out.println(ans);
    }

    public static List<List<Integer>> generate1(int numRows) {
        List<Integer> curRow = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        if (numRows == 0) {
            return ans;
        }
        curRow.add(1);
        ans.add(curRow);
        if (numRows == 1) {
            return ans;
        }
        curRow = new ArrayList<>();
        curRow.add(1);
        curRow.add(1);
        ans.add(curRow);
        if (numRows == 2) {
            return ans;
        }

        List<Integer> preRow = ans.get(1);
        for (int i = 3; i <= numRows; i++) {
            curRow = new ArrayList<>();
            curRow.add(1);
            for (int j = 1; j < i - 1; j++) {
                curRow.add(preRow.get(j - 1) + preRow.get(j));
            }
            curRow.add(1);
            preRow = curRow;
            ans.add(curRow);
        }
        return ans;
    }

    public static List<List<Integer>> generate2(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> curRow = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    curRow.add(1);
                } else {
                    List<Integer> preRow = ans.get(i - 1);
                    curRow.add(preRow.get(j - 1) + preRow.get(j));
                }
            }
            ans.add(curRow);
        }
        return ans;
    }
}
