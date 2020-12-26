public class Solution {
    public int[] shortestToChar(String S, char C) {
        if (S == null || S.isEmpty()) {
            return new int[0];
        }
        
        int pos = -S.length();
        int[] res = new int[S.length()];
    
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == C) {
                pos = i;
            }
            res[i] = i - pos;
        }
    
        pos = S.length() * 2;
        for (int i = S.length() - 1; i >= 0; i--) {
            if (S.charAt(i) == C) {
                pos = i;
            }
            res[i] = Math.min(res[i], pos - i);
        }
        
        return res;
    }
}
