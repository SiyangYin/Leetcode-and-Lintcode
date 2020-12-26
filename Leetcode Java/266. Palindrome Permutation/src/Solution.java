import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean canPermutePalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return true;
        }
        
        Map<Character, Integer> map = new HashMap<>();
        
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
    
        int odd = 0;
        for (int n : map.values()) {
            if (n % 2 != 0) {
                odd++;
            }
            if (odd > 1) {
                return false;
            }
        }
        
        return true;
    }
}
