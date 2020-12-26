import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Solution {
    /**
     * @param s: a string
     * @param t: a string
     * @return: true if the characters in s can be replaced to get t or false
     */
    public boolean isIsomorphic(String s, String t) {
        // write your code here
        if (s == null && t == null) {
            return true;
        } else if (s == null || t == null) {
            return false;
        } else if (s.length() != t.length()) {
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
}
