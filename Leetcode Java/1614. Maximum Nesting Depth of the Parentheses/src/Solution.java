public class Solution {
    public int maxDepth(String s) {
        int l = 0, res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                l++;
            } else if (s.charAt(i) == ')') {
                l--;
            }
            
            res = Math.max(res, l);
        }
        
        return res;
    }
}
