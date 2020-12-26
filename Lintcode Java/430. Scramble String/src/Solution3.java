public class Solution3 {
    /**
     * @param s1: A string
     * @param s2: Another string
     * @return: whether s2 is a scrambled string of s1
     */
    public boolean isScramble(String s1, String s2) {
        // write your code here
        if (s1.length() != s2.length()) {
            return false;
        }
        
        int n = s1.length();
        boolean[][][] dp = new boolean[n][n][n + 1];
    
        for (int len = 1; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                for (int j = 0; j <= n - len; j++) {
                    if (len == 1) {
                        dp[i][j][len] = s1.charAt(i) == s2.charAt(j);
                        continue;
                    }
                    
                    for (int w = 1; w <= len - 1; w++) {
                        dp[i][j][len] |= dp[i][j][w] && dp[i + w][j + w][len - w];
                        dp[i][j][len] |= dp[i][j + len - w][w] && dp[i + w][j][len - w];
                        
                        if (dp[i][j][len]) {
                            break;
                        }
                    }
                }
            }
        }
        
        return dp[0][0][n];
    }
}
