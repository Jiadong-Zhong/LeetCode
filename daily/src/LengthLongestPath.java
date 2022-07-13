import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * 388. 文件的最长绝对路径
 * https://leetcode-cn.com/problems/longest-absolute-file-path/
 */
public class LengthLongestPath {
    public static void main(String[] args) {
        String input = "a\n\taa\n\t\taaa\n\t\t\tfile1.txt\naaaaaaaaaaaaaaaaaaaaa\n\tsth.png";
        int res = lengthLongestPath3(input);
        System.out.println(res);
    }

    public static int lengthLongestPath1(String input) {
        int n = input.length();
        int pos = 0;
        int ans = 0;
        Deque<Integer> stack = new ArrayDeque<>();

        while (pos < n) {
            // 检测深度
            int depth = 1;
            while (pos < n && input.charAt(pos) == '\t') {
                pos++;
                depth++;
            }
            // 检测文件名长度
            boolean isFile = false;
            int len = 0;
            while (pos < n && input.charAt(pos) != '\n') {
                if (input.charAt(pos) == '.') {
                    isFile = true;
                }
                len++;
                pos++;
            }
            pos++;

            while (stack.size() >= depth) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                len += stack.peek() + 1;
            }
            if (isFile) {
                ans = Math.max(ans, len);
            } else {
                stack.push(len);
            }
        }
        return ans;
    }

    public static int lengthLongestPath2(String path) {
        int n = path.length();
        int pos = 0;
        int ans = 0;
        int[] level = new int[n + 1];

        while (pos < n) {
            int depth = 1;
            while (pos < n && path.charAt(pos) == '\t') {
                depth++;
                pos++;
            }

            int len = 0;
            boolean isFile = false;
            while (pos < n && path.charAt(pos) != '\n') {
                if (path.charAt(pos) == '.') {
                    isFile = true;
                }
                len++;
                pos++;
            }
            pos++;

            if (depth > 1) {
                len += level[depth - 1] + 1;
            }
            if (isFile) {
                ans = Math.max(ans, len);
            } else {
                level[depth] = len;
            }
        }
        return ans;
    }

    public static int lengthLongestPath3(String path) {
        int ans = 0;
        int[] lengthCount = new int[path.length()];
        String[] path_split = path.split("\n");
        for (int i = 0; i < path_split.length; i++) {
            String s = path_split[i];
            int count = 0;
            while (count < s.length() && s.charAt(count) == '\t') {
                count++;
            }
            lengthCount[count + 1] = lengthCount[count] + s.length() - count;
            if (s.contains(".")) {
                ans = Math.max(ans, lengthCount[count + 1] + count);
            }
        }
        return ans;
    }

    public static int lengthLongestPath4(String intput) {
        int ans = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        String[] path_array = intput.split("\n");
        for (int i = 0; i < path_array.length; i++) {
            String s = path_array[i];
            int depth = 0;
            while (depth < s.length() && s.charAt(depth) == '\t') {
                depth++;
            }

            while (stack.size() > depth + 1) {
                stack.pop();
            }

            int len = s.length() - depth + stack.peek();
            if (s.contains(".")) {
                ans = Math.max(ans, len + depth);
            } else {
                stack.push(len);
            }
        }
        return ans;
    }

    public static int lengthLongestPath5(String input) {
        String s[] = input.split("\n");
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int ans = 0;
        for (int i = 0; i < s.length; i++) {
            int lev = level(s[i]);
            while (stack.size() > lev + 1) {
                stack.pop();
            }
            int l = s[i].length() - lev + stack.peek();
            if (s[i].contains(".")) {
                ans = Math.max(ans, l + lev);
            } else {
                stack.push(l);
            }
        }
        return ans;
    }

    public static int level(String path) {
        for (int i = 0; i < path.length(); i++) {
            if (path.charAt(i) != '\t') {
                return i;
            }
        }
        return -1;
    }
}
