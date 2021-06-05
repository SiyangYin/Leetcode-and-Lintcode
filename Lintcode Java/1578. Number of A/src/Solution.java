public class Solution {
    /**
     * @param s: the given string
     * @return: the number of A
     */
    public int countA(String s) {
        // Write your code here
        if (s.isEmpty()) {
            return 0;
        }
        
        int start = 0;
        int l = 0, r = s.length() - 1;
        while (l < r) {
            int m = l + (r - l >> 1);
            if (s.charAt(m) == 'B') {
                l = m + 1;
            } else {
                r = m;
            }
        }
        
        if (s.charAt(l) != 'A') {
            return 0;
        }
        
        start = l;
        l = 0;
        r = s.length() - 1;
        while (l < r) {
            int m = l + (r - l + 1 >> 1);
            if (s.charAt(m) >= 'C') {
                r = m - 1;
            } else {
                l = m;
            }
        }
        
        return l - start + 1;
    }
}
