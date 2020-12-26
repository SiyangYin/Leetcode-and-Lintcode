public class Solution {
    public boolean backspaceCompare(String S, String T) {
        char[] s = S.toCharArray(), t = T.toCharArray();
        int l1 = analyze(s), l2 = analyze(t);
        if (l1 != l2) {
            return false;
        }
    
        for (int i = 0; i < l1; i++) {
            if (s[i] != t[i]) {
                return false;
            }
        }
        
        return true;
    }
    
    private int analyze(char[] s) {
        int i = -1;
        for (int j = 0; j < s.length; j++) {
            if (s[j] != '#') {
                s[++i] = s[j];
            } else if (i >= 0) {
                i--;
            }
        }
        
        return i + 1;
    }
}
