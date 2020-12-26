public class Solution {
    /**
     * @param n: An integer
     * @return: An Integer
     */
    public int climbStairs2(int n) {
        // write your code here
        if (n == 0 || n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
    
        for (int i = 4; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }
        
        return dp[n];
    }
}
