public class Solution {
    /**
     * @param S: A string
     * @param T: A string
     * @return: Count the number of distinct subsequences
     */
    public int numDistinct(String S, String T) {
        // write your code here
        int l1 = S.length(), l2 = T.length();
        int[][] dp = new int[l1 + 1][l2 + 1];
        
        for (int i = 0; i <= l1; i++) {
            for (int j = 0; j <= l2; j++) {
                if (j == 0) {
                    dp[i][j] = 1;
                } else if (i == 0) {
                    dp[i][j] = 0;
                } else {
                    if (S.charAt(i - 1) == T.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                    
                }
            }
        }
        System.out.println(dp[0][0]);
        
        return dp[l1][l2];
    }
    
    public static void main(String[] args) {
        String S = "rabbbit";
        String T = "rabbit";
        
        System.out.println(new Solution().numDistinct(S, T));
    }
}
