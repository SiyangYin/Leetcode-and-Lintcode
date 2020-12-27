import java.util.HashMap;
import java.util.Map;

public class Solution {
    public String similarRGB(String color) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i <= 9; i++) {
            map.put((char) ('0' + i), i);
        }
        for (char i = 'a'; i <= 'f'; i++) {
            map.put(i, i - 'a' + 10);
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append('#');
        
        for (int i = 1; i < color.length(); i += 2) {
            int cur = parseHex(color.substring(i, i + 2), map);
            for (int j = 0; cur - j >= 0 && cur + j <= 272; j++) {
                String n1 = Integer.toHexString(cur + j), n2 = Integer.toHexString(cur - j);
                if (n1.length() < 2) {
                    n1 = "0" + n1;
                }
                if (n2.length() < 2) {
                    n2 = "0" + n2;
                }
                if (n1.charAt(0) == n1.charAt(1)) {
                    sb.append(n1);
                    break;
                }
                if (n2.charAt(0) == n2.charAt(1)) {
                    sb.append(n2);
                    break;
                }
            }
        }
        
        return sb.toString();
    }
    
    private int parseHex(String s, Map<Character, Integer> map) {
        return map.get(s.charAt(0)) * 16 + map.get(s.charAt(1));
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().similarRGB("#09f166"));
    }
}
