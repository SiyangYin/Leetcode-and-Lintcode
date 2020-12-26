import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int maxNumberOfBalloons(String text) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('b', 0);
        map.put('a', 0);
        map.put('l', 0);
        map.put('o', 0);
        map.put('n', 0);
    
        for (int i = 0; i < text.length(); i++) {
            if (map.containsKey(text.charAt(i))) {
                map.put(text.charAt(i), map.get(text.charAt(i)) + 1);
            }
        }
        
        int res = Integer.MAX_VALUE;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            char c = entry.getKey();
            if (c == 'b' || c == 'a' || c == 'n') {
                res = Math.min(res, entry.getValue());
            } else {
                res = Math.min(res, entry.getValue() / 2);
            }
        }
        
        return res;
    }
}
