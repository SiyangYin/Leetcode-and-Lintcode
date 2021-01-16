public class Solution {
    public int getMaximumGenerated(int n) {
        if (n <= 1) {
            return n;
        }
        
        int res = 0;
        
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = i % 2 == 0 ? dp[i >> 1] : dp[i >> 1] + dp[(i >> 1) + 1];
            res = Math.max(res, dp[i]);
        }
        
        return res;
    }
}
