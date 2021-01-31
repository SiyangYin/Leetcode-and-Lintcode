import java.util.*;

public class Solution {
    /**
     * @param words:   word list
     * @param pattern: pattern string
     * @return: list of matching words
     */
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        // Write your code here.
        List<String> res = new ArrayList<>();
        for (String word : words) {
            if (check(word, pattern)) {
                res.add(word);
            }
        }
        
        return res;
    }
    
    private boolean check(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        
        Map<Character, Integer> mapS = new HashMap<>(), mapT = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!Objects.equals(mapS.put(s.charAt(i), i), mapT.put(t.charAt(i), i))) {
                return false;
            }
        }
        
        return true;
    }
}
