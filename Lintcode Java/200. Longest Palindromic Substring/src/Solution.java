public class Solution {
    /**
     * @param s: input string
     * @return: the longest palindromic substring
     */
    public String longestPalindrome(String s) {
        // write your code here
        int n = s.length();
        int[] interval = new int[2];
        int longestLen = 1;
        boolean[][] dp = new boolean[n][n];
        for (int len = 1; len <= n; len++) {
            for (int l = 0; l + len - 1 < n; l++) {
                int r = l + len - 1;
                
                dp[l][r] = s.charAt(l) == s.charAt(r);
                if (len > 2) {
                    dp[l][r] &= dp[l + 1][r - 1];
                }
                
                if (dp[l][r] && len > longestLen) {
                    longestLen = len;
                    interval[0] = l;
                    interval[1] = r;
                }
            }
        }
        
        return s.substring(interval[0], interval[1] + 1);
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().longestPalindrome("abb"));
    }
}
