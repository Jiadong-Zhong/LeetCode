import java.util.Arrays;

/**
 * 937. 重新排列日志文件
 * https://leetcode-cn.com/problems/reorder-data-in-log-files/
 */
public class ReorderLogFiles {
    public static void main(String[] args) {
        String[] logs = {"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"};

    }

    public static String[] reorderLogFiles1(String[] logs) {
        int length = logs.length;
        Pair[] arr = new Pair[length];
        for (int i = 0; i < length; i++) {
            arr[i] = new Pair(logs[i], i);
        }
        Arrays.sort(arr, (a, b) -> logCompare(a, b));
        String[] reordered = new String[length];
        for (int i = 0; i < length; i++) {
            reordered[i] = arr[i].log;
        }
        return reordered;
    }

    public static int logCompare(Pair pair1, Pair pair2) {
        String log1 = pair1.log;
        String log2 = pair2.log;
        int index1 = pair1.index;
        int index2 = pair2.index;

        String[] split1 = log1.split(" ", 2);
        String[] split2 = log2.split(" ", 2);
        boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
        boolean isDigit2 = Character.isDigit(split2[1].charAt(0));

        if (isDigit1 && isDigit2) {
            return index1 - index2;
        }

        if (!isDigit1 && !isDigit2) {
            int sc = split1[1].compareTo(split2[1]);
            if (sc != 0) {
                return sc;
            }
            return split1[0].compareTo(split2[0]);
        }
        return isDigit1 ? 1 : -1;
    }

}

class Pair {
    String log;
    int index;

    public Pair(String log, int index) {
        this.log = log;
        this.index = index;
    }
}