import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        
        Map<Character, Integer> map1 = new HashMap<>(), map2 = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!Objects.equals(map1.put(s.charAt(i), i), map2.put(t.charAt(i), i))) {
                return false;
            }
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        // System.out.println(new Solution().isIsomorphic("aba", "baa"));
        System.out.println(new Solution().isIsomorphic("ab", "aa"));
    }
}
