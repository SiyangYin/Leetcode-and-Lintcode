import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    /**
     * @param s: a string
     * @param k: an integer
     * @return: all unique substring
     */
    public List<String> uniqueSubstring(String s, int k) {
        // Write your code here
        List<String> res = new ArrayList<>();
        if (s.length() < k) {
            return res;
        }
        
        long p = 131, hash = 0, pow = 1;
        Set<Long> set = new HashSet<>();
        for (int i = 0; i < k; i++) {
            hash = hash * p + s.charAt(i);
            pow *= p;
        }
        set.add(hash);
        res.add(s.substring(0, k));
        
        for (int i = k; i < s.length(); i++) {
            hash = hash * p + s.charAt(i);
            hash -= s.charAt(i - k) * pow;
            
            if (!set.contains(hash)) {
                set.add(hash);
                res.add(s.substring(i - k + 1, i + 1));
            }
        }
    
        res.sort(null);
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().uniqueSubstring("caaab", 2));
    }
}
