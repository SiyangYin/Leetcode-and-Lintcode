import java.util.HashMap;
import java.util.Map;

public class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        
        int cnt = map.size(), l = -1, r = -1;
        for (int i = 0, j = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) - 1);
            if (map.get(ch) == 0) {
                cnt--;
            }
            
            while (cnt == 0 && map.get(s.charAt(j)) < 0) {
                map.put(s.charAt(j), map.get(s.charAt(j)) + 1);
                j++;
            }
            
            if (cnt == 0 && (l == -1 || i - j < r - l)) {
                l = j;
                r = i;
            }
        }
        
        return l == -1 ? "" : s.substring(l, r + 1);
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().minWindow("ADOBECODEBANC", "ABC"));
    }
}
