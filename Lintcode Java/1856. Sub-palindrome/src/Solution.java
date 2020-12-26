import java.util.HashSet;
import java.util.Set;

public class Solution {
    /**
     * @param s: the string
     * @return: the number of substring
     */
    public int countSubstrings(String s) {
        // Write your code here.
        Set<String> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            int l = i;
            for (int j = 0; j < 2; j++) {
                int r = l + j;
                while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                    set.add(s.substring(l, r + 1));
                    l--;
                    r++;
                }
                
                l = i;
            }
        }
        
        return set.size();
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().countSubstrings("abaaa"));
    }
}
