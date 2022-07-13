import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 535. TinyURL 的加密与解密
 * https://leetcode.cn/problems/encode-and-decode-tinyurl/
 */
public class TinyURL {
    public static void main(String[] args) {

    }

    // 自增
    private class Codec1 {
        private Map<Integer, String> dataBase = new HashMap<>();
        private int id;

        public String encode(String longUrl) {
            id++;
            dataBase.put(id, longUrl);
            return "http://tinyurl.com/" + id;
        }

        public String decode(String shortUrl) {
            int p = shortUrl.lastIndexOf('/') + 1;
            int key = Integer.parseInt(shortUrl.substring(p));
            return dataBase.get(key);
        }
    }

    // 随机生成
    private class Codec2 {
        private Map<Integer, String> dataBase = new HashMap<>();
        private Random random = new Random();

        public String encode(String longUrl) {
            int key;
            while (true) {
                key = random.nextInt();
                if (!dataBase.containsKey(key)) {
                    break;
                }
            }
            dataBase.put(key, longUrl);
            return "http://tinyurl.com/" + key;
        }

        public String decode(String shortUrl) {
            int p = shortUrl.lastIndexOf('/') + 1;
            int key = Integer.parseInt(shortUrl.substring(p));
            return dataBase.get(key);
        }
    }
}






