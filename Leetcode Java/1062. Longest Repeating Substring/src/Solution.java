import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int longestRepeatingSubstring(String s) {
        long P = 131;
        long[] hash = new long[s.length() + 1], pow = new long[s.length() + 1];
        pow[0] = 1;
        for (int i = 1; i <= s.length(); i++) {
            hash[i] = hash[i - 1] * P + s.charAt(i - 1);
            pow[i] = pow[i - 1] * P;
        }
        
        int l = 0, r = s.length() - 1;
        while (l < r) {
            int mid = l + (r - l + 1 >> 1);
            if (check(mid, hash, pow)) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        
        return l;
    }
    
    private boolean check(int len, long[] hash, long[] pow) {
        Set<Long> set = new HashSet<>();
        for (int i = len; i < hash.length; i++) {
            long ha = hash[i] - hash[i - len] * pow[len];
            if (!set.add(ha)) {
                return true;
            }
        }
        
        return false;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().longestRepeatingSubstring("abbaba"));
        System.out.println(new Solution().longestRepeatingSubstring("aabcaabdaab"));
    }
}
