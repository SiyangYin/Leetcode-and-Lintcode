public class Solution {
    public boolean repeatedSubstringPattern(String s) {
        if (s == null || s.isEmpty()) {
            return true;
        }
        
        int[] ne = buildNext(s);
        int n = s.length(), l = ne[n];
        return l != 0 && n % (n - l) == 0;
    }
    
    private int[] buildNext(String s) {
        int[] ne = new int[s.length() + 1];
        for (int i = 0, j = ne[0] = -1; i < s.length(); ) {
            if (j == -1 || s.charAt(i) == s.charAt(j)) {
                ne[++i] = ++j;
            } else {
                j = ne[j];
            }
        }
        
        return ne;
    }
    
    public static void main(String[] args) {
        // System.out.println(new Solution().repeatedSubstringPattern("aaaab"));
        System.out.println(new Solution().repeatedSubstringPattern("abab"));
    }
}
