public class Solution {
    /**
     * @param s: A string
     * @param p: A string includes "?" and "*"
     * @return: is Match?
     */
    public boolean isMatch(String s, String p) {
        // write your code here
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        for (int i = 0; i <= s.length(); i++) {
            for (int j = 0; j <= p.length(); j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                } else if (j == 0) {
                    dp[i][j] = false;
                } else {
                    if (p.charAt(j - 1) != '*') {
                        if (i > 0 && (p.charAt(j - 1) == s.charAt(i - 1) || p.charAt(j - 1) == '?')) {
                            dp[i][j] |= dp[i - 1][j - 1];
                        }
                    } else {
                        dp[i][j] |= dp[i][j - 1];
                        if (i > 0) {
                            dp[i][j] |= dp[i - 1][j];
                        }
                    }
                }
            }
        }
        
        return dp[s.length()][p.length()];
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().isMatch("aa", "a"));
        System.out.println(new Solution().isMatch("aa", "aa"));
        System.out.println(new Solution().isMatch("aa", "*"));
        System.out.println(new Solution().isMatch("ab", "?*"));
        System.out.println(new Solution().isMatch("aab", "c*a*b"));
    }
}
