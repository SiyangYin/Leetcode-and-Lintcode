public class Solution {
    public int repeatedStringMatch(String A, String B) {
        int res = 1;
        StringBuilder sb = new StringBuilder(A);
        while (sb.length() < B.length()) {
            sb.append(A);
            res++;
        }
        
        int[] next = buildNext(B);
        if (match(sb, B, 0, next)) {
            return res;
        }
        
        sb.append(A);
        if (match(sb, B, sb.length() - A.length() - B.length() + 1, next)) {
            return res + 1;
        }
        
        return -1;
    }
    
    private boolean match(StringBuilder s, String p, int start, int[] next) {
        int i = start, j = 0;
        while (i < s.length() && j < p.length()) {
            if (j == -1 || s.charAt(i) == p.charAt(j)) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }
        
        return j == p.length();
    }
    
    private int[] buildNext(String p) {
        int[] next = new int[p.length()];
        int i = 0, j = next[0] = -1;
        while (i < p.length() - 1) {
            if (j == -1 || p.charAt(i) == p.charAt(j)) {
                i++;
                j++;
                next[i] = p.charAt(i) == p.charAt(j) ? next[j] : j;
            } else {
                j = next[j];
            }
        }
        
        return next;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().repeatedStringMatch("abcd", "cdabcdab"));
    }
}
