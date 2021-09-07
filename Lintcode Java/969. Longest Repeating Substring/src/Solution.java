import java.util.HashMap;
import java.util.Map;

public class Solution {
    /**
     * @param str: The input string
     * @param k:   The repeated times
     * @return: The answer
     */
    public int longestRepeatingSubsequenceII(String str, int k) {
        // Write your code here
        int n = str.length();
        long[] hash = new long[n + 1], pow = new long[n + 1];
        pow[0] = 1;
        for (int i = 1; i <= n; i++) {
            hash[i] = hash[i - 1] * 131 + str.charAt(i - 1);
            pow[i] = pow[i - 1] * 131;
        }
        
        int l = 0, r = n;
        while (l < r) {
            int mid = l + (r - l + 1 >> 1);
            if (check(mid, hash, pow, k)) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        
        return l;
    }
 
    boolean check(int len, long[] hash, long[] pow, int k) {
        Map<Long, Integer> map = new HashMap<>();
        for (int i = 0; i + len - 1 < hash.length - 1; i++) {
            long h = hash[i + len] - hash[i] * pow[len];
            map.put(h, map.getOrDefault(h, 0) + 1);
            if (map.get(h) >= k) {
                return true;
            }
        }
        
        return false;
    }
}
