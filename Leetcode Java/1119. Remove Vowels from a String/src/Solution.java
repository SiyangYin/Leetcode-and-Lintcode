import java.util.HashSet;
import java.util.Set;

public class Solution {
    public String removeVowels(String S) {
        if (S == null || S.isEmpty()) {
            return S;
        }
    
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (!set.contains(c)) {
                sb.append(c);
            }
        }
        
        return sb.toString();
    }
}
