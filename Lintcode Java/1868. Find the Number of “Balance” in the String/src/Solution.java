import java.util.HashMap;
import java.util.Map;

public class Solution {
    /**
     * @param S: the string
     * @return: return the number of “Balance” in the string
     */
    public int find(String S) {
        // write your code here
        Map<Character, Integer> left = new HashMap<>(), right = new HashMap<>();
        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            right.put(ch, right.getOrDefault(ch, 0) + 1);
        }
    
        int res = 0;
        for (int i = 0; i < S.length() - 1; i++) {
            char ch = S.charAt(i);
            left.put(ch, left.getOrDefault(ch, 0) +  1);
            right.put(ch, right.get(ch) - 1);
            if (right.get(ch) == 0) {
                right.remove(ch);
            }
            
            if (left.size() == right.size()) {
                res++;
            }
        }
        
        return res;
    }
}
