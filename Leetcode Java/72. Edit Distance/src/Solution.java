public class Solution {
    public int minDistance(String word1, String word2) {
        int l1 = word1.length();
        int l2 = word2.length();
        
        int[][] dp = new int[l1 + 1][l2 + 1];
        dp[0][0] = 0;
    
        for (int i = 0; i < l1 + 1; i++) {
            for (int j = 0; j < l2 + 1; j++) {
                if (i == 0) {
                    dp[0][j] = j;
                } else if (j == 0) {
                    dp[i][0] = i;
                } else {
                    if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else {
                        int replace = 1 + dp[i - 1][j - 1];
                        int delete = 1 + dp[i - 1][j];
                        int insert = 1 + dp[i][j - 1];
                        dp[i][j] = Math.min(replace, Math.min(delete, insert));
                    }
                }
            }
        }
        
        return dp[l1][l2];
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().minDistance("horse", "ros"));
    }
}
