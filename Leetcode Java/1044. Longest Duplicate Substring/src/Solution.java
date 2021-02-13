import java.util.HashSet;
import java.util.Set;

public class Solution {
    public String longestDupSubstring(String s) {
        long P = 131;
        long[] hash = new long[s.length() + 1], pow = new long[s.length() + 1];
        pow[0] = 1;
        for (int i = 0; i < s.length(); i++) {
            hash[i + 1] = hash[i] * P + s.charAt(i);
            pow[i + 1] = pow[i] * P;
        }
        
        String res = "";
        int l = 1, r = s.length() - 1;
        while (l < r) {
            int m = l + (r - l + 1 >> 1);
            int[] pair = check(hash, pow, m);
            if (pair != null) {
                l = m;
                res = s.substring(pair[0], pair[1] + 1);
            } else {
                r = m - 1;
            }
        }
        
        int[] pair = check(hash, pow, l);
        if (pair != null) {
            res = s.substring(pair[0], pair[1] + 1);
        }
        
        return res;
    }
    
    private int[] check(long[] hash, long[] pow, int len) {
        Set<Long> set = new HashSet<>();
        for (int r = len - 1; r < hash.length - 1; r++) {
            int l = r - len + 1;
            long hashCode = hash[r + 1] - hash[l] * pow[r - l + 1];
            if (set.contains(hashCode)) {
                return new int[]{l, r};
            }
            set.add(hashCode);
        }
        
        return null;
    }
}
