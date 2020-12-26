import java.util.HashMap;
import java.util.Map;

public class Solution {
    /**
     * @param str: str: the given string
     * @return: char: the first unique character in a given string
     */
    public char firstUniqChar(String str) {
        // Write your code here
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) + 1);
        }
    
        for (int i = 0; i < str.length(); i++) {
            if (map.get(str.charAt(i)) == 1) {
                return str.charAt(i);
            }
        }
        
        return 0;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().firstUniqChar(new String("aabccd")));
    }
}