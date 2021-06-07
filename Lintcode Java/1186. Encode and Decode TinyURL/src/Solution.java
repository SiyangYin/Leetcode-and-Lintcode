import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Solution {
    
    private Map<String, String> map = new HashMap<>();
    private Random random = new Random();
    private String s = "0123456789abcdefghijklmnopqrstuvwxyz";
    
    public String encode(String longUrl) {
        // Encodes a URL to a shortened URL.
        String t;
        while (map.containsKey(t = generate())) {
            t = generate();
        }
        
        map.put(t, longUrl);
        return t;
    }
    
    
    public String decode(String shortUrl) {
        // Decodes a shortened URL to its original URL.
        return map.get(shortUrl);
    }
    
    private String generate() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            sb.append(s.charAt(random.nextInt(s.length())));
        }
        
        return sb.toString();
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().s.length());
    }
}
