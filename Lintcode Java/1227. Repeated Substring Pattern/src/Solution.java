public class Solution {
    /**
     * @param s: a string
     * @return: return a boolean
     */
    public boolean repeatedSubstringPattern(String s) {
        // write your code here
        int n = s.length();
        int[] next = buildNext(s + '#');
        return next[n] > 0 && n % (n - next[n]) == 0;
    }
    
    private int[] buildNext(String s) {
        int[] next = new int[s.length()];
        next[0] = -1;
        for (int i = 0, j = -1; i < s.length() - 1; ) {
            if (j < 0 || s.charAt(i) == s.charAt(j)) {
                next[++i] = ++j;
            } else {
                j = next[j];
            }
        }
        
        return next;
    }
}
