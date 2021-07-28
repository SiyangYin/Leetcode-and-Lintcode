import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        String[] strs = text.split(" ");
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < brokenLetters.length(); i++) {
            set.add(brokenLetters.charAt(i));
        }
    
        int res = 0;
        for (String s : strs) {
            boolean found = false;
            for (int i = 0; i < s.length(); i++) {
                if (set.contains(s.charAt(i))) {
                    found = true;
                    break;
                }
            }
            
            if (!found) {
                res++;
            }
        }
        
        return res;
    }
}
