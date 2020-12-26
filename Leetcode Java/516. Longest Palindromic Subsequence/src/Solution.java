public class Solution {
    public int longestPalindromeSubseq(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        
        int[][] dp = new int[s.length()][s.length()];
        for (int len = 1; len <= s.length(); len++) {
            for (int i = 0; i + len - 1 < s.length(); i++) {
                int l = i, r = i + len - 1;
                if (len == 1) {
                    dp[l][r] = 1;
                } else if (len == 2) {
                    dp[l][r] = s.charAt(l) == s.charAt(r) ? 2 : 1;
                } else {
                    dp[l][r] = dp[l + 1][r - 1];
                    if (s.charAt(l) == s.charAt(r)) {
                        dp[l][r] += 2;
                    } else {
                        dp[l][r] = Math.max(dp[l + 1][r], dp[l][r - 1]);
                    }
                }
            }
        }
        
        return dp[0][s.length() - 1];
    }
}
