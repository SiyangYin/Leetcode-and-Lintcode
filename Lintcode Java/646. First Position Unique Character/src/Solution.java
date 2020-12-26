import java.util.HashMap;
import java.util.Map;

public class Solution {
    /**
     * @param s: a string
     * @return: it's index
     */
    public int firstUniqChar(String s) {
        // write your code here
        if (s == null || s.isEmpty()) {
            return 0;
        }
        
        Map<Character, Boolean> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!map.containsKey(ch)) {
                map.put(ch, true);
            } else {
                map.put(ch, false);
            }
        }
    
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (map.get(ch)) {
                return i;
            }
        }
        
        return -1;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().firstUniqChar("lovelintcode"));
    }
}
