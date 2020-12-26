import java.util.HashMap;
import java.util.Map;

public class Solution {
    /**
     * @param str: the str
     * @return: the sum that the letter appears the most
     */
    public int mostFrequentlyAppearingLetters(String str) {
        // Write your code here.
        if (str == null || str.length() == 0) {
            return 0;
        }
        
        Map<Character, Integer> map = new HashMap<>();
        for (char c : str.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        int res = 0;
        for (int value : map.values()) {
            if (value > res) {
                res = value;
            }
        }
        
        return res;
    }
}