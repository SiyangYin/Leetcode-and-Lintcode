import java.util.HashMap;
import java.util.Map;

public class Solution {
    /**
     * @param s: A string containing only uppercase and lowercase letters
     * @return: Judge whether it can become a palindrome
     */
    public boolean isPalindrome(String s) {
        // write your code here
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        
        int odd = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() % 2 == 1) {
                odd++;
            }
        }
        
        return odd <= 1;
    }
}
