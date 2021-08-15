public class Solution {
    public int countGoodSubstrings(String s) {
        int res = 0;
        for (int i = 0; i < s.length() - 2; i++) {
            if (check(s, i)) {
                res++;
            }
        }
        
        return res;
    }
    
    boolean check(String s, int l) {
        return s.charAt(l) != s.charAt(l + 1) && s.charAt(l) != s.charAt(l + 2) && s.charAt(l + 1) != s.charAt(l + 2);
    }
}
