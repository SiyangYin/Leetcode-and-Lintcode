import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    /**
     * @param s: a string
     * @param p: a string
     * @return: a list of index
     */
    public List<Integer> findAnagrams(String s, String p) {
        // write your code here
        List<Integer> res = new ArrayList<>();
        if (s.length() < p.length()) {
            return res;
        }
        
        int[] pletters = new int[26], sletters = new int[26];
        for (int i = 0; i < p.length(); i++) {
            pletters[p.charAt(i) - 'a']++;
            sletters[s.charAt(i) - 'a']++;
        }
        
        if (Arrays.equals(pletters, sletters)) {
            res.add(0);
        }
    
        for (int i = p.length(); i < s.length(); i++) {
            sletters[s.charAt(i - p.length()) - 'a']--;
            sletters[s.charAt(i) - 'a']++;
            
            if (Arrays.equals(pletters, sletters)) {
                res.add(i - p.length() + 1);
            }
        }
        
        return res;
    }
}
