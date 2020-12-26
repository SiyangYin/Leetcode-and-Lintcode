import java.util.Arrays;

public class Solution {
    /**
     * @param S:
     * @param C:
     * @return: nothing
     */
    public int[] shortestToChar(String S, char C) {
        // write your code here
        int[] res = new int[S.length()];
        Arrays.fill(res, S.length());
        
        int pos = -1;
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == C) {
                pos = i;
            }
            
            if (pos != -1) {
                res[i] = i - pos;
            }
        }
        
        pos = -1;
        for (int i = S.length() - 1; i >= 0; i--) {
            if (S.charAt(i) == C) {
                pos = i;
            }
            if (pos != -1) {
                res[i] = Math.min(res[i], pos - i);
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().shortestToChar("lovelintcode", 'e')));
    }
}
