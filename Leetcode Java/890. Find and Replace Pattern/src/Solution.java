import java.util.*;

public class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> res = new ArrayList<>();
        if (words == null || words.length == 0) {
            return res;
        }
    
        for (String word : words) {
            if (match(word, pattern)) {
                res.add(word);
            }
        }
        
        return res;
    }
    
    private boolean match(String s, String p) {
        if (s.length() != p.length()) {
            return false;
        }
        
        Map<Character, Integer> map1 = new HashMap<>(), map2 = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!Objects.equals(map1.put(s.charAt(i), i), map2.put(p.charAt(i), i))) {
                return false;
            }
        }
        
        return true;
    }
}
