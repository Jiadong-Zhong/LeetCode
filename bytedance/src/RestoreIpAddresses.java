import java.util.ArrayList;
import java.util.List;

/**
 * 93. 复原 IP 地址
 * https://leetcode.cn/problems/restore-ip-addresses/
 */
public class RestoreIpAddresses {
    public static void main(String[] args) {
        String s = "25525511135";
        RestoreIpAddresses solution = new RestoreIpAddresses();
        List<String> ans = solution.restoreIpAddresses(s);
        System.out.println(ans);
    }

    List<String> ans = new ArrayList<>();
    int[] segments = new int[4];
    public List<String> restoreIpAddresses(String s) {
        if (s.length() < 4) {
            return ans;
        }
        dfs(s, 0, 0);
        return ans;
    }

    private void dfs(String s, int segId, int segStart) {
        if (segId == 4) {
            if (segStart == s.length()) {
                StringBuilder ipAddr = new StringBuilder();
                for (int i = 0; i < 4; i++) {
                    ipAddr.append(segments[i]);
                    if (i != 3) {
                        ipAddr.append(".");
                    }
                }
                ans.add(ipAddr.toString());
            }
            return;
        }

        // 如果还没有找到4段就已经遍历完了字符串进行提前回溯
        if (segStart == s.length()) {
            return;
        }

        // 不能有前导0，如果为0，这一段ip只能为0
        if (s.charAt(segStart) == '0') {
            segments[segId] = 0;
            dfs(s, segId + 1, segStart + 1);
        }

        // 一般情况
        int addr = 0;
        for (int segEnd = segStart; segEnd < s.length(); segEnd++) {
            addr = addr * 10 + (s.charAt(segEnd) - '0');
            if (addr > 0 && addr <= 255) {
                segments[segId] = addr;
                dfs(s, segId + 1, segEnd + 1);
            } else {
                break;
            }
        }

    }
}
