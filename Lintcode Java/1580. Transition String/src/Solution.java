import java.util.HashMap;
import java.util.Map;

public class Solution {
    /**
     * @param A: a string A
     * @param B: a string B
     * @return: Return the minimum number of operations to transform.
     */
    public int transform(String A, String B) {
        // write your code here
        if (A.length() != B.length()) {
            return 0;
        }
        
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < A.length(); i++) {
            char a = A.charAt(i), b = B.charAt(i);
            if (map.containsKey(a)) {
                return 0;
            }
            
            map.put(a, b);
        }
    
        for (char ch = 'a'; ch <= 'z'; ch++) {
            if (!map.containsKey(ch)) {
                continue;
            }
            if (map.get(ch) == ch) {
                map.remove(ch);
                continue;
            }
            
            char prev = ch, next = map.get(ch);
            while (map.containsKey(next)) {
                map.remove(prev);
                prev = next;
                next = map.get(next);
                if (next == ch) {
                    return 0;
                }
            }
        }
        
        return 1;
    }
    
    public static void main(String[] args) {
        // System.out.println(new Solution().transform("abc", "cde"));
        System.out.println(new Solution().transform("abc", "bca"));
        System.out.println(new Solution().transform("aba", "cde"));
    }
}
