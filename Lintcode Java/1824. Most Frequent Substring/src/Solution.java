import java.util.HashMap;
import java.util.Map;

public class Solution {
    /**
     * @param s: string s
     * @param minLength: min length for the substring
     * @param maxLength: max length for the substring
     * @param maxUnique: max unique letter allowed in the substring
     * @return: the max occurrences of substring
     */
    public int getMaxOccurrences(String s, int minLength, int maxLength, int maxUnique) {
        // write your code here
        if (minLength > s.length()) {
            return 0;
        }
        
        Map<Long, Integer> map = new HashMap<>();
        int[] count = new int[26];
        long hash = 0, P = 131, pow = 1;
        for (int i = 0; i < minLength; i++) {
            hash = hash * P + s.charAt(i);
            pow *= P;
            count[s.charAt(i) - 'a']++;
        }
    
        if (check(count, maxUnique)) {
            map.put(hash, 1);
        }
        
        int res = map.getOrDefault(hash, 0);
        for (int i = minLength; i < s.length(); i++) {
            hash = hash * P + s.charAt(i);
            hash -= s.charAt(i - minLength) * pow;
            count[s.charAt(i) - 'a']++;
            count[s.charAt(i - minLength) - 'a']--;
            if (check(count, maxUnique)) {
                map.put(hash, map.getOrDefault(hash, 0) + 1);
                res = Math.max(res, map.get(hash));
            }
        }
        
        return res;
    }
    
    private boolean check(int[] count, int maxUnique) {
        int dif = 0;
        for (int i : count) {
            if (i > 0) {
                dif++;
                if (dif > maxUnique) {
                    return false;
                }
            }
        }
        
        return true;
    }
}
