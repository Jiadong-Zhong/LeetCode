/**
 * 1108. IP 地址无效化
 * https://leetcode.cn/problems/defanging-an-ip-address/
 */
public class DefangIPaddr {
    public String defangIPaddr(String address) {
        return address.replace(".", "[.]");
    }
}
