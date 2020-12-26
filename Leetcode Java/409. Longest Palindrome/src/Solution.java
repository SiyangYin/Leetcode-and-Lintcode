import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int longestPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        
        int res = 0;
        boolean odd = false;
        for (int num : map.values()) {
            res += num / 2 * 2;
            if (num % 2 != 0) {
                odd = true;
            }
        }
        
        return res + (odd ? 1 : 0);
    }
}
