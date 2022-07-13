import java.util.*;

/**
 * 726. 原子的数量
 * https://leetcode.cn/problems/number-of-atoms/
 */
public class CountOfAtoms {
    public static void main(String[] args) {
        String formula = "K4(ON(SO3)2)2";
        CountOfAtoms solution = new CountOfAtoms();
        String ans = solution.countOfAtoms(formula);
        System.out.println(ans);
    }

    int i, n;
    String formula;
    public String countOfAtoms(String formula) {
        this.i = 0;
        this.n = formula.length();
        this.formula = formula;

        Deque<Map<String, Integer>> stack = new ArrayDeque<>();
        stack.push(new HashMap<>()); // 压入空表，统计括号内元子数量
        while (i < n) {
            char ch = formula.charAt(i);
            if (ch == '(') {
                i++;
                stack.push(new HashMap<>());
            } else if (ch == ')') {
                i++;
                int num = parseNum();  // 括号右侧数字
                Map<String, Integer> popMap = stack.pop(); // 括号内原子数量
                Map<String, Integer> topMap = stack.peek();
                for (Map.Entry<String, Integer> entry : popMap.entrySet()) {
                    String atom = entry.getKey();
                    int val = entry.getValue();
                    topMap.put(atom, topMap.getOrDefault(atom, 0) + val * num); // 括号内原子数量乘以num
                }
            } else {
                String atom = parseAtom();
                int num = parseNum();
                Map<String, Integer> topMap = stack.peek();
                topMap.put(atom, topMap.getOrDefault(atom, 0) + num); // 统计原子数量
            }
        }

        // HashMap中数据是无序的，TreeMap是字典序
        Map<String, Integer> map = stack.pop();
        TreeMap<String, Integer> treeMap = new TreeMap<>(map);

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> entry : treeMap.entrySet()) {
            String atom = entry.getKey();
            int count = entry.getValue();
            sb.append(atom);
            if (count > 1) {
                sb.append(count);
            }
        }
        return sb.toString();
    }

    public int parseNum() {
        if (i == n || !Character.isDigit(formula.charAt(i))) {
            return 1;
        }
        int num = 0;
        while (i < n && Character.isDigit(formula.charAt(i))) {
            num = num * 10 + formula.charAt(i++) - '0';
        }
        return num;
    }

    public String parseAtom() {
        StringBuilder sb = new StringBuilder();
        sb.append(formula.charAt(i++));
        while (i < n && Character.isLowerCase(formula.charAt(i))) {
            sb.append(formula.charAt(i++));
        }
        return sb.toString();
    }
}
