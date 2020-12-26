import java.util.Arrays;

public class Solution {
    /**
     * @param s1: a string
     * @param s2: a string
     * @return: if s2 contains the permutation of s1
     */
    public boolean checkInclusion(String s1, String s2) {
        // write your code here
        if (s2.length() < s1.length()) {
            return false;
        }
        
        int[] letters1 = new int[26], letters2 = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            letters1[s1.charAt(i) - 'a']++;
            letters2[s2.charAt(i) - 'a']++;
        }
        
        if (Arrays.equals(letters1, letters2)) {
            return true;
        }
    
        for (int i = s1.length(); i < s2.length(); i++) {
            letters2[s2.charAt(i) - 'a']++;
            letters2[s2.charAt(i - s1.length()) - 'a']--;
            if (Arrays.equals(letters1, letters2)) {
                return true;
            }
        }
        
        return false;
    }
}
