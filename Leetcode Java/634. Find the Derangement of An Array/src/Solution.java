public class Solution {
    public int findDerangement(int n) {
        int MOD = (int) (1E9 + 7);
        long[] dp = new long[2];
        dp[0] = 1;
        dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            dp[i & 1] = (i - 1) * (dp[i - 1 & 1] + dp[i - 2 & 1]);
            dp[i & 1] %= MOD;
        }
        
        return (int) dp[n & 1];
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().findDerangement(2));
    }
}
