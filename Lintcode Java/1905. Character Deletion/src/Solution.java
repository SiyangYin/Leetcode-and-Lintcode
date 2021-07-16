import java.util.HashSet;
import java.util.Set;

public class Solution {
    /**
     * @param str: The first string given
     * @param sub: The given second string
     * @return: Returns the deleted string
     */
    public String CharacterDeletion(String str, String sub) {
        // write your code here
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < sub.length(); i++) {
            set.add(sub.charAt(i));
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (set.contains(ch)) {
                continue;
            }
            
            sb.append(ch);
        }
        
        return sb.toString();
    }
}
