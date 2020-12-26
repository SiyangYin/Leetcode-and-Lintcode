import java.util.HashMap;
import java.util.Map;

public class Solution {
    /**
     * @param s: a string
     * @return: an integer
     */
    public int lengthOfLongestSubstring(String s) {
        // write your code here
        if (s == null || s.isEmpty()) {
            return 0;
        }
        
        Map<Character, Integer> map = new HashMap<>();
        int j = 0, res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), i);
            } else {
                j = Math.max(j, map.get(s.charAt(i)) + 1);
                map.put(s.charAt(i), i);
            }
            if (i - j + 1 > res) {
                res = i - j + 1;
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        // System.out.println(new Solution().lengthOfLongestSubstring("abcabcbb"));
        // System.out.println(new Solution().lengthOfLongestSubstring("bbbbb"));
        System.out.println(new Solution().lengthOfLongestSubstring("an++--viaj"));
    }
}
