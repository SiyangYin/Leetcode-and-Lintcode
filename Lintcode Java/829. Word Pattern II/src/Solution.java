import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    /**
     * @param pattern: a string,denote pattern string
     * @param str:     a string, denote matching string
     * @return: a boolean
     */
    public boolean wordPatternMatch(String pattern, String str) {
        // write your code here
        return dfs(0, 0, pattern, str, new HashMap<>(), new HashSet<>());
    }
    
    private boolean dfs(int ppos, int spos, String pattern, String str, Map<Character, String> map, Set<String> set) {
        if (ppos == pattern.length() && spos == str.length()) {
            return true;
        }
        
        if (ppos == pattern.length() || spos == str.length()) {
            return false;
        }
        
        if (pattern.length() - ppos > str.length() - spos) {
            return false;
        }
        
        char c = pattern.charAt(ppos);
        if (map.containsKey(c)) {
            String s = map.get(c);
            if (spos + s.length() > str.length()) {
                return false;
            }
            
            for (int j = 0; j < s.length(); j++) {
                if (str.charAt(spos + j) != s.charAt(j)) {
                    return false;
                }
            }
            
            if (dfs(ppos + 1, spos + s.length(), pattern, str, map, set)) {
                return true;
            }
        } else {
            for (int j = spos + 1; j <= str.length(); j++) {
                String sub = str.substring(spos, j);
                if (set.contains(sub)) {
                    continue;
                }
                
                set.add(sub);
                map.put(c, sub);
                if (dfs(ppos + 1, spos + sub.length(), pattern, str, map, set)) {
                    return true;
                }
                set.remove(sub);
                map.remove(c);
            }
        }
        
        return false;
    }
    
    public static void main(String[] args) {
        // System.out.println(new Solution().wordPatternMatch("lwpstyfsjf", "htkvcxwxkymrvrpcxw"));
        // System.out.println(new Solution().wordPatternMatch("d", "ef"));
        System.out.println(new Solution().wordPatternMatch("ab", "aa"));
    }
}
