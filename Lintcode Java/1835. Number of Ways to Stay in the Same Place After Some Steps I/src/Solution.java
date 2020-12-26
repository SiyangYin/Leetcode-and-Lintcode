public class Solution {
    /**
     * @param steps:  steps you can move
     * @param arrLen: the length of the array
     * @return: Number of Ways to Stay in the Same Place After Some Steps
     */
    public int numWays(int steps, int arrLen) {
        // write your code here
        int len = Math.min(steps + 1, arrLen), MOD = (int) (1E9 + 7);
        int[][] dp = new int[steps + 1][len];
        
        dp[0][0] = 1;
        
        for (int i = 1; i <= steps; i++) {
            for (int j = 0; j < len; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j > 0) {
                    dp[i][j] += dp[i - 1][j - 1];
                    dp[i][j] %= MOD;
                }
                if (j < len - 1) {
                    dp[i][j] += dp[i - 1][j + 1];
                    dp[i][j] %= MOD;
                }
            }
        }
        
        return dp[steps][0];
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().numWays(40, 5));
    }
}
