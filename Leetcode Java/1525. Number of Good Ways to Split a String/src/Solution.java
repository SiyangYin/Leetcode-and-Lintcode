import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int numSplits(String s) {
        Map<Character, Integer> left = new HashMap<>(), right = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            right.put(ch, right.getOrDefault(ch, 0) + 1);
        }
    
        int res = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            char ch = s.charAt(i);
            left.put(ch, left.getOrDefault(ch, 0) + 1);
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
