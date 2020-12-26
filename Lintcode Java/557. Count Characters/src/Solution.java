import java.util.HashMap;
import java.util.Map;

public class Solution {
    /*
     * @param str: a string
     * @return: Return a hash map
     */
    public Map<Character, Integer> countCharacters(String str) {
        // write your code here
        Map<Character, Integer> map = new HashMap<>();
        if (str == null || str.isEmpty()) {
            return map;
        }
    
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        return map;
    }
}
