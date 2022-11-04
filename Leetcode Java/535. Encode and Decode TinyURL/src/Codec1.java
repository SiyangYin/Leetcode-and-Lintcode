import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Codec1 {
    private String s = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private long id = 0;
    private String prefix = "http://tinyurl.com/";
    private Map<Long, String> map1 = new HashMap<>();
    private Map<String, Long> map2 = new HashMap<>();
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        if (map2.containsKey(longUrl)) {
            return String.format("%s%s", prefix, idToShortUrl(map2.get(longUrl)));
        }
        map1.put(id, longUrl);
        map2.put(longUrl, id);
        return String.format("%s%s", prefix, idToShortUrl(id++));
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        String str = shortUrl.substring(prefix.length());
        long i = shortUrlToId(str);
        if (map1.containsKey(i)) {
            return map1.get(i);
        }
        return "";
    }

    public long shortUrlToId(String shortUrl) {
        long i = 0;
        for (int j = shortUrl.length() - 1; j >= 0; j--) {
            if (shortUrl.charAt(j) >= 'a' && shortUrl.charAt(j) <= 'z') {
                i = i * 62 + shortUrl.charAt(j) - 'a';
            }
            else if (shortUrl.charAt(j) >= 'A' && shortUrl.charAt(j) <= 'Z') {
                i = i * 62 + shortUrl.charAt(j) - 'A' + 26;
            }
            else if (shortUrl.charAt(j) >= '0' && shortUrl.charAt(j) <= '9') {
                i = i * 62 + shortUrl.charAt(j) - '0' + 52;
            }
        }
        return i;
    }

    public String idToShortUrl(long i) {
        StringBuilder sb = new StringBuilder();
        while (i > 0) {
            sb.append(s.charAt((int)(i%62)));
            i /= 62;
        }
        return sb.toString();
    }
}