/**
 * 6. Z 字形变换
 * https://leetcode.cn/problems/zigzag-conversion/
 */
public class Convert {
    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int numRows = 3;
        Convert solution = new Convert();
        String ans = solution.convert3(s, numRows);
        System.out.println(ans);
    }

    // 矩阵模拟
    public String convert1(String s, int numRows) {
        if (numRows == 1 || numRows >= s.length()) {
            return s;
        }
        int numOneBlock = 2 * numRows - 2;
        int colNum = (s.length() + numOneBlock - 1) / numOneBlock * (numRows - 1);
        char[][] matrix = new char[numRows][colNum];
        for (int index = 0, x = 0, y = 0; index < s.length(); index++) {
            matrix[x][y] = s.charAt(index);
            if (index % numOneBlock < numRows - 1) {
                x++;
            } else {
                x--;
                y++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] != 0) {
                    sb.append(matrix[i][j]);
                }
            }
        }
        return sb.toString();
    }

    // 压缩矩阵空间
    // 每次每行添加的元素都添加在这行右侧，因此不必保持矩阵的样式，每一行使用一个列表即可
    public String convert2(String s, int numRows) {
        int n = s.length();
        if (numRows == 1 || numRows >= n) {
            return s;
        }
        StringBuilder[] matrix = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            matrix[i] = new StringBuilder();
        }
        int numOneBlock = 2 * numRows - 2;
        for (int index = 0, x = 0; index < n; index++) {
            matrix[x].append(s.charAt(index));
            if (index % numOneBlock < numRows - 1) {
                x++;
            } else {
                x--;
            }
        }
        StringBuilder ans = new StringBuilder();
        for (StringBuilder row : matrix) {
            ans.append(row);
        }
        return ans.toString();
    }

    // 直接构造
    public String convert3(String s, int numRows) {
        int n = s.length();
        if (numRows == 1 || numRows >= n) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        int t = numRows * 2 - 2;
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < n; j += t) {
                sb.append(s.charAt(j + i));
                // 下面的判断，i > 0 保证不是第一行， i < numRows - 1 保证不是最后一行
                // j + t - i < n 即中间两行
                if (i > 0 && i < numRows - 1 && j + t - i < n) {
                    sb.append(s.charAt(j + t - i));
                }
            }
        }
        return sb.toString();
    }
}
