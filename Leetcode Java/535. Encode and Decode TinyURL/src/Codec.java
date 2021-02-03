import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Codec {
    
    private Map<String, String> map = new HashMap<>();
    private String s = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private Random random = new Random();
    
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        while (true) {
            String str = getRandomStr(6);
            if (!map.containsKey(str)) {
                map.put(str, longUrl);
                
                return "http://tinyurl.com/" + str;
            }
        }
    }
    
    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return map.get(shortUrl.substring(19));
    }
    
    private String getRandomStr(int k) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < k; i++) {
            sb.append(s.charAt(random.nextInt(s.length())));
        }
        return sb.toString();
    }
}