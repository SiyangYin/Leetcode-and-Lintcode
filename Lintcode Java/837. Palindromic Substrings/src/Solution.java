public class Solution {
    /**
     * @param str: s string
     * @return: return an integer, denote the number of the palindromic substrings
     */
    public int countPalindromicSubstrings(String str) {
        // write your code here
        int res = 0;
        boolean[][] dp = new boolean[str.length()][str.length()];
        for (int len = 1; len <= str.length(); len++) {
            for (int i = 0; i + len - 1 < str.length(); i++) {
                int l = i, r = i + len - 1;
                if (len == 1) {
                    dp[l][r] = true;
                } else if (len == 2) {
                    dp[l][r] = str.charAt(l) == str.charAt(r);
                } else {
                    dp[l][r] = str.charAt(l) == str.charAt(r) && dp[l + 1][r - 1];
                }
                
                if (dp[l][r]) {
                    res++;
                }
            }
        }
        
        return res;
    }
}
