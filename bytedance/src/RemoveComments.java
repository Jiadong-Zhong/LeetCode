import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class RemoveComments {
    public static void main(String[] args) {
        String[] source = {"struct Node{", "    /*/ declare members;/**/", "    int size;", "    /**/int val;", "};"};
        RemoveComments solution = new RemoveComments();
        List<String> ans = solution.removeComments(source);
        System.out.println(ans);
    }

    public List<String> removeComments(String[] source) {
        List<String> ans = new ArrayList<>();
        boolean blockFlag = false;
        StringBuilder newLine = new StringBuilder();

        for (String s : source) {
            int i = 0;
            char[] chars = s.toCharArray();
            if (!blockFlag) {
                newLine = new StringBuilder();
            }
            while (i < s.length()) {
                if (!blockFlag && i + 1 < s.length() && chars[i] == '/' && chars[i + 1] == '*') {
                    blockFlag = true;
                    i++;
                } else if (blockFlag && i + 1 < s.length() && chars[i] == '*' && chars[i + 1] == '/') {
                    blockFlag = false;
                    i++;
                } else if (!blockFlag && i + 1 < s.length() && chars[i] == '/' && chars[i + 1] == '/') {
                    break;
                } else if (!blockFlag) {
                    newLine.append(chars[i]);
                }
                i++;
            }
            if (!blockFlag && newLine.length() > 0) {
                ans.add(newLine.toString());
            }
        }
        return ans;
    }
}
