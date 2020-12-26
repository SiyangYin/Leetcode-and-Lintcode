import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        // the current index of character
        Map<Character, Integer> map = new HashMap<>();
        // try to extend the range [i, j]
        for (int i = 0, j = 0; j < s.length(); j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)) + 1, i);
            }
            
            res = Math.max(res, j - i + 1);
            map.put(s.charAt(j), j);
        }
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLongestSubstring("aabcbaa"));
    }
}
