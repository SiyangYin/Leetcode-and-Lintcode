import java.util.HashMap;
import java.util.Map;

public class Solution {
    /**
     * @param A: a string
     * @param B: a string
     * @return: a boolean
     */
    public boolean Permutation(String A, String B) {
        // write your code here
        if (A.length() != B.length()) {
            return false;
        }
        
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length(); i++) {
            map.put(A.charAt(i), map.getOrDefault(A.charAt(i), 0) + 1);
        }
        for (int i = 0; i < B.length(); i++) {
            if (!map.containsKey(B.charAt(i))) {
                return false;
            }
            map.put(B.charAt(i), map.get(B.charAt(i)) - 1);
            if (map.get(B.charAt(i)) < 0) {
                return false;
            }
        }
        
        return true;
    }
}
