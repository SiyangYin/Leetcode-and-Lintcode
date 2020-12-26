public class Solution {
    /**
     * @param s: the maximum length of s is 1000
     * @return: the longest palindromic subsequence's length
     */
    public int longestPalindromeSubseq(String s) {
        // write your code here
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        int[][] dp = new int[s.length()][s.length()];
        for (int len = 1; len <= s.length(); len++) {
            for (int i = 0; i + len - 1 < s.length(); i++) {
                int l = i, r = i + len - 1;
                if (len == 1) {
                    dp[l][r] = 1;
                } else {
                    boolean firstLast = s.charAt(l) == s.charAt(r);
                    if (len == 2) {
                        dp[l][r] = firstLast ? 2 : 1;
                    } else {
                        dp[l][r] = firstLast ? dp[l + 1][r - 1] + 2 : Math.max(dp[l + 1][r], dp[l][r - 1]);
                    }
                }
            }
        }
        
        return dp[0][s.length() - 1];
    }
    
    public static void main(String[] args) {
        String s = "bbbab";
        System.out.println(new Solution().longestPalindromeSubseq(s));
    }
}
