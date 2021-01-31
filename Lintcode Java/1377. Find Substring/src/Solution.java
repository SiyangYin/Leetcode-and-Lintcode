import java.util.HashSet;
import java.util.Set;

public class Solution {
    /**
     * @param str: The string
     * @param k:   The length of the substring
     * @return: The answer
     */
    public int findSubstring(String str, int k) {
        // Write your code here
        if (k > str.length()) {
            return 0;
        }
        
        long p = 131, hash = 0, pow = 1;
        int[] count = new int[26];
        for (int i = 0; i < k; i++) {
            count[str.charAt(i) - 'a']++;
            pow *= p;
            hash = hash * p + str.charAt(i);
        }
        
        Set<Long> set = new HashSet<>();
        if (check(count)) {
            set.add(hash);
        }
    
        for (int i = k; i < str.length(); i++) {
            hash = hash * p + str.charAt(i);
            hash -= str.charAt(i - k) * pow;
            
            count[str.charAt(i) - 'a']++;
            count[str.charAt(i - k) - 'a']--;
    
            if (check(count)) {
                set.add(hash);
            }
        }
        
        return set.size();
    }
    
    private boolean check(int[] count) {
        for (int i = 0; i < 26; i++) {
            if (count[i] > 1) {
                return false;
            }
        }
        
        return true;
    }
}

