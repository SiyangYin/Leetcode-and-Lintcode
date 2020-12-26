import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Solution {
    public boolean wordPattern(String pattern, String str) {
        Map<Character, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        String[] words = str.split(" ");
        
        if (pattern.length() != words.length) {
            return false;
        }
    
        for (int i = 0; i < pattern.length(); i++) {
            if (!Objects.equals(map1.put(pattern.charAt(i), i), map2.put(words[i], i))) {
                return false;
            }
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        String pattern = "abba";
        String str = "dog cat cat dog";
        System.out.println(new Solution().wordPattern(pattern, str));
    }
}
