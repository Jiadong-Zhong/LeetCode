package hot100;

import java.util.*;

/**
 * 399. 除法求值
 * https://leetcode.cn/problems/evaluate-division/
 */
public class Hot100_85_calcEquation {
    public static void main(String[] args) {
        List<String> equation1 = new ArrayList<>() {{
            add("a");
            add("b");
        }};
        List<String> equation2 = new ArrayList<>() {{
            add("b");
            add("c");
        }};
        List<List<String>> equations = new ArrayList<>() {{
            add(equation1);
            add(equation2);
        }};

        List<String> query1 = new ArrayList<>() {{
            add("a");
            add("c");
        }};
        List<String> query2 = new ArrayList<>() {{
            add("b");
            add("a");
        }};
        List<String> query3 = new ArrayList<>() {{
            add("a");
            add("e");
        }};
        List<String> query4 = new ArrayList<>() {{
            add("a");
            add("a");
        }};
        List<String> query5 = new ArrayList<>() {{
            add("x");
            add("x");
        }};
        List<List<String>> queries = new ArrayList<>() {{
            add(query1);
            add(query2);
            add(query3);
            add(query4);
            add(query5);
        }};

        double[] values = {2.0, 3.0};

        Hot100_85_calcEquation solution = new Hot100_85_calcEquation();
        double[] ans = solution.calcEquation(equations, values, queries);
        System.out.println(Arrays.toString(ans));
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int nvars = 0;
        Map<String, Integer> variables = new HashMap<>();

        int n = equations.size();
        for (int i = 0; i < n; i++) {
            if (!variables.containsKey(equations.get(i).get(0))) {
                variables.put(equations.get(i).get(0), nvars++);
            }
            if (!variables.containsKey(equations.get(i).get(1))) {
                variables.put(equations.get(i).get(1), nvars++);
            }
        }

        // 对每个点，存储器直接连接到的所有点及对应的权值
        List<Pair>[] edges = new List[nvars];
        for (int i = 0; i < nvars; i++) {
            edges[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            int va = variables.get(equations.get(i).get(0)), vb = variables.get(equations.get(i).get(1));
            edges[va].add(new Pair(vb, values[i]));
            edges[vb].add(new Pair(va, 1.0 / values[i]));
        }

        int queriesCount = queries.size();
        double[] ans = new double[queriesCount];
        for (int i = 0; i < queriesCount; i++) {
            List<String> query = queries.get(i);
            double result = -1.0;
            if (variables.containsKey(query.get(0)) && variables.containsKey(query.get(1))) {
                int ia = variables.get(query.get(0)), ib = variables.get(query.get(1));
                if (ia == ib) {
                    result = 1.0;
                } else {
                    Deque<Integer> points = new ArrayDeque<>();
                    points.offer(ia);
                    double[] ratios = new double[nvars];
                    Arrays.fill(ratios, -1.0);
                    ratios[ia] = 1.0;

                    while (!points.isEmpty() && ratios[ib] < 0) {
                        int x = points.poll();
                        for (Pair pair : edges[x]) {
                            int y = pair.index;
                            double val = pair.value;
                            if (ratios[y] < 0) {
                                ratios[y] = ratios[x] * val;
                                points.offer(y);
                            }
                        }
                    }
                    result = ratios[ib];
                }
            }
            ans[i] = result;
        }
        return ans;
    }

    class Pair {
        int index;
        double value;

        Pair(int index, double value) {
            this.index = index;
            this.value = value;
        }
    }
}
