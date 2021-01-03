public class Solution {
    /**
     * @param steps: steps you can move
     * @param arrLen: the length of the array
     * @return: Number of Ways to Stay in the Same Place After Some Steps
     */
    public int numWays(int steps, int arrLen) {
        // write your code here
        int MOD = (int) (1E9 + 7);
        int[][] dp = new int[2][Math.min(arrLen, steps / 2 + 1)];
        dp[0][0] = 1;
    
        for (int i = 1; i <= steps; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i & 1][j] = dp[i - 1 & 1][j];
                if (j - 1 >= 0) {
                    dp[i & 1][j] += dp[i - 1 & 1][j - 1];
                    dp[i & 1][j] %= MOD;
                }
                if (j + 1 < dp[0].length) {
                    dp[i & 1][j] += dp[i - 1 & 1][j + 1];
                    dp[i & 1][j] %= MOD;
                }
            }
        }
        
        return dp[steps & 1][0];
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().numWays(3, 2));
    }
}
