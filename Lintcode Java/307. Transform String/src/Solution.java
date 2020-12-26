import java.util.HashMap;
import java.util.Map;

public class Solution {
    /**
     * @param A: a string A
     * @param B: a string B
     * @return: return the minimum number of operations to transform
     */
    public int transform(String A, String B) {
        // write your code here
        if (A.length() != B.length()) {
            return -1;
        }
        
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length(); i++) {
            char ch = A.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
    
        for (int i = 0; i < B.length(); i++) {
            char ch = B.charAt(i);
            if (!map.containsKey(ch) || map.get(ch) == 0) {
                return -1;
            }
            
            map.put(ch, map.get(ch) - 1);
        }
        
        int j = B.length() - 1;
        for (int i = A.length() - 1; i >= 0; i--) {
            if (A.charAt(i) == B.charAt(j)) {
                j--;
            }
        }
        
        return j + 1;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().transform("EACBD", "EABCD"));
        System.out.println(new Solution().transform("ABD", "BAD"));
    }
}
