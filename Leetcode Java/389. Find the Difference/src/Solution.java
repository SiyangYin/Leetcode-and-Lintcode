import java.util.HashMap;
import java.util.Map;

public class Solution {
    public char findTheDifference(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            } else {
                map.put(s.charAt(i), 1);
            }
        }
        for (int i = 0; i < t.length(); i++) {
            if (map.containsKey(t.charAt(i))) {
                map.put(t.charAt(i), map.get(t.charAt(i)) - 1);
                if (map.get(t.charAt(i)) == 0) {
                    map.remove(t.charAt(i));
                }
            } else {
                return t.charAt(i);
            }
        }
        return map.keySet().iterator().next();
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().findTheDifference("bcdss", "bcdess"));
    }
}
