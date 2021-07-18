public class Solution {
    public int countBinarySubstrings(String s) {
        int res = 0;
        for (int i = 0, cur = 0, last = 0; i < s.length(); i++) {
            int j = i;
            while (j < s.length() && s.charAt(j) == s.charAt(i)) {
                j++;
            }
            
            cur = j - i;
            res += Math.min(last, cur);
            last = cur;
            i = j - 1;
        }
        
        return res;
    }
}
