public class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        
        int maxLen = 1, maxL = 0, maxR = 0;
        for (int i = 2; i <= len; i++) {
            for (int j = 0; j + i - 1 < len; j++) {
                int l = j, r = j + i - 1;
                dp[l][r] = s.charAt(l) == s.charAt(r);
                if (l + 1 <= r - 1) {
                    dp[l][r] &= dp[l + 1][r - 1];
                }
                
                if (dp[l][r] && r - l + 1 > maxLen) {
                    maxLen = r - l + 1;
                    maxL = l;
                    maxR = r;
                }
            }
        }
        
        return s.substring(maxL, maxR + 1);
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().longestPalindrome("aaaa"));
        System.out.println(new Solution().longestPalindrome("cbbd"));
    }
}
