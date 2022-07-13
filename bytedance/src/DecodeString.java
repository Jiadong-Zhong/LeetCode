import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 394. 字符串解码
 * https://leetcode.cn/problems/decode-string/
 */
public class DecodeString {
    public static void main(String[] args) {
        String s = "3[a]2[bc]";
    }

    // 栈
    int p;

    public String decodeString1(String s) {
        LinkedList<String> stack = new LinkedList<>();
        p = 0;
        while (p < s.length()) {
            char cur = s.charAt(p);
            if (Character.isDigit(cur)) {
                // 数字进栈
                String digits = getDigits(s);
                stack.addLast(digits);
            } else if (Character.isLetter(cur) || cur == '[') {
                // 字母进栈
                stack.addLast(String.valueOf(s.charAt(p++)));
            } else {
                p++;
                LinkedList<String> sub = new LinkedList<>();
                while (!"[".equals(stack.peekLast())) {
                    sub.addLast(stack.removeLast());
                }
                Collections.reverse(sub);
                // 左括号出栈
                stack.removeLast();
                // 此时栈顶为sub对应的字符串应该出现的次数
                int repTime = Integer.parseInt(stack.removeLast());
                StringBuilder t = new StringBuilder();
                String o = getString(sub);
                // 构造字符串
                while (repTime-- > 0) {
                    t.append(o);
                }
                // 将构造好的字符串入栈
                stack.addLast(t.toString());
            }
        }
        return getString(stack);
    }

    public String getDigits(String s) {
        StringBuilder res = new StringBuilder();
        while (Character.isDigit(s.charAt(p))) {
            res.append((s.charAt(p++)));
        }
        return res.toString();
    }

    public String getString(LinkedList<String> v) {
        StringBuilder res = new StringBuilder();
        for (String s : v) {
            res.append(s);
        }
        return res.toString();
    }

    // 递归
    String src;
    // int p; // 已经在上个方法中声明
    public String decodeString2(String s) {
        src = s;
        p = 0;
        return getString2();
    }

    public String getString2() {
        if (p == src.length() || src.charAt(p) == ']') {
            return "";
        }

        char cur = src.charAt(p);
        int repTime = 1;
        String res = "";

        if (Character.isDigit(cur)) {
            // Digits [String] String
            repTime = getDigits2();
            // 过滤左括号
            p++;
            // 解析string
            String str = getString2();
            // 过滤右括号
            p++;
            // 构造字符串
            while (repTime-- > 0) {
                res += str;
            }
        } else if (Character.isLetter(cur)) {
            res = String.valueOf(src.charAt(p++));
        }

        return res + getString2();
    }

    public int getDigits2() {
        int res = 0;
        while (p < src.length() && Character.isDigit(src.charAt(p))) {
            res = res * 10 + src.charAt(p++) - '0';
        }
        return res;
    }

    // 更容易理解的做法
    public String decodeString3(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c != ']') {
                // 将除 ] 的所有都push进去
                stack.push(c);
            } else {
                // 取出 [] 内的字符串
                StringBuilder sb = new StringBuilder();
                while (!stack.isEmpty() && Character.isLetter(stack.peek())) {
                    sb.insert(0, stack.pop());
                }
                String sub = sb.toString();
                stack.pop(); // 去除[

                // 获取倍数数字
                sb = new StringBuilder();
                while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
                    sb.insert(0, stack.pop());
                }
                int count = Integer.parseInt(sb.toString());

                // 根据倍数再把字母push回去
                while (count > 0) {
                    for (char ch : sub.toCharArray()) {
                        stack.push(ch);
                    }
                    count--;
                }
            }
        }

        // 把栈内所有字母都取出来
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            res.insert(0, stack.pop());
        }
        return res.toString();
    }
}
