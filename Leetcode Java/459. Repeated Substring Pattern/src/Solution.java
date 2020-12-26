public class Solution {
    public boolean repeatedSubstringPattern(String s) {
        if (s == null || s.isEmpty()) {
            return true;
        }
        
        int[] next = buildNext(s);
        int n = s.length(), l = next[n];
        return l != 0 && n % (n - l) == 0;
    }
    
    private int[] buildNext(String s) {
        int[] next = new int[s.length() + 1];
        int i = 0, j = next[0] = -1;
        while (i < s.length()) {
            while (j != -1 && s.charAt(i) != s.charAt(j)) {
                j = next[j];
            }
            i++;
            j++;
            next[i] = j;
        }
        
        return next;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().repeatedSubstringPattern("aaaab"));
    }
}
