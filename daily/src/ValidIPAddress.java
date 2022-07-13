/**
 * 468. 验证IP地址
 * https://leetcode.cn/problems/validate-ip-address/
 */
public class ValidIPAddress {
    public static void main(String[] args) {
        String queryIP1 = "2001:0db8:85a3:0000:0000:8a2e:0370:7334";
        String queryIP2 = "2001:db8:85a3:0:0:8A2E:0370:7334";
        String queryIP3 = "2001:0db8:85a3:0:0:8A2E:0370:7334:";
        ValidIPAddress solution = new ValidIPAddress();
        System.out.println(solution.validIPAddress1(queryIP1));
        System.out.println(solution.validIPAddress1(queryIP2));
        String s3 = solution.validIPAddress2(queryIP3);
        System.out.println(s3);

    }

    // 自己写的
    public String validIPAddress1(String queryIP) {
        if (queryIP.startsWith(".") || queryIP.startsWith(":") || queryIP.endsWith(".") || queryIP.endsWith(":")) {
            return "Neither";
        }
        String[] ipv4Split = queryIP.split("\\.");
        if (ipv4Split.length == 4) {
            boolean ipv4Flag = true;
            for (String s : ipv4Split) {
                String regex = "[\\d]{"+ s.length()+"}";
                if (s.length() == 0 || s.length() > 3 || !s.matches(regex)) {
                    ipv4Flag = false;
                    break;
                }
                int val = Integer.parseInt(s);
                if (val < 0 || val > 255 || !s.equals("" + val)) {
                    ipv4Flag = false;
                    break;
                }
            }
            if (ipv4Flag) {
                return "IPv4";
            }
        }
        String[] ipv6Split = queryIP.split(":");
        if (ipv6Split.length == 8) {
            boolean ipv6Flag = true;
            for (String s : ipv6Split) {
                if (!s.matches("[a-fA-F\\d]{1,4}")) {
                    ipv6Flag = false;
                    break;
                }
            }
            if (ipv6Flag) {
                return "IPv6";
            }
        }
        return "Neither";
    }

    public String validIPAddress2(String queryIP) {
        if (queryIP.indexOf('.') >= 0) {
            // IPv4
            int last = -1;
            for (int i = 0; i < 4; i++) {
                int cur = (i == 3 ? queryIP.length() : queryIP.indexOf('.', last + 1));
                if (cur < 0) {
                    return "Neither";
                }
                if (cur - last - 1 < 1 || cur - last - 1 > 3) {
                    return "Neither";
                }
                int addr = 0;
                for (int j = last + 1; j < cur; j++) {
                    if (!Character.isDigit(queryIP.charAt(j))) {
                        return "Neither";
                    }
                    addr = addr * 10 + (queryIP.charAt(j) - '0');
                }
                if (addr > 255) {
                    return "Neither";
                }
                if (addr > 0 && queryIP.charAt(last + 1) == '0') {
                    return "Neither";
                }
                if (addr == 0 && cur - last - 1 > 1) {
                    return "Neither";
                }
                last = cur;
            }
            return "IPv4";
        } else {
            // IPv6
            int last = -1;
            for (int i = 0; i < 8; i++) {
                int cur = (i == 7 ? queryIP.length() : queryIP.indexOf(':', last + 1));
                if (cur < 0) {
                    return "Neither";
                }
                if (cur - last - 1 < 1 || cur - last - 1 > 4) {
                    return "Neither";
                }
                for (int j = last + 1; j < cur; j++) {
                    if (!Character.isDigit(queryIP.charAt(j)) && !('a' <= Character.toLowerCase(queryIP.charAt(j)) && Character.toLowerCase(queryIP.charAt(j)) <= 'f')) {
                        return "Neither";
                    }
                }
                last = cur;
            }
            return "IPv6";
        }
    }
}
