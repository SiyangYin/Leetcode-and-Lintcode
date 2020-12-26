import java.util.HashMap;
import java.util.Map;

public class Solution {
    /**
     * @param s: a string
     * @param k: an integer
     * @return: the number of substrings there are that contain at least k distinct characters
     */
    public long kDistinctCharacters(String s, int k) {
        // Write your code here
        Map<Character, Integer> map = new HashMap<>();
        
        long res = 0;
        for (int i = 0, j = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            
            while (map.size() >= k) {
                res += s.length() - i;
                
                char ch = s.charAt(j);
                map.put(ch, map.get(ch) - 1);
                if (map.get(ch) == 0) {
                    map.remove(ch);
                }
                
                j++;
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().kDistinctCharacters("abcabcabcabc", 3));
    }
}
