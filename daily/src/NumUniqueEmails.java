import java.util.HashSet;
import java.util.Set;

/**
 * 929. 独特的电子邮件地址
 * https://leetcode.cn/problems/unique-email-addresses/
 */
public class NumUniqueEmails {
    public static void main(String[] args) {
        String[] emails = {"test.email+alex@leetcode.com", "test.email.leet+alex@code.com"};
        NumUniqueEmails solution = new NumUniqueEmails();
        int ans = solution.numUniqueEmails1(emails);
        System.out.println(ans);

    }

    // 自己写的
    public int numUniqueEmails1(String[] emails) {
        int count = 0;
        Set<String> set = new HashSet<>();
        for (String email : emails) {
            String[] split = email.split("@");
            if (split.length > 2) {
                continue;
            }
            String local = split[0];
            String domain = split[1];
            int addIndex = local.indexOf("+");
            if (addIndex != -1) {
                local = local.substring(0, addIndex);
            }
            local = local.replace(".", "");
            if (set.add(local + "@" + domain)) {
                count++;
            }
        }
        return count;
    }

    // 题解
    public int numUniqueEmails2(String[] emails) {
        Set<String> emailSet = new HashSet<>();
        for (String email : emails) {
            int i = email.indexOf('@');
            String local = email.substring(0, i).split("\\+")[0]; // 去掉本地名第一个加号之后的部分
            local = local.replace(".", ""); // 去掉本地名中所有的句点
            emailSet.add(local + email.substring(i));
        }
        return emailSet.size();
    }

}
