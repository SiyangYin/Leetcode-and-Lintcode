import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Solution {
    /**
     * @param pattern: a string, denote pattern string
     * @param teststr: a string, denote matching string
     * @return: an boolean, denote whether the pattern string and the matching string match or not
     */
    public boolean wordPattern(String pattern, String teststr) {
        // write your code here
        Map<Character, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        String[] strings = teststr.split(" ");
    
        for (int i = 0; i < pattern.length(); i++) {
            if (!Objects.equals(map1.put(pattern.charAt(i), i), map2.put(strings[i], i))) {
                return false;
            }
        }
        
        return true;
    }
}
