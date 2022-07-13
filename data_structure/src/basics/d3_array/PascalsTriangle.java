package basics.d3_array;

import java.util.ArrayList;
import java.util.List;

/**
 * 119. 杨辉三角 II
 * https://leetcode-cn.com/problems/pascals-triangle-ii/
 */
public class PascalsTriangle {
    public static void main(String[] args) {
        int rowIndex = 3;
        List<Integer> ans = getRow3(rowIndex);
        System.out.println(ans);
    }

    public static List<Integer> getRow1(int rowIndex) {
        List<Integer> curRow = new ArrayList<>();
        curRow.add(1);
        if (rowIndex == 0) {
            return curRow;
        }
        curRow.add(1);
        if (rowIndex == 1) {
            return curRow;
        }

        List<Integer> preRow = curRow;
        for (int i = 2; i <= rowIndex; i++) {
            curRow = new ArrayList<>();
            curRow.add(1);
            for (int j = 1; j < i; j++) {
                curRow.add(preRow.get(j - 1) + preRow.get(j));
            }
            curRow.add(1);
            preRow = curRow;
        }
        return curRow;
    }

    public static List<Integer> getRow2(int rowIndex) {
        List<Integer> row = new ArrayList<Integer>();
        row.add(1);
        for (int i = 1; i <= rowIndex; ++i) {
            row.add(0);
            for (int j = i; j > 0; --j) {
                row.set(j, row.get(j) + row.get(j - 1));
            }
        }
        return row;
    }

    public static List<Integer> getRow3(int rowIndex) {
        List<Integer> row = new ArrayList<Integer>();
        row.add(1);
        for (int i = 1; i <= rowIndex; ++i) {
            row.add((int) ((long) row.get(i - 1) * (rowIndex - i + 1) / i));
        }
        return row;
    }
}
