public class Solution {
    /**
     * @param s1: A string
     * @param s2: A string
     * @param s3: A string
     * @return: Determine whether s3 is formed by interleaving of s1 and s2
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        // write your code here
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        
        int l1 = s1.length(), l2 = s2.length();
        boolean[][] dp = new boolean[l1 + 1][l2 + 1];
        
        for (int i = 0; i <= l1; i++) {
            for (int j = 0; j <= l2; j++) {
                if (i == 0 && j == 0) {
                    dp[0][0] = true;
                } else {
                    dp[i][j] = false;
                    if (i > 0 && s1.charAt(i - 1) == s3.charAt(i + j - 1)) {
                        dp[i][j] |= dp[i - 1][j];
                    }
                    if (j > 0 && s2.charAt(j - 1) == s3.charAt(i + j - 1)) {
                        dp[i][j] |= dp[i][j - 1];
                    }
                }
            }
        }
        
        return dp[l1][l2];
    }
    
    public static void main(String[] args) {
        String s = "aac";
        String t = "aae";
        String r = "aaeaae";
        System.out.println(new Solution().isInterleave(s, t, r));
    }
}
