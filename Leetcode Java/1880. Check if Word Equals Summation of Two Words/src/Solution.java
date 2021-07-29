public class Solution {
    public boolean isSumEqual(String s1, String s2, String t) {
        return transform(s1) + transform(s2) == transform(t);
    }
    
    private int transform(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            res = res * 10 + s.charAt(i) - 'a';
        }
        
        return res;
    }
}
