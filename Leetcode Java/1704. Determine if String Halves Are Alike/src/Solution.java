import java.util.Set;

public class Solution {
    public boolean halvesAreAlike(String s) {
        int x1 = 0, x2 = 0;
        Set<Character> set = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            x1 += set.contains(s.charAt(i)) ? 1 : 0;
            x2 += set.contains(s.charAt(j)) ? 1 : 0;
        }
        
        return x1 == x2;
    }
}
