import java.util.*;

public class Solution {
    /**
     * @param words1: a list of string
     * @param words2: a list of string
     * @param pairs:  a list of string pairs
     * @return: return a boolean, denote whether two sentences are similar or not
     */
    public boolean isSentenceSimilarity(String[] words1, String[] words2, List<List<String>> pairs) {
        // write your code here
        Map<String, Set<String>> map = new HashMap<>();
        if (words1.length != words2.length) {
            return false;
        }
    
        for (List<String> pair : pairs) {
            String s1 = pair.get(0), s2 = pair.get(1);
            map.putIfAbsent(s1, new HashSet<>());
            map.putIfAbsent(s2, new HashSet<>());
            
            map.get(s1).add(s2);
            map.get(s2).add(s1);
        }
    
        for (int i = 0; i < words1.length; i++) {
            if (words1[i].equals(words2[i])) {
                continue;
            }
            
            if (!map.get(words1[i]).contains(words2[i])) {
                return false;
            }
        }
        
        return true;
    }
}
