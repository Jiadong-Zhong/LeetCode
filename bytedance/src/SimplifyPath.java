import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 71. 简化路径
 * https://leetcode.cn/problems/simplify-path/
 */
public class SimplifyPath {
    public static void main(String[] args) {
        String path = "/a/./b/../../home//foo/";
        SimplifyPath solution = new SimplifyPath();
        String ans = solution.simplifyPath(path);
        System.out.println(ans);
    }

    public String simplifyPath(String s) {
        String[] paths = s.split("/");
        Deque<String> stack = new ArrayDeque<>();
        for (String path : paths) {
            if ("..".equals(path)) {
                if (!stack.isEmpty()) {
                    stack.pollLast();
                }
            } else if (path.length() > 0 && !".".equals(path)) {
                stack.offerLast(path);
            }
        }

        StringBuilder ans = new StringBuilder();
        if (stack.isEmpty()) {
            ans.append("/");
        } else {
            while (!stack.isEmpty()) {
                ans.append("/").append(stack.pollFirst());
            }
        }
        return ans.toString();
    }
}
