package sword_to_offer;

public class Offer05_replaceSpace {
    public static void main(String[] args) {
        String s = "We are happy";
    }

    // api
    public String replaceSpace1(String s) {
        return s.replace(" ", "%20");
    }

    // 遍历
    public String replaceSpace2(String s) {
        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (ch == ' ') {
                sb.append("%20");
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}
