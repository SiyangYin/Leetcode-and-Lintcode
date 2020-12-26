public class Solution2 {
    public String longestPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }
        
        int l = 0, r = 0, maxLen = 1;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i, k = i; j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k); j--, k++) {
                if (k - j + 1 > maxLen) {
                    maxLen = k - j + 1;
                    l = j;
                    r = k;
                }
            }
    
            for (int j = i, k = i + 1; j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k); j--, k++) {
                if (k - j + 1 > maxLen) {
                    maxLen = k - j + 1;
                    l = j;
                    r = k;
                }
            }
        }
        
        return s.substring(l, r + 1);
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution2().longestPalindrome("abbc"));
    }
}
