public class Solution {
    /**
     * @param s: A string
     * @param p: A string includes "." and "*"
     * @return: A boolean
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
                        if (i - 1 >= 0 && (p.charAt(j - 1) == s.charAt(i - 1) || p.charAt(j - 1) == '.')) {
                            dp[i][j] = dp[i - 1][j - 1];
                        }
                    } else {
                        if (j - 2 >= 0) {
                            dp[i][j] = dp[i][j - 2];
                        }
                        
                        if (i >= 1 && j >= 2) {
                            dp[i][j] |= dp[i - 1][j] && (p.charAt(j - 2) == s.charAt(i - 1) || p.charAt(j - 2) == '.');
                        }
                    }
                }
            }
        }
        
        return dp[s.length()][p.length()];
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().isMatch("aa", "a*"));
    }
}
