import java.util.Arrays;

public class Solution {
    /**
     * @param A: string A
     * @param B: string B
     * @return: bool
     */
    public boolean buddyStrings(String A, String B) {
        // Write your code here
        if (A.length() != B.length()) {
            return false;
        }
        
        int len = A.length();
        int diff = 0;
        boolean has2 = false;
        int[] countA = new int[26], countB = new int[26];
        for (int i = 0; i < len; i++) {
            countA[A.charAt(i) - 'a']++;
            countB[B.charAt(i) - 'a']++;
            
            if (countA[A.charAt(i) - 'a'] >= 2) {
                has2 = true;
            }
            if (A.charAt(i) != B.charAt(i)) {
                diff++;
            }
        }
        
        if (!Arrays.equals(countA, countB)) {
            return false;
        }
        
        if (diff == 2 || (diff == 0 && has2)) {
            return true;
        }
        
        return false;
    }
}
