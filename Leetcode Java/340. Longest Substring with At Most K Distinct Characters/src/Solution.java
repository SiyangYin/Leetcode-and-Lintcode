import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int res = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0, j = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            
            if (map.size() <= k) {
                res = Math.max(res, i - j + 1);
            } else {
                while (map.size() > k) {
                    char ch = s.charAt(j);
                    map.put(ch, map.get(ch) - 1);
                    j++;
                    
                    if (map.get(ch) == 0) {
                        map.remove(ch);
                        break;
                    }
                }
            }
        }
        
        return res;
    }
}
