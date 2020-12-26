import java.util.HashMap;
import java.util.Map;

public class Solution {
    /**
     * @param A: A string
     * @param B: A string
     * @return: if string A contains all of the characters in B return true else return false
     */
    public boolean compareStrings(String A, String B) {
        // write your code here
        if (B == null || B.length() == 0) {
            return true;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length(); i++) {
            if (map.containsKey(A.charAt(i))) {
                map.put(A.charAt(i), map.get(A.charAt(i)) + 1);
            } else {
                map.put(A.charAt(i), 1);
            }
        }
        for (int i = 0; i < B.length(); i++) {
            if (map.containsKey(B.charAt(i))) {
                if (map.get(B.charAt(i)) == 0) {
                    return false;
                } else {
                    map.put(B.charAt(i), map.get(B.charAt(i)) - 1);
                }
            } else {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().compareStrings("ABCD", "AABC"));
    }
}