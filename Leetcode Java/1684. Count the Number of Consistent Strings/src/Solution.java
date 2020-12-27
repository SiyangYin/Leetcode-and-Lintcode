import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < allowed.length(); i++) {
            set.add(allowed.charAt(i));
        }
        
        int res = 0;
        for (String word : words) {
            boolean ok = true;
            for (int i = 0; i < word.length(); i++) {
                if (!set.contains(word.charAt(i))) {
                    ok = false;
                    break;
                }
            }
            
            if (ok) {
                res++;
            }
        }
        
        return res;
    }
}
