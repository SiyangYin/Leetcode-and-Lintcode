public class Solution {
    /**
     * @param n: a positive integer n
     * @return: the maximum product you can get
     */
    public int integerBreak(int n) {
        // Write your code here
        int[] dp = new int[n + 1];
    
        for (int i = 2; i <= n; i++) {
            dp[i] = i - 1;
            for (int j = 2; j <= i - 2; j++) {
                dp[i] = Math.max(dp[i], j * dp[i - j]);
                dp[i] = Math.max(dp[i], j * (i - j));
            }
        }
        
        return dp[n];
    }
}
