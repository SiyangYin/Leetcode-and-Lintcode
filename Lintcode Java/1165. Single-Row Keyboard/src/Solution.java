import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int calculateTime(String keyboard, String word) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < keyboard.length(); i++) {
            map.put(keyboard.charAt(i), i);
        }
        
        int res = map.get(word.charAt(0));
        for (int i = 0; i < word.length() - 1; i++) {
            res += Math.abs(map.get(word.charAt(i + 1)) - map.get(word.charAt(i)));
        }
        
        return res;
    }
}
