import java.util.HashMap;
import java.util.Map;

public class Solution2 {
    public boolean isIsomorphic(String s, String t) {
        if (s == null && t == null || s.length() == 0 && t.length() == 0) {
            return true;
        }
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = map.put(s.charAt(i), t.charAt(i));
            if(c != null && c != map.get(s.charAt(i))) {
                return false;
            }
        }
        map.clear();
//        System.out.println(map);
        for (int i = 0; i < s.length(); i++) {
            Character c = map.put(t.charAt(i), s.charAt(i));
            if(c != null && c != map.get(t.charAt(i))) {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().isIsomorphic("ab", "aa"));
    }
}
