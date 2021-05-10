public class Solution {
    public int balancedStringSplit(String s) {
        int res = 0;
        for (int i = 0, l = 0, r = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'L') {
                l++;
            } else {
                r++;
            }
            
            if (l == r) {
                res++;
                l = r = 0;
            }
        }
        
        return res;
    }
}
