public class Solution {
    /**
     * @param A: a string
     * @param B: a string
     * @return: return an integer
     */
    public int repeatedStringMatch(String A, String B) {
        // write your code here
        StringBuilder a = new StringBuilder(A);
        char[] b = B.toCharArray();
        int res = 1;
        while (a.length() < B.length()) {
            a.append(A);
            res++;
        }
        
        if (index(a.toString().toCharArray(), b) != -1) {
            return res;
        }
        
        a.append(A);
        res++;
        if (index(a.toString().toCharArray(), b) != -1) {
            return res;
        }
        
        return -1;
    }
    
    private int index(char[] s, char[] p) {
        int[] next = buildNext(p);
        for (int i = 0, j = 0; i < s.length; ) {
            if (j == -1 || s[i] == p[j]) {
                i++;
                j++;
            } else {
                j = next[j];
            }
            
            if (j == p.length) {
                return i - j;
            }
        }
        
        return -1;
    }
    
    private int[] buildNext(char[] p) {
        int[] next = new int[p.length];
        for (int i = 0, j = next[0] = -1; i < p.length - 1; ) {
            if (j == -1 || p[i] == p[j]) {
                j++;
                i++;
                next[i] = p[i] != p[j] ? j : next[j];
            } else {
                j = next[j];
            }
        }
        
        return next;
    }
}
